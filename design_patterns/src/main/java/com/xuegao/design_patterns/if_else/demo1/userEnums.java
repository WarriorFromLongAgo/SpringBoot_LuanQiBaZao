package com.xuegao.design_patterns.if_else.demo1;

/**
 * <br/> @PackageName：com.fff.if_else.demo1
 * <br/> @ClassName：userEnums
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/4/5 15:28
 */
public class userEnums {
    public static void main(String[] args) {
        int orderStatus = 1;
        String OrderStatusDes = OrderStatusEnum.of(orderStatus).getDesc();
    }
}