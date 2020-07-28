package com.xuegao.multi_thread2.atomic.exchanger;

import java.util.concurrent.Exchanger;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.exchanger
 * <br/> @ClassName：ExchangerTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/24 10:58
 */
public class ExchangerTest {
    public static final Exchanger<Integer> transExchanger = new Exchanger<>();

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            // 伪代码
            Integer transA = 1000;
            try {
                Integer transFromB = transExchanger.exchange(transA);
                System.out.println("我是系统A：我系统中统计的交易额为：" + transA + " 我在交易系统中产生的交易额为：" + transFromB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(() -> {
            // 伪代码
            Integer transB = 1001;
            try {
                Integer transFromA = transExchanger.exchange(transB);
                System.out.println("我是交易系统：系统A统计出的交易额为：" + transB + " 系统A实际在我这里产生的交易额为：" + transFromA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();
    }
}