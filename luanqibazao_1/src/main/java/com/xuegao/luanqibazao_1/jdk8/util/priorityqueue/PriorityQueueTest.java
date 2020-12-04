package com.xuegao.luanqibazao_1.jdk8.util.priorityqueue;

import java.util.PriorityQueue;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.PriorityQueueTest
 * <br/> @ClassName：PriorityQueueTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 2:51
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        queue.add(5);
        queue.add(1);
        queue.add(10);
        queue.add(50);
        queue.add(8);

        // 左边出队列，删除
        System.out.println("初始队列: " + queue);
        System.out.println("出队: " + queue.poll());
        System.out.println("当前队列: " + queue);
        System.out.println("出队: " + queue.poll());
        System.out.println("当前队列: " + queue);
        // 初始队列: [1, 5, 10, 50, 8]
        // 出队: 1
        // 当前队列: [5, 8, 10, 50]
        // 出队: 5
        // 当前队列: [8, 50, 10]

        // 左边出队列，但是不删除
        System.out.println("右边出队" + queue.peek());
        System.out.println("当前队列: " + queue);
        System.out.println("右边出队" + queue.peek());
        System.out.println("当前队列: " + queue);
        // 左边出队 1
        // 当前队列: [1, 5, 10, 50, 8]
        // 左边出队 1
        // 当前队列: [1, 5, 10, 50, 8]

    }
}