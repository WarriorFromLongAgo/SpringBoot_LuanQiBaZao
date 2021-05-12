package com.xuegao.luanqibazao_1.jdk8.util.uuid;

import java.util.UUID;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.uuid
 * <br/> @ClassName：UuidTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/6 16:42
 */
public class UuidTest {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.print(uuid + "-----------");
        String replace = uuid.replace("-", "");
        System.out.println(replace);

    }
}