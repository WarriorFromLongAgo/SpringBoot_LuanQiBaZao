package com.xuegao.video_conver.pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/10 0:30
 */
public class SplitPdf {
    private static final String PDF_PATH = "E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战.pdf";


    public static void main(String[] args) throws IOException {
        File file = new File(PDF_PATH);
        PDDocument document = PDDocument.load(file, MemoryUsageSetting.setupTempFileOnly());
        PDPageTree pages = document.getPages();
        int index = 1;

        int pageSize = 10;
        PDDocument pdDocument = new PDDocument();
        for (PDPage page : pages) {
            if (pageSize <= 0) {
                pdDocument.save("E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战" + index + ".pdf");
                index++;
                pdDocument = new PDDocument();
                pageSize = 50;
            }
            pdDocument.addPage(page);
            pageSize--;
        }


    }
}