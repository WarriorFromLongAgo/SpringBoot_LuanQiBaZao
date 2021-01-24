package com.xuegao.multi_thread2.juc.atomic;

import com.xuegao.multi_thread2.domain.BankCard;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.atomic
 * <br/> @ClassName：AtomicReferenceTest1_安全的_1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/24 11:58
 */
public class AtomicReferenceTest1_安全的_3 {
    private static AtomicReference<BankCard> bankCardRef = new AtomicReference<>(new BankCard("cxuan", 100));

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    // 使用 AtomicReference.get 获取
                    final BankCard card = bankCardRef.get();
                    BankCard newCard = new BankCard(card.getAccountName(), card.getMoney() + 100);
                    // 使用 CAS 乐观锁进行非阻塞更新
                    if (bankCardRef.compareAndSet(card, newCard)) {
                        System.out.println(newCard);
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}