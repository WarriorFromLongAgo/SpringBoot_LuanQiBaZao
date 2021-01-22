package com.xuegao.video_conver.execl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.xuegao.video_conver.domain.UserInfo;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.execl
 * <br/> @ClassName：GenerateExcel
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/21 14:45
 */
public class GenerateExcel {
    static String path = "";

    public static void main(String[] args) {
        simpleWrite();
    }

    public static void simpleWrite() {
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        exportExcel("D:\\nfsc\\KMS\\train.file\\classfile\\",
                System.currentTimeMillis() + ".xlsx",
                "asda",
                data(),
                UserInfo.class
        );
    }

    private static List<UserInfo> data() {
        List<UserInfo> date = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("ajsdhjs");
        userInfo.setUsername("asjkdhja");
        userInfo.setCreateTime(new Date());

        return date;
    }

    public static void exportExcel(String path, String fileName, String sheetName, List<?> dateList, Class head) {
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为红色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteFont.setBold(false);
        headWriteCellStyle.setWriteFont(headWriteFont);
        headWriteCellStyle.setShrinkToFit(true);

        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        contentWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 12);
        // 垂直居中,水平居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 表格线
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);

        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        try {
            EasyExcelFactory
                    .write(new FileOutputStream(path + fileName), head)
                    // 注册上面的头样式，内容样式
                    .registerWriteHandler(horizontalCellStyleStrategy)
                    // 自动扩展列的长度
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    .sheet(sheetName)
                    .doWrite(dateList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}