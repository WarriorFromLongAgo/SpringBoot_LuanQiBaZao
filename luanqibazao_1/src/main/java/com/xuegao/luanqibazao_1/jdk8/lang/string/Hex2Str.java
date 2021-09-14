package com.xuegao.luanqibazao_1.jdk8.lang.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Hex2Str {
 
 
    public static String hex2UTF8(String hexStr) throws UnsupportedEncodingException {
        return URLDecoder.decode(hexStr.replaceAll("\\\\x", "%"), StandardCharsets.UTF_8.name());
    }
 
    public static String hex2GBK(String hexStr) throws UnsupportedEncodingException {
        return URLDecoder.decode(hexStr.replaceAll("\\\\x", "%"), "gbk");
    }
 
    public static void main(String[] args) throws Exception{
        String utf8String = "\\xe9\\xa3\\x8e\\xe5\\xa5\\xb3\\xe9\\x83\\x8e";
        System.out.println(hex2UTF8(utf8String));
        String utf8String2 = "\\x1F\\x8B\\x08\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x8C\\xDC\\x10\\xFD\\xD5\\x87\\xC9\\x86\\x92\\x90\\x9B\\x9C\\xB2\\xC8\\x92\\xBC\\xF1\\xDA\\x8B\\x17\\xC2\\x92\\xD3\\x08\\x94\\x16\\xED\\xA0\\xBD\\x94\\xF7\\xFF\\xBE\\xEA\\xE8\\xD8\\xDA\\xDD\\xD2\\x8C\\xDE\\xBC\\x19\\xCD\\xDD\\xEB\\x1A\\x8D\\x80\\xA6\\x10\\xAB\\x89\\x09\\xBA\\xFD\\xE2\\xEA\\xC7\\x9B\\x9B\\xB3\\xD7\\xE7\\xEF\\x7F\\x7F\\x7F\\x86\\x02\\xA4\\x03\\x05\\x8A\\x80\\x9C\\xAD\\xDB\\xA2\\xC9\\xFE\\xD9\\xB4\\x81\\x92\\xB2\\x0A\\x8F\\xAB\\xA7\\xC0\\xDC\\xF2\\xF5\\xD6\\xE4\\x15\\xE6\\xA8\\xC5\\xD1\\x93\\xC6\\x01\\x0E\\xC3\\xEB\\xD3\\x9F\\xFF\\xFB\\xE1\\xE6\\xE2\\x13\\xC0\\xA1\\xDC\\x01\\xEE\\x0C\\x1B\\x95\\xEE\\x09\\xF2\\xA6\\xBA\\xEF\\xCE\\xBF\\xFF\\xF5\\xF9\\xBB\\xD3\\xB2\\xB1\\xD3\\x15\\xCE\\xDF\\xBE\\xFC\\xEA\\xE9\\xD7\\xCA\\xF3\\xFB\\x80\\x9D\\xA9\\xE3\\xA2\\x06\\xB0\\xF3\\xE1\\x88\\xC7\\x19\\x0F\\x1C\\xA3\\x8C\\xEE\\xD6\\x8C\\xEC\\x83\\xC7\\xDC\\xD7\\xB2\\x22\\x9F\\x1C\\x9F\\xF6\\x93\\xFA\\xBC\\xBB\\x94\\x93\\x16\\x94\\xE2\\xCF\\xB6\\xE9\\x18\\x22\\xE2\\xDD\\xCE\\x95\\x16\\x96\\xD8\\xA4\\x11\\x1E\\xE4\\x94\\x9C\\x0D\\xD9\\xB6\\x9C\\xF5\\x95\\x97\\x8B\\x9E\\xF5\\xE1\\x8C\\xD0\\xAD\\x86\\xD5\\xD7\\x9D\\xDB\\xF7\\x97\\xE6\\xAF\\xFD\\xED\\xC5\\xE5\\xDD\\xE5\\xA2\\x81\\xE8\\x81\\xD2\\xAA\\xDB\\xA5\\xB3\\xBA\\xA6\\xF6\\x89\\x91\\xE8\\xAB\\x8F\\xFC\\x0F\\xB2\\xB0\\x94\\xA1\\x91\\xC5\\x0A\\x98\\xC4\\xA9\\xD2\\x94\\xA3\\x93\\x03\\xEB\\xBC\\x84\\x95\\xD5\\x04\\xA6\\xF8\\x01\\x81\\x1C\\x06\\xB1\\xC0\\x8B\\x1D\\x82\\xFB\\x9C\\xBC\\x88\\xE0\\xC4\\xDA\\xBA\\xF8\\xB6\\xCD\\xD2\\xCB\\x06\\xFD\\xB0\\x8B\\x0A\\x88\\x8F\\xB6\\xC1\\x0E\\xB0\\xCF\\xAD\\xAC\\xBC\\xD4\\xDA\\xD6\\x5C\\xA7\\x22\\x8C\\xCC\\x16\\x5C\\x8E\\x0E\\xC8\\xC5\\xFB\\x85\\x94\\xAC\\xE0\\x91\\x0A\\xB9\\xD0\\x89\\xB8\\x96\\xA9\\xD0\\x99\\xC8\\x18\\xCE\\xE2\\x22\\x1A\\x94\\x08\\x9D\\xB0\\x8C\\xA3\\x99\\x88\\x01\\x18\\x03\\xDB\\x08\\x12\\x0A\\x19\\x81\\x08\\x0C\\x9A\\xDF\\xF3\\xBD\\x02\\xFB\\xB7\\x03\\x1F\\xE4\\xFF\\x95\\xCD\\x96\\xA6\\xB3\\xEB\\xF2\\xE5\\x18\\x03\\x1C\\x0F\\x08\\x12\\x80\\x07\\x08\\xFA\\xF3\\x16\\xE7\\x04\\xF9\\x03\\x00\\x00\\xFF\\xFF\\x03\\x00\\x03\\x16\\x89\\x04\\x00\\x00";
        System.out.println(hex2UTF8(utf8String2));
    }
}
