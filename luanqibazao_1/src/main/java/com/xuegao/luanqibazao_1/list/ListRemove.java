package com.xuegao.luanqibazao_1.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.list
 * <br/> @ClassName：ListRemove
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/16 16:27
 */
public class ListRemove {
    public static void main(String[] args) {
        // listRemoveTest1();

        listRemoveTest2();

    }

    // 1
    // Exception in thread "main" java.util.ConcurrentModificationException
    // at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
    // at java.util.ArrayList$Itr.next(ArrayList.java:859)
    // at com.xuegao.luanqibazao_1.list.ListRemove.listRemoveTest1(ListRemove.java:23)
    // at com.xuegao.luanqibazao_1.list.ListRemove.main(ListRemove.java:16)
    private static void listRemoveTest1() {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("1", "2", "3"));
        for (String s : stringList) {
            System.out.println(s);
            stringList.remove(s);
        }
    }

    private static void listRemoveTest2() {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("1", "2", "3"));
        Iterator var3 = stringList.iterator();

        System.out.println(stringList);
        while (var3.hasNext()) {
            String str = (String) var3.next();
            if ("2".equals(str)) {
                var3.remove();
            }
        }
        System.out.println(stringList);

        // [1, 2, 3]
        // [1, 3]

        // 作者：沉默王二
        // 链接：https://juejin.im/post/6855464344436604942
        // 来源：掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}