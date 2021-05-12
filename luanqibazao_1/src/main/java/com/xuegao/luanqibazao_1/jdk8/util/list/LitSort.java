package com.xuegao.luanqibazao_1.jdk8.util.list;

import cn.hutool.system.oshi.OshiUtil;
import com.alibaba.fastjson.JSON;
import com.xuegao.luanqibazao_1.domain.CustomerStorageFee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.list
 * <br/> @ClassName：LitSort
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/10 15:33
 */
public class LitSort {
    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        String json = "[{'applyAuditTime':1620630972000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma5','createdBy':'System','creationDate':1620631043000,'customerId':96,'enabledFlag':1,'id':58,'month':'2021-1','monthlyRent':100.0000,'oaNumber':'danjubianma5','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma5','updatedBy':'System','updationDate':1620631043000},{'applyAuditTime':1620634177000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma10','createdBy':'System','creationDate':1620634182000,'customerId':96,'enabledFlag':1,'id':82,'month':'2021-10','monthlyRent':100.0000,'oaNumber':'danjubianma10','rowAuthCustom':true,'storageFee':120.0000,'storageNumber':'changdibianma10','updatedBy':'System','updationDate':1620634182000},{'applyAuditTime':1620630972000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma6','createdBy':'System','creationDate':1620631043000,'customerId':96,'enabledFlag':1,'id':59,'month':'2021-2','monthlyRent':100.0000,'oaNumber':'danjubianma6','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma6','updatedBy':'System','updationDate':1620631043000},{'applyAuditTime':1620630972000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma7','createdBy':'System','creationDate':1620631043000,'customerId':96,'enabledFlag':1,'id':60,'month':'2021-3','monthlyRent':100.0000,'oaNumber':'danjubianma7','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma7','updatedBy':'System','updationDate':1620631043000},{'applyAuditTime':1620630972000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma8','createdBy':'System','creationDate':1620631043000,'customerId':96,'enabledFlag':1,'id':61,'month':'2021-4','monthlyRent':100.0000,'oaNumber':'danjubianma8','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma8','updatedBy':'System','updationDate':1620631043000},{'applyAuditTime':1620631133000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma5','createdBy':'System','creationDate':1620631137000,'customerId':96,'enabledFlag':1,'id':64,'month':'2021-5','monthlyRent':100.0000,'oaNumber':'danjubianma5','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma5','updatedBy':'System','updationDate':1620631137000},{'applyAuditTime':1620631133000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma6','createdBy':'System','creationDate':1620631137000,'customerId':96,'enabledFlag':1,'id':65,'month':'2021-6','monthlyRent':100.0000,'oaNumber':'danjubianma6','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma6','updatedBy':'System','updationDate':1620631137000},{'applyAuditTime':1620631133000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma7','createdBy':'System','creationDate':1620631137000,'customerId':96,'enabledFlag':1,'id':66,'month':'2021-7','monthlyRent':100.0000,'oaNumber':'danjubianma7','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma7','updatedBy':'System','updationDate':1620631137000},{'applyAuditTime':1620631133000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma8','createdBy':'System','creationDate':1620631137000,'customerId':96,'enabledFlag':1,'id':67,'month':'2021-8','monthlyRent':100.0000,'oaNumber':'danjubianma8','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma8','updatedBy':'System','updationDate':1620631137000},{'applyAuditTime':1620631133000,'applyId':593436,'applyName':'fjm','contractNumber':'hetongbianma9','createdBy':'System','creationDate':1620631137000,'customerId':96,'enabledFlag':1,'id':68,'month':'2021-9','monthlyRent':100.0000,'oaNumber':'danjubianma9','rowAuthCustom':true,'storageFee':200.0000,'storageNumber':'changdibianma9','updatedBy':'System','updationDate':1620631137000}]";

        List<CustomerStorageFee> customerStorageFeeList = JSON.parseArray(json, CustomerStorageFee.class);
        // customerStorageFeeList = customerStorageFeeList
        //         .stream()
        //         .sorted(new Comparator<CustomerStorageFee>() {
        //             @Override
        //             public int compare(CustomerStorageFee o1, CustomerStorageFee o2) {
        //                 String[] o1MonthArr = o1.getMonth().split("-");
        //                 String[] o2MonthArr = o2.getMonth().split("-");
        //                 int o1Year = Integer.parseInt(o1MonthArr[0]);
        //                 int o1Month = Integer.parseInt(o1MonthArr[1]);
        //                 int o2Year = Integer.parseInt(o2MonthArr[0]);
        //                 int o2Month = Integer.parseInt(o2MonthArr[1]);
        //                 if (o1Year > o2Year) {
        //                     return 1;
        //                 } else if (o1Year == o2Year) {
        //                     if (o1Month > o2Month) {
        //                         return 1;
        //                     } else {
        //                         return 0;
        //                     }
        //                 } else {
        //                     return 0;
        //                 }
        //             }
        //         })
        //         .collect(Collectors.toList());
        // customerStorageFeeList.forEach(customerStorageFee -> System.out.println(customerStorageFee.getMonth()));

        customerStorageFeeList = customerStorageFeeList
                .stream()
                .sorted(new Comparator<CustomerStorageFee>() {
                    @Override
                    public int compare(CustomerStorageFee o1, CustomerStorageFee o2) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                        try {
                            String o1Month = o1.getMonth();
                            String o2Month = o2.getMonth();
                            Date date1 = format.parse(o1Month);
                            Date date2 = format.parse(o2Month);
                           return date1.compareTo(date2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println(0);
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        customerStorageFeeList.forEach(customerStorageFee -> System.out.println(customerStorageFee.getMonth()));
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