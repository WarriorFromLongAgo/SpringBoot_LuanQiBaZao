package com.xuegao.video_conver.pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/10 0:30
 */
public class SplitPdf2 {
    private static final String PDF_PATH = "E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战.pdf";


    public static void main(String[] args) throws IOException {
        File file = new File(PDF_PATH);
        PDDocument document = PDDocument.load(file, MemoryUsageSetting.setupTempFileOnly());
        Splitter splitter = new Splitter();


        System.out.println("Multiple PDF’s created");

    }
}