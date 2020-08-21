package com.xuegao.video_conver.filedeal;

import cn.hutool.json.JSONObject;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.video_conver.filedeal
 * <br/> @ClassName：ListenFileChange
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/21 9:43
 */
public class ListenFileChange {
    private final static Logger log = LoggerFactory.getLogger(ListenFileChange.class);

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "定时任务 1");
                return thread;
            }
        });

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println("----------------------name--------------------------" + name);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
    // 问题抽象出来之后，对应的解决方案就比较清晰了
    //
    // 如何轮询 ？ --》 定时器 Timer, ScheduledExecutorService 都可以实现
    // 如何判断文件修改？ --》根据 java.io.File#lastModified 获取文件的上次修改时间，比对即可
    //
    // 作者：一灰灰
    // 链接：https://juejin.im/post/6844903561449439240
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    private static long lastTime;

    public static void file1() {

        File file = new File("/tmp/alarmConfig");

        // 首先文件的最近一次修改时间戳
        lastTime = file.lastModified();

        // 定时任务，每秒来判断一下文件是否发生变动，即判断lastModified是否改变
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "定时任务 1");
                return thread;
            }
        });

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (file.lastModified() > lastTime) {
                    System.out.println("file update! time : " + file.lastModified());
                    lastTime = file.lastModified();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ttt() {
        throw new NullPointerException();
    }

    public static void file2() {

        File file = new File("/tmp/alarmConfig");

        lastTime = file.lastModified();

        // 定时任务，每秒来判断一下文件是否发生变动，即判断lastModified是否改变
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "定时任务 1");
                return thread;
            }
        });
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (file.lastModified() > lastTime) {
                    System.out.println("file update! time : " + file.lastModified());
                    lastTime = file.lastModified();
                    ttt();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


        try {
            Thread.sleep(1000 * 60 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // jdk 7 文件监听
    public void testFileUpWather() throws IOException {
        // // 说明，这里的监听也必须是目录
        // Path path = Paths.get("/tmp");
        // WatchService watcher = FileSystems.getDefault().newWatchService();
        // path.register(watcher, ENTRY_MODIFY);
        //
        // new Thread(() -> {
        //     try {
        //         while (true) {
        //             WatchKey key = watcher.take();
        //             for (WatchEvent<?> event : key.pollEvents()) {
        //                 if (event.kind() == OVERFLOW) {
        //                     //事件可能lost or discarded
        //                     continue;
        //                 }
        //                 Path fileName = (Path) event.context();
        //                 System.out.println("文件更新: " + fileName);
        //             }
        //             if (!key.reset()) { // 重设WatchKey
        //                 break;
        //             }
        //         }
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }).start();
        //
        //
        // try {
        //     Thread.sleep(1000 * 60 * 10);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }

}

// 直接查看ScheduledExecutorService的源码注释说明
//
// If any execution of the task encounters an exception, subsequent executions are suppressed.Otherwise,
// the task will only terminate via cancellation or termination of the executor.
// 即如果定时任务执行过程中遇到发生异常，则后面的任务将不再执行。
// 所以，使用这种姿势的时候，得确保自己的任务不会抛出异常，否则后面就没法玩了
// 对应的解决方法也比较简单，整个catch一下就好
class PropertiesConfListenerHelper {
    private final static Logger log = LoggerFactory.getLogger(PropertiesConfListenerHelper.class);

    // public static boolean registerConfChangeListener(File file, Function<File, Map<String, AlarmConfig>> func) {
    //     try {
    //         // 轮询间隔 5 秒
    //         long interval = TimeUnit.SECONDS.toMillis(5);
    //
    //
    //         // 因为监听是以目录为单位进行的，所以这里直接获取文件的根目录
    //         File dir = file.getParentFile();
    //
    //         // 创建一个文件观察器用于过滤
    //         FileAlterationObserver observer = new FileAlterationObserver(dir,
    //                 FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
    //                         FileFilterUtils.nameFileFilter(file.getName())));
    //
    //         //设置文件变化监听器
    //         // observer.addListener(new MyFileListener(func));
    //         FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
    //         monitor.start();
    //
    //         return true;
    //     } catch (Exception e) {
    //         log.error("register properties change listener error! ", e);
    //         return false;
    //     }
    // }


    static final class MyFileListener extends FileAlterationListenerAdaptor {

        // private Function<File, Map<String, AlarmConfig>> func;
        //
        // public MyFileListener(Function<File, Map<String, AlarmConfig>> func) {
        //     this.func = func;
        // }

        @Override
        public void onFileChange(File file) {
            // Map<String, AlarmConfig> ans = func.apply(file); // 如果加载失败，打印一条日志
            Map<String, String> map = new HashMap<>();
            log.warn("PropertiesConfig changed! reload ans: {}", map.toString());
        }
    }
}

