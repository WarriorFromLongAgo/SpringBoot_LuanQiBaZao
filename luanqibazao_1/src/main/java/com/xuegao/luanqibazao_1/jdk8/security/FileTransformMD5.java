package com.xuegao.luanqibazao_1.jdk8.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：FileTransformMD5
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 14:40
 */
public class FileTransformMD5 {
    public static void main(String[] args) {
        File file = new File("D:\\user\\downloads\\yulan.pptx");
        String md5 = getMD5(file);
        System.out.println(md5);
    }

    public static String getMD5(File file) {
        BigInteger MD5 = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(file);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            MD5 = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MD5.toString(16);
    }
}