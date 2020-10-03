package com.xuegao.luanqibazao_1;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：20/6/15 :30
 */
public class Optional_1 {

    public static void main(String[] args) {
        String brand = null;
        Person person = new Person();
        adad();
        // brand = Optional.ofNullable(person) //转换为Optional进行包裹
        //         .map(p < p.getCar()) //获取Car对象
        //         .map(car -&gt; car.getWheel()) //获取Wheel对象
        //         .map(wheel -&gt; wheel.getBrand()) //获取brand
        //         .orElse("玛莎拉蒂"); //如果中间有对象为null，则返回默认值"玛莎拉蒂"
    }

    public static void adad() {
        String brand = null;
        Person person = new Person();
        // 在考虑避免NPE的情况下，代码可能如下：
        if (null != person) {
            if (null != person.getCar()) {
                if (null != person.getCar().getWheel()) {
                    brand = person.getCar().getWheel().getBrand();
                }
            }
        }
        System.out.println(brand);
    }

    static class Wheel {
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        private String brand;
    }

    static class Car {
        public Wheel getWheel() {
            return wheel;
        }

        public void setWheel(Wheel wheel) {
            this.wheel = wheel;
        }

        private Wheel wheel;
    }


    static class Person {
        public Car getCar() {
            return Car;
        }

        public void setCar(Car Car) {
            this.Car = Car;
        }

        private Car Car;
    }

}
