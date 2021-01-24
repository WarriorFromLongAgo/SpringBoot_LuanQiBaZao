package com.xuegao.multi_thread2.juc.atomic;

import com.xuegao.multi_thread2.domain.BankCard;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.atomic
 * <br/> @ClassName：AtomicReferenceTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/24 11:55
 */
public class AtomicReferenceTest1_不安全的 {
    private static volatile BankCard bankCard = new BankCard("cxuan", 100);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
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
            }).start();
        }

        // BankCard{accountName='cxuan', money='200'}
        // BankCard{accountName='cxuan', money='200'}
        // BankCard{accountName='cxuan', money='200'}
        // BankCard{accountName='cxuan', money='300'}
        // BankCard{accountName='cxuan', money='400'}
        // BankCard{accountName='cxuan', money='500'}
        // BankCard{accountName='cxuan', money='600'}
        // BankCard{accountName='cxuan', money='600'}
        // BankCard{accountName='cxuan', money='700'}
        // BankCard{accountName='cxuan', money='800'}
        // 线程不安全的

    }
}