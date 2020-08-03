package com.xuegao.video_conver.javautil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.javautil
 * <br/> @ClassName：Collections
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/1 18:41
 */
public class Collections {
    public static void main(String[] args) {
        // collectionsSort1();
        collectionsSort2();
    }

    private static void collectionsSort2() {
        List<Date> dateArrList = new ArrayList<>();
        Date date1 = new Date(2020, 3, 3, 10, 10, 10);
        Date date2 = new Date(2020, 2, 2, 10, 10, 10);
        Date date3 = new Date(2020, 1, 1, 10, 10, 10);
        dateArrList.add(date1);
        dateArrList.add(date2);
        dateArrList.add(date3);
        java.util.Collections.sort(dateArrList, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                if (o1.after(o2)) {
                    return 1;
                } else if (o1.before(o2)) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(dateArrList);
    }

    private static void collectionsSort1() {
        List<Integer> intArrList = new ArrayList<>();
        intArrList.add(5);
        intArrList.add(3);
        intArrList.add(2);
        intArrList.add(1);
        java.util.Collections.sort(intArrList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(intArrList);
    }
}