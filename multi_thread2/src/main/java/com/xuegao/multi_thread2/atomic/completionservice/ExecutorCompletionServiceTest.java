package com.xuegao.multi_thread2.atomic.completionservice;

import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completionservice
 * <br/> @ClassName：ExecutorCompletionServiceTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 19:55
 */
public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        System.out.println("约几个妹子一起吃个饭吧。");
        completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小红：好的，哥哥。我化妆要2个小时。等一下哦。");
                TimeUnit.SECONDS.sleep(15);
                System.out.println("小红：我2个小时准时化好了，哥哥来接我吧。");
                return "小红化完了。";
            }
        });
        completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小媛：好的，哥哥。我化妆要30分钟。等一下哦。");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("小媛：我30分钟准时化好了，哥哥来接我吧。");
                return "小媛化完了。";
            }
        });
        completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小花：好的，哥哥。我化妆要1个小时。等一下哦。");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("小花：我1个小时准时化好了，哥哥来接我吧。");
                return "小花化完了。";
            }
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println("都通知完,等着吧。");
        //循环3次是因为上面提交了3个异步任务
        for (int i = 0; i < 3; i++) {
            String returnStr = completionService.take().get();
            System.out.println(returnStr + "我去接她");
        }
        Thread.currentThread().join();

        // 约几个妹子一起吃个饭吧。
        // 小红：好的，哥哥。我化妆要2个小时。等一下哦。
        // 小媛：好的，哥哥。我化妆要30分钟。等一下哦。
        // 小花：好的，哥哥。我化妆要1个小时。等一下哦。
        // 都通知完,等着吧。
        // 小媛：我30分钟准时化好了，哥哥来接我吧。
        // 小媛化完了。我去接她
        // 小花：我1个小时准时化好了，哥哥来接我吧。
        // 小花化完了。我去接她
        // 小红：我2个小时准时化好了，哥哥来接我吧。
        // 小红化完了。我去接她


        // 谁先完成，谁打印


        // 作者：why技术
        // 链接：https://juejin.im/post/6861505662741676039
        // 来源：掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


        // 原理分析完了，说一个需要注意的地方。
        // 当你的使用场景是不关心返回值的时候千万不要闲的蛋疼的用 CompletionService 去提交任务。
        // 为什么？
        // 因为前面说了，里面有个队列。而当你不关心返回值的时候也就是不会去处理这个队列，导致这个队列里面的对象堆积的越来越多。
        // 最后，炸了，OOM了。


    }
}