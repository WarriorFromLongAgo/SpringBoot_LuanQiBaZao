package com.xuegao.multi_thread2.atomic.future;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.future
 * <br/> @ClassName：FutureTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 19:49
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futureList = new ArrayList<>();
        System.out.println("约几个妹子一起吃个饭吧。");

        Future<String> future1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小红：好的，哥哥。我化妆要2个小时。等一下哦。");
                TimeUnit.SECONDS.sleep(15);
                System.out.println("小红：我2个小时准时化好了，哥哥来接我吧。");
                return "小红化完了。";
            }
        });
        futureList.add(future1);

        Future<String> future2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小媛：好的，哥哥。我化妆要30分钟。等一下哦。");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("小媛：我30分钟准时化好了，哥哥来接我吧。");
                return "小媛化完了。";
            }
        });
        futureList.add(future2);

        Future<String> future3 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("小花：好的，哥哥。我化妆要1个小时。等一下哦。");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("小花：我1个小时准时化好了，哥哥来接我吧。");
                return "小花化完了。";
            }
        });
        futureList.add(future3);
        TimeUnit.SECONDS.sleep(1);

        System.out.println("都通知完,等着吧。");
        for (Future<String> future : futureList) {
            System.out.println(future.get()+"我去接她。");
        }
        Thread.currentThread().join();

        // 作者：why技术
        // 链接：https://juejin.im/post/6861505662741676039
        // 来源：掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        // 约几个妹子一起吃个饭吧。
        // 小红：好的，哥哥。我化妆要2个小时。等一下哦。
        // 小媛：好的，哥哥。我化妆要30分钟。等一下哦。
        // 小花：好的，哥哥。我化妆要1个小时。等一下哦。
        // 都通知完,等着吧。
        // 小媛：我30分钟准时化好了，哥哥来接我吧。
        // 小花：我1个小时准时化好了，哥哥来接我吧。
        // 小红：我2个小时准时化好了，哥哥来接我吧。
        // 小红化完了。我去接她。
        // 小媛化完了。我去接她。
        // 小花化完了。我去接她。

        // 说好都是一样的普通朋友的，为什么你偏偏要一直等化妆时间最长的小红？为什么不谁动作快，就先接谁？
    }
}