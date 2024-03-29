package com.xuegao.luanqibazao_1.jdk8.util.list;

import com.xuegao.luanqibazao_1.domain.CoursesDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.list
 * <br/> @ClassName：LitSort
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/10 15:33
 */
public class LitSort {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            List<CoursesDTO> list = getList();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.sort(Comparator.comparing(CoursesDTO::getId));
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.sort(Comparator.comparing(CoursesDTO::getId));
                }
            }).start();
            TimeUnit.SECONDS.sleep(3L);
            System.out.println("=======================================");
        }
    }

    public static List<CoursesDTO> getList(){
        List<CoursesDTO> coursesDTOList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CoursesDTO coursesDTO = new CoursesDTO();
            coursesDTO.setId((long) i);
            List<String> capableList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                capableList.add(String.valueOf(j));
            }
            coursesDTO.setCapable(capableList);
            coursesDTOList.add(coursesDTO);
        }
        return coursesDTOList;
    }

    private static void aaa() {
        List<String> list = new ArrayList<>();
        list.add("2022-11");
        list.add("2022-10");
        for (int i = 1; i <= 2; i++) {
            list.add("2022-0" + i);
        }
        list.add("2020-11");
        list.add("2020-10");
        for (int i = 1; i <= 2; i++) {
            list.add("2020-0" + i);
        }
        list.add("2021-11");
        list.add("2021-10");
        for (int i = 1; i <= 2; i++) {
            list.add("2021-0" + i);
        }

        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                try {
                    Date date1 = format.parse(o1);
                    Date date2 = format.parse(o2);
                    if (date1.getTime() > date2.getTime()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });

        System.out.println(list);


        list = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(list);

        list = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                try {
                    Date date1 = format.parse(o1);
                    Date date2 = format.parse(o2);
                    if (date1.getTime() > date2.getTime()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        }).collect(Collectors.toList());
        System.out.println(list);
    }
}