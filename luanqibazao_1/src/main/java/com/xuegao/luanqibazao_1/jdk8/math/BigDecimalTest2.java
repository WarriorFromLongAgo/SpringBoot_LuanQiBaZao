package com.xuegao.luanqibazao_1.jdk8.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.math
 * <br/> @ClassName：BigDecimalTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/26 0:06
 */
public class BigDecimalTest2 {
    private static final Logger log = LoggerFactory.getLogger(BigDecimalTest2.class);

    public static void main(String[] args) {
        BigDecimal defaultDeclared = new BigDecimal("-1");
        if (new BigDecimal("0").compareTo(defaultDeclared) >= 0 || defaultDeclared.compareTo(new BigDecimal("300000")) > 0) {
            throw new RuntimeException("默认声明价值输入必须大于0并且小于等于300000");
        }
        System.out.println(defaultDeclared);
    }

    private static void extracted1() {
        BigDecimal bigDecimal = new BigDecimal("11.1111");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
        bigDecimal = new BigDecimal("11.145");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
        bigDecimal = new BigDecimal("11.146");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
        bigDecimal = new BigDecimal("11.155");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
        bigDecimal = new BigDecimal("11.156");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));

        bigDecimal = new BigDecimal("11.1");
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
    }

    private static void extracted() {
        Double customerYkgPrice = 10.0D;
        Double modifiedCustomerYkgPrice = getModifiedCustomerYkgPrice(customerYkgPrice);
        System.out.println(modifiedCustomerYkgPrice);
        log.info("getModifiedCustomerYkgPrice.for.ykgCheck : {} -> {}", customerYkgPrice, modifiedCustomerYkgPrice);
        if (modifiedCustomerYkgPrice >= 11.0D) {
            System.out.println("满足条件");
        } else {
            System.out.println("111满足条件");
        }
    }

    private static Double getModifiedCustomerYkgPrice(Double ykgPrice) {
        BigDecimal range = new BigDecimal("0.2");
        BigDecimal bigYkg = new BigDecimal(ykgPrice);
        BigDecimal afterFloat = range.add(new BigDecimal("1")).multiply(bigYkg).setScale(2, RoundingMode.FLOOR);
        return afterFloat.doubleValue();
    }


}