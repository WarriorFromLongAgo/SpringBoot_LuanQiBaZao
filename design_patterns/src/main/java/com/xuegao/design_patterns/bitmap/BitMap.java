package com.xuegao.design_patterns.bitmap;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.bitmap
 * <br/> @ClassName：Bitmap
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/1 0:33
 */
public class BitMap {

    // 优点：
    // 占用内存空间低，可以极大地节约空间；
    // 运算效率高，查找、去重都不需要遍历全部数据；
    //
    // 缺点：
    // 所有的数据不能重复，相当于直接就是排重过的；
    // 如果数据只有两个：1 和 10000000，使用 BitMap 得不偿失，只有当数据比较密集时才有优势。

    // 数据
    private byte[] bitArr;
    // 最大值
    private int maxValue;
    // 容量
    private int capacity;

    /**
     * <br/> @Title: 初始化
     * <br/> @MethodName:  BitMap
     * <br/> @param maxValue:
     * <br/> @Return
     * <br/> @Description:
     * <br/> @author: 花名：雪糕
     * <br/> @date:  2020/9/1 0:34
     */
    public BitMap(int maxValue) {
        this.maxValue = maxValue;
        // 1bit存储8个数据，存储最大值为 max_value 的数组需要 max_value/8+1 个 byte，除以8就是右移3位
        this.capacity = (maxValue >> 3) + 1;
        bitArr = new byte[capacity];
    }

    public void add(int num) {
        //数据保存在整个数组的哪个下标中
        int index = num / 8;
        //数据在这个下标元素的哪个位置
        int position = num % 8;

        bitArr[index] |= 1 << position;
    }


    public boolean contains(int num) {
        if (num > maxValue) {
            return false;
        }
        //数据保存在整个数组的哪个下标中
        int index = num / 8;
        //数据在这个下标元素的哪个位置
        int position = num % 8;
        return (bitArr[index] & 1 << position) != 0;
    }

    public static void main(String[] agrs) {
        BitMap bm = new BitMap(100);

        bm.add(1);
        bm.add(12);
        bm.add(14);
        bm.add(51);
        bm.add(71);
        bm.add(100);

        System.out.println("12:" + (bm.contains(12) ? "存在" : "不存在"));
        System.out.println("13:" + (bm.contains(13) ? "存在" : "不存在"));
        System.out.println("51:" + (bm.contains(51) ? "存在" : "不存在"));
        System.out.println("66:" + (bm.contains(66) ? "存在" : "不存在"));
        System.out.println("100:" + (bm.contains(100) ? "存在" : "不存在"));
    }
}