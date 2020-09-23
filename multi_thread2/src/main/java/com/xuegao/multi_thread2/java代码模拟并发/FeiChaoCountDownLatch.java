package com.xuegao.multi_thread2.java代码模拟并发;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：FeiChaoCountDownLatch
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/23 14:09
 */
public class FeiChaoCountDownLatch {
}

class CountDownLatchUtil {

    private CountDownLatch start;
    private CountDownLatch end;
    private int pollSize = 10;

    public CountDownLatchUtil() {
        this(10);
    }

    public CountDownLatchUtil(int pollSize) {
        this.pollSize = pollSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(pollSize);
    }

    public void latch(MyFunctionalInterface functionalInterface) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(pollSize);
        for (int i = 0; i < pollSize; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        functionalInterface.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            executorService.submit(run);
        }

        start.countDown();
        end.await();
        executorService.shutdown();
    }

    @FunctionalInterface
    public interface MyFunctionalInterface {
        void run();
    }
}
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class HelloServiceTest {
//
//     @Autowired
//     private HelloService helloService;
//
//     @Test
//     public void testSayHello() throws Exception {
//         long currentTimeMillis = System.currentTimeMillis();
//         //模拟1000个线程并发
//         CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil(1000);
//         countDownLatchUtil.latch(() -> {
//             helloService.sayHello(currentTimeMillis);
//         });
//     }
//
// }

// @Service
// public class HelloServiceImpl implements HelloService {
//
//     private final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
//
//     @Transactional
//     @Override
//     public void sayHello(long timeMillis) {
//         long time = System.currentTimeMillis() - timeMillis;
//         if (time > 5000) {
//             //超过5秒的打印日志输出
//             log.warn("time : {}", time);
//         }
//         try {
//             //模拟业务执行时间为1s
//             Thread.sleep(1000);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

// 作者：肥朝
// 链接：https://juejin.im/post/6844903859375226888
// 来源：掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。