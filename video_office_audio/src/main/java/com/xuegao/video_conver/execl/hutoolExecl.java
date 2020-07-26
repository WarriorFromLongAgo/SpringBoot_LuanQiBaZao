package com.xuegao.video_conver.execl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.xuegao.video_conver.domain.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.execl
 * <br/> @ClassName：hutoolExecl
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/11 2:18
 */
public class hutoolExecl {
    public static void main(String[] args) {
        List<UserInfo> list = new ArrayList<>();

        list.add(new UserInfo("zhangsan", "1231", new Date()));
        list.add(new UserInfo("zhangsan1", "1232", new Date()));
        list.add(new UserInfo("zhangsan2", "1233", new Date()));
        list.add(new UserInfo("zhangsan3", "1234", new Date()));
        list.add(new UserInfo("zhangsan4", "1235", new Date()));
        list.add(new UserInfo("zhangsan5", "1236", DateUtil.date(new Date())));

        /* 通过工具类创建writer，默认创建xls格式 */
        ExcelWriter writer = ExcelUtil.getWriter();

        /* 自定义标题别名 */
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("birthDay", "生日");

        /* 合并单元格后的标题行，使用默认标题样式 */
        writer.merge(2, "申请人员信息");

        /* 一次性写出内容，使用默认样式，强制输出标题 */
        writer.write(list, true);

        /* out为OutputStream，需要写出到的目标流 */
        /* response为HttpServletResponse对象 */
        // response.setContentType("application/vnd.ms-excel;charset=utf-8");

        /* test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码 */
        // String name = StringUtils.toUtf8String("申请学院");

        // response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");

        // ServletOutputStream out = null;

        // try {
        //     // out = response.getOutputStream();
        //
        //     // writer.flush(out, true);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } finally {
        //     /* 关闭writer，释放内存 */
        //     writer.close();
        // }

        /* 此处记得关闭输出Servlet流 */

        // IoUtil.close(out);
    }
}