package com.xuegao.luanqibazao_1.jdk8.awt;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.awt
 * <br/> @ClassName：RobotTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/9/30 23:28
 */
public class RobotTest2 {
    /**
     * @param args
     * @throws AWTException
     */
    public static void main(String[] args) throws Exception {
        //创建一个robot对象
        Robot robot = new Robot();
        //等待 10 秒
        robot.delay(2 * 1000);
        while (true) {
            System.out.println("======================================");
            System.out.println("开始一次循环");
            int i = new Random().nextInt(10) + 1;
            keyPressWithCtrl(robot, iiii(i));
            keyPress(robot, KeyEvent.VK_F5);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String format = LocalDateTime.now().format(formatter);
            System.out.println("执行时间 = " + format);
            TimeUnit.SECONDS.sleep(i * 5);
            System.out.println("结束一次循环 i = " + i);
            System.out.println("======================================");
        }
    }

    // ctrl+ 按键
    public static void keyPressWithCtrl(Robot r, int key) {
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(100);
    }

    //单个 按键
    public static void keyPress(Robot r, int key) {
        r.keyPress(key);
        r.keyRelease(key);
        r.delay(100);
    }

    //单个 按键
    public static int iiii(int i) {
        int result = KeyEvent.VK_1;
        switch (i) {
            case 1:
                break;
            case 2:
                result = KeyEvent.VK_2;
                break;
            case 3:
                result = KeyEvent.VK_3;
                break;
            case 4:
                result = KeyEvent.VK_4;
                break;
            case 5:
                result = KeyEvent.VK_5;
                break;
            case 6:
                result = KeyEvent.VK_6;
                break;
            case 7:
                result = KeyEvent.VK_7;
                break;
            case 8:
                result = KeyEvent.VK_8;
                break;
            case 9:
                result = KeyEvent.VK_9;
                break;
            default:
        }
        return result;
    }
}

