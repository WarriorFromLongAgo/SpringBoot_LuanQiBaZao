package com.xuegao.multi_thread2.juc.atomic;

import com.xuegao.multi_thread2.domain.BankCard;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.atomic
 * <br/> @ClassName：AtomicReferenceTest1_安全的_1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/24 11:58
 */
public class AtomicReferenceTest1_安全的_1 {
    private static volatile BankCard bankCard = new BankCard("cxuan", 100);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (AtomicReferenceTest1_安全的_1.class) {
                    // 先读取全局的引用
                    final BankCard card = bankCard;
                    // 构造一个新的账户，存入一定数量的钱
                    BankCard newCard = new BankCard(card.getAccountName(), card.getMoney() + 100);
                    System.out.println(newCard);
                    // 最后把新的账户的引用赋给原账户
                    bankCard = newCard;
                    try {
                        TimeUnit.MICROSECONDS.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}