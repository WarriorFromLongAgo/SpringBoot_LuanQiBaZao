package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import java.text.Collator;
import java.util.*;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.lamada
 * <br/> @ClassName：collect
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/19 14:08
 */
public class collect {
    public static void main(String[] args) {
        String str = "1:阿里巴巴;2:京东;3:有赞;4:蚂蚁金服;5:网易;6:顺丰科技;7:蘑菇街;8:唯品会;9:拼多多;10:同花顺;";
        System.out.println(Sort(str));
    }
    static String Sort(String string){
        String [] options = string.split(";");
        StringBuffer strSort = new StringBuffer();
        Map<String, String> sort = new HashMap<>();
        List<String> list = new ArrayList<>();
        //把快递公司名称与对应的值存入map
        for(String x:options){
            String[] arr = x.split(":");
            sort.put(arr[1], arr[0]);//"公司名称"："value"
            list.add(arr[1]); //“公司名称”
        }
        System.out.println("========================");
        System.out.println(list);
        //使用集合框架Collections提供的sort方法，传入list和comparator
        Collections.sort(list, Collator.getInstance(Locale.CHINA));
        System.out.println(list);
        System.out.println("========================");
        for(String str:list){
            strSort.append(sort.get(str)+":"+str+";");
        }
        return strSort.toString();
    }
}