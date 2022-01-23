package com.xuegao.luanqibazao_1.jdk8.io.bio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/23 17:26
 */
public class PrintWriterTest {
    private static final File FILE = new File("D:\\tong_hang_bao_jia_dao_ru\\sql.sql");

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(FILE);
        String sql = "insert into user(id,name,age) values(1,'xuegao',18);";
        sql += "\n";
        sql += "insert into user(id,name,age) values(2,'xuegao',18);";
        printWriter.println(sql);
        printWriter.close();
    }
}