package com.xuegao.video_conver.pdf;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/10 0:30
 */
public class SplitPdf2 {
    private static final String PDF_PATH = "E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战.pdf";
    private static int length = 1;

    public static void main(String[] args) throws IOException {
        File file = new File(PDF_PATH);
        // PDDocument document = PDDocument.load(file, MemoryUsageSetting.setupTempFileOnly());
        PDDocument document = PDDocument.load(file);
        Splitter splitter = new Splitter();
        List<PDDocument> pages = splitter.split(document);
        Iterator<PDDocument> iterator = pages.listIterator();

        PDDocument pdDocument = new PDDocument();
        int i = 1;
        while (iterator.hasNext()) {
            PDDocument tempPd = iterator.next();
            // pd.save("E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战" + i++ + ".pdf");
            pdDocument.addPage(tempPd.getPage(0));
            if (i > 100) {
                pdDocument.save("E:\\我的数据\\书籍PDF\\Spring5核心原理与30个类手写实战" + length++ + ".pdf");
                pdDocument.close();
                pdDocument = new PDDocument();
                i = 1;
                continue;
            }
            i++;
        }
        System.out.println("Multiple PDF’s created");
        document.close();
    }
}