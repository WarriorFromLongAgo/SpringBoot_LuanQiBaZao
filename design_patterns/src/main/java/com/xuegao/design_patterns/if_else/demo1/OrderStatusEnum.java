package com.xuegao.design_patterns.if_else.demo1;

public enum OrderStatusEnum {
    UN_PAID(0, "订单未支付"),
    PAIDED(1, "订单已支付"),
    SENDED(2, "已发货"),
    ;

    private int index;

    private String desc;


    public int getIndex() {
        return index;
    }


    public String getDesc() {
        return desc;
    }


    OrderStatusEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    static OrderStatusEnum of(int orderStatus) {
        for (OrderStatusEnum temp : OrderStatusEnum.values()) {
            if (temp.getIndex() == orderStatus) {
                return temp;
            }
        }
        return null;
    }
}