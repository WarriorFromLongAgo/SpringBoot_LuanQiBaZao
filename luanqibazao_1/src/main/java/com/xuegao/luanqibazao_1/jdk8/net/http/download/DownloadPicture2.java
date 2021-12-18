package com.xuegao.luanqibazao_1.jdk8.net.http.download;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：DownloadPicture2
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 10:08
 */
public class DownloadPicture2 {
    public static void main(String[] args) {
        // String imgUrl="";//URL地址
        // String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1);
        // BufferedInputStream is = null;
        // BufferedOutputStream os = null;
        // try {
        //     URL url = new URL(imgUrl);
        //     this.getServletResponse().setContentType("application/x-msdownload;");
        //     this.getServletResponse().setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        //     this.getServletResponse().setHeader("Content-Length", String.valueOf(url.openConnection().getContentLength()));
        //     is = new BufferedInputStream(url.openStream());
        //     os = new BufferedOutputStream(this.getServletResponse().getOutputStream());
        //     byte[] buff = new byte[2048];
        //     int bytesRead;
        //     while (-1 != (bytesRead = is.read(buff, 0, buff.length))) {
        //         os.write(buff, 0, bytesRead);
        //     }
        //     if (is != null)
        //         is.close();
        //     if (os != null)
        //         os.close();
        // } catch (MalformedURLException e) {
        //     e.printStackTrace();
        // } catch (UnsupportedEncodingException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}