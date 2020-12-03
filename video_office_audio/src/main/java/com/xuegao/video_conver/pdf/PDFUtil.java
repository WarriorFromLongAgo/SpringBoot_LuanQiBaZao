package com.xuegao.video_conver.pdf;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

/**
 * <br/> @PackageName：com.xuegao.video_conver.pdf
 * <br/> @ClassName：PDFUtil
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:19
 */
public class PDFUtil {
//     /**
//      * @param ftlName flt 名称
//      * @param root    数据封装
//      * @return ByteArrayOutputStream
//      */
//     @SuppressWarnings("deprecation")
//     public static ByteArrayOutputStream createPDF(HttpServletRequest request, String ftlName, Map<String, Object> root) throws Exception {
//         String basePath = request.getSession().getServletContext().getRealPath("/");// 绝对路径
//         Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
//         try {
//             cfg.setLocale(Locale.CHINA);
//             cfg.setEncoding(Locale.CHINA, "UTF-8");
//             // 设置编码
//             cfg.setDefaultEncoding("UTF-8");
//             // 设置模板路径
//             cfg.setDirectoryForTemplateLoading(new File(basePath + "/pages/templateftl/"));
//             // 获取模板
//             Template template = cfg.getTemplate(ftlName);
//             template.setEncoding("UTF-8");
//             Writer writer = new StringWriter();
//             // 数据填充模板
//             template.process(root, writer);
//             String str = writer.toString();
//             // pdf生成
//             DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//
//             ITextRenderer iTextRenderer = new ITextRenderer();
//             iTextRenderer.setDocumentFromString(str);
//
//             // 设置字体 其他字体需要添加字体库
//             ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
// 			/*
// 			String os = System.getProperty("os.name").toLowerCase();
// 			if ("linux".equals(os)) {
// 				fontResolver.addFont(basePath + "font"+File.separator+"arialuni.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
// 			} else {
// 				fontResolver.addFont(basePath + "font"+File.separator+"simsun.ttc",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
// 			}*/
//
//
//             fontResolver.addFont(basePath + File.separator + "font" + File.separator + "simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//             fontResolver.addFont(basePath + File.separator + "font" + File.separator + "arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
// //			InputStream inStream =new ByteArrayInputStream(str.getBytes());
// //			Document document = builder.parse(inStream);
// //			iTextRenderer.setDocument(document,null);
//             iTextRenderer.layout();
//             // 生成PDF
//             ByteArrayOutputStream baos = new ByteArrayOutputStream();
//             iTextRenderer.createPDF(baos);
//             baos.close();
//             return baos;
//         } catch (Exception e) {
//             throw new Exception(e);
//         }
//     }
//
//     /**
//      *
//      */
//     public static void renderPdf(HttpServletResponse response, final byte[] bytes, final String filename) {
//         setFileDownloadHeader(response, filename, ".pdf");
//
//         if (null != bytes) {
//             try {
//                 OutputStream out = response.getOutputStream();
//                 out.write(bytes);
//                 out.flush();
//                 out.close();
//             } catch (IOException e) {
//                 throw new IllegalArgumentException(e);
//             }
//         }
//     }
//
//     /**
//      * @param response HttpServletResponse
//      * @param fileName 文件名称
//      * @param fileType 后缀
//      */
//     public static void setFileDownloadHeader(HttpServletResponse response, String fileName, String fileType) {
//         try {
//             // 中文文件名支持
//             String encodedfileName = new String(fileName.getBytes("GBK"), "ISO8859-1");
//             response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + fileType + "\"");
//         } catch (UnsupportedEncodingException e) {
//         }
//     }
//
//
//     public static void main(String[] args) {
//
//         HttpServletRequest request = null;
//         HttpServletResponse response = null;
//
//         Map<String, Object> variables = new HashMap<String, Object>();
//
//         List<Courses> lstCourse = new ArrayList<Courses>();
//         Courses courses = new Courses();
//         courses.setId(1L);
//         courses.setCoursesName("测试");
//         lstCourse.add(courses);
//
//         variables.put("lstCourse", lstCourse);
//         variables.put("base", "");
//         variables.put("viewPath", "");
//
//         try {
//             ByteArrayOutputStream bos = PDFUtil.createPDF(request, "ftl文件名称.ftl", variables);
//             PDFUtil.renderPdf(response, bos.toByteArray(), "下载显示的文件名称");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//
//
//     }
//
//     /**
//      * 给pdf文件添加水印
//      * @param InPdfFile     要加水印的原pdf文件路径
//      * @param outPdfFile    加了水印后要输出的路径
//      * @param markImagePath 水印图片路径
//      */
//     public static void addPdfMark(String inPdfFile, String markImagePath, float absoluteX, float absoluteY) {
//         FileOutputStream os = null;
//         PdfStamper stamp = null;
//         try {
//             int pageSize = 1;
//             PdfReader reader;
//             reader = new PdfReader(inPdfFile, "PDF".getBytes());
//             String tempFile = inPdfFile + ".pdf";
//             os = new FileOutputStream(tempFile);
//             stamp = new PdfStamper(reader, os);
//             Image img = Image.getInstance(markImagePath);// 插入水印
//             img.setAbsolutePosition(absoluteX, absoluteY);
//             for (int i = 1; i <= pageSize; i++) {
//                 PdfContentByte under = stamp.getUnderContent(i);
//                 under.addImage(img);
//             }
//             stamp.close();
//             os.close();
//             File infile = new File(inPdfFile);
//             infile.delete();
//             File file = new File(tempFile);
//             file.renameTo(infile);
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (os != null) {
//                     os.close();
//                 }
//                 if (stamp != null) {
//                     stamp.close();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
}