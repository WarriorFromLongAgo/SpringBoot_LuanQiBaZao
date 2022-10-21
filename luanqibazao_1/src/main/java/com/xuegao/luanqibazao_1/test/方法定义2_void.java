package com.xuegao.luanqibazao_1.test;

public class 方法定义2_void {
    static void 返回void类型的方法名safjkdshfjdskhjfksdkjjhdskfsjkdkjsflkdsjklsfdaa(int aaa) {
        if (aaa == 1) {
            // 如果不写 return;，那么会打印，下面的俩行
            // return;
            // dasdsasad

            // 如果写 return;，那么会打印，下面的1行
            // return;

            System.out.println(" return; ");
            return;
        }
        System.out.println("dasdsasad");
    }

    public static void main(String[] args) {
        int aaa = 1;
        返回void类型的方法名safjkdshfjdskhjfksdkjjhdskfsjkdkjsflkdsjklsfdaa(aaa);
    }


}
