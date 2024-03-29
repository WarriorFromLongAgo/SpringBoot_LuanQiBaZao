package com.xuegao.luanqibazao_1.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：CalcUtil
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/16 10:34
 */
public class CalcUtil {
    private static final Logger log = LoggerFactory.getLogger(CalcUtil.class);

    private CalcUtil() {
    }

    /**
     * <br/> @Title: 根据分子分母，获取最终的百分比
     * <br/> @Description:
     * <br/> @MethodName: getPercentage
     * <br/> @param molecule: 分子
     * <br/> @param denominator: 分母
     * <br/> @return: java.lang.String
     * <br/> @author: 80004960
     * <br/> @date: 2020/12/14 20:20
     */
    public static String getPercentage(String molecule, String denominator) {
        String returnStr = "0%";
        // 如果 分子分母都为 0
        if ("0".equals(molecule) && "0".equals(denominator)) {
            return returnStr;
        }
        // 如果 分子 单独为 0
        if (StringUtils.isBlank(molecule)) {
            return returnStr;
        }
        // 如果 分子不为 0，但是分母为 0
        if (StringUtils.isBlank(denominator) || "0".equals(denominator)) {
            returnStr = "100%";
            log.error(" ExportStudentVO getPercentage 分母为 blank {}", denominator);
            return returnStr;
        }

        int moleculeInt = Integer.parseInt(molecule);
        int denominatorInt = Integer.parseInt(denominator);
        int merchant = (int) ((BigDecimal.valueOf((float) moleculeInt / denominatorInt)
                .setScale(2, RoundingMode.UP).doubleValue()) * 100);

        returnStr = merchant + "%";
        return returnStr;
    }

    /**
     * <br/> @Title:
     * <br/> @Description:
     * <br/> @MethodName: getPercentage2
     * <br/> @param molecule:
     * <br/> @param denominator:
     * <br/> @return: java.lang.String
     * <br/> @author: xuegao
     * <br/> @date: 2020/12/21 14:37
     */
    public static String getPercentage2(Integer molecule, Integer denominator) {
        String returnStr = "0%";

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String moleculeStr = decimalFormat.format(molecule);
        String denominatorStr = decimalFormat.format(denominator);
        System.out.println(moleculeStr);
        System.out.println(denominatorStr);

        String format = decimalFormat.format((float) molecule / denominator);
        System.out.println(format);


        double v = Double.parseDouble(moleculeStr);
        double v1 = Double.parseDouble(denominatorStr);
        double v2 = v / v1;
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);

        return returnStr;
    }
}