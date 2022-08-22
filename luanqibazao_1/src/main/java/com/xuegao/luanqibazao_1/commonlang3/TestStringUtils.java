package com.xuegao.luanqibazao_1.commonlang3;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/3/12 11:05
 */
public class TestStringUtils {
    public static void main(String[] args) {
        String s = "8971387,8975859,8979503,8979507,8979509,8979511,8979513,8979515,8979517,8979519,8979521,8979523,8979525,8979527,8979529,8979531,8979533,8979535,8979537,8979539,8979541,8979545,8979547,8979549,8979551,8979553,8979557,8979559,8979561,8979563,8979565,8979567,8979569,8979571,8979573,8979577,8979579,8979581,8979583,8979585,8979595,8979603,8979605,8979607,8979609,8979611,8979613,8979615,8979617,8979621,8979623,8979625,8979627,8979629,8979631,8979633,8979641,8979643,8979645,8979647,8979651,8979655,8979659,8979661,8979681,8979683,8979685,8979687,8979695,8979703,8979709,8979711,8979713,8979715,8979717,8979719,8979723,8979727,8979729,8979731,8979733,8979749,8979753,8979759,8979761,8979763,8979765,8979767,8979769,8979781,8979783,8979785,8979787,8979789,8979797,8979799,8979801,8979803,8979805,8979807,8979809,8979811,8979813,8979815,8979817,8979821,8979823,8979825,8979827,8979829,8979831,8979837,8979839,8979849,8979851,8979855,8979857,8979859,8979861,8979863,8979903,8979905,8979915,8979917,8979919,8979921,8979923,8979925,8979927,8979929,8979931,8979933,8979935,8979989,8980001,8980003,8980005,8980015,8980017";
        System.out.println(s.split(",").length);

        isNumeric();
    }

    public static void isNumeric() {
        String str1 = "1211111113.12";
        String str2 = "1211111113";
        String str3 = "-1211113";
        String str4 = "-121111113.456";

        // 不能带有特殊符号
        System.out.println("StringUtils.isNumeric(str1) = " + StringUtils.isNumeric(str1));
        System.out.println("StringUtils.isNumeric(str2) = " + StringUtils.isNumeric(str2));
        System.out.println("StringUtils.isNumeric(str3) = " + StringUtils.isNumeric(str3));
        System.out.println("StringUtils.isNumeric(str4) = " + StringUtils.isNumeric(str4));
    }
}