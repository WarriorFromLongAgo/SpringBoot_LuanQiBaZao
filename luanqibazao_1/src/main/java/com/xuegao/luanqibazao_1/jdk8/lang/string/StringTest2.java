package com.xuegao.luanqibazao_1.jdk8.lang.string;

public class StringTest2 {

    public static void main(String[] args) throws Exception {
        // String sql = "INSERT INTO crm.fence_price (id, adjust_title, customer_num, begin_time, end_time, fence_status, " +
        //         "service_type, pay_mode, adjust_type, adjust_amount, exc_amount, customer_generic_query, waybill_generic_query, " +
        //         " fence_tips, exc_tips, push_finish_time, push_finish_flag, execute_time, other_status, modify_time, run_complete_time, " +
        //         "trace_id, enabled_flag, created_by, creation_date, updated_by, updation_date, etl_creation_date, etl_updation_date)  " +
        //         "VALUES (null, '压测专用%s', -1, '2022-05-01 00:00:00', '2022-05-29 23:59:59', 2,  " +
        //         "'', '', 1, 11.0000,  " +
        //         "111.0000, null, '{\"generic\": {\"vos\": [{\"values\": [\"312\"], \"operation\": \"contain\", \"columnName\": \"deliveryArea#Free\", \"matchScope\": \"{\\\\\"key\\\\\":\\\\\"deliveryArea\\\\\",\\\\\"propertyName\\\\\":\\\\\"deliveryArea\\\\\",\\\\\"columnName\\\\\":\\\\\"deliveryArea\\\\\",\\\\\"frontBrackets\\\\\":\\\\\"(\\\\\",\\\\\"postBrackets\\\\\":\\\\\")\\\\\",\\\\\"conditionOperation\\\\\":\\\\\"and\\\\\",\\\\\"operation\\\\\":\\\\\"contain\\\\\",\\\\\"columnType\\\\\":\\\\\"areaSelect\\\\\",\\\\\"queryValue\\\\\":\\\\\"Free\\\\\",\\\\\"isSelectError\\\\\":false,\\\\\"isError\\\\\":false,\\\\\"queryValue2\\\\\":{\\\\\"disName\\\\\":\\\\\"\\\\\",\\\\\"disId\\\\\":\\\\\"312\\\\\",\\\\\"dId\\\\\":\\\\\"XZ4-037279\\\\\",\\\\\"resName\\\\\":\\\\\"wlz报关\\\\\"},\\\\\"_queryValue\\\\\":\\\\\"\\\\\",\\\\\"checkedNodes\\\\\":null,\\\\\"levelNodes\\\\\":null,\\\\\"$attr\\\\\":{\\\\\"operations\\\\\":[\\\\\"contain\\\\\"],\\\\\"showList\\\\\":true,\\\\\"lookupCodeList\\\\\":[{\\\\\"label\\\\\":\\\\\"自由画\\\\\",\\\\\"value\\\\\":\\\\\"Free\\\\\"}]},\\\\\"remoteMethod\\\\\":null}\", \"postBrackets\": \")\", \"frontBrackets\": \"(\", \"conditionOperation\": \"and\"}]}}',  " +
        //         "'因报关入仓原因，需收取服务费：**元/票', '由于收件地址涉及报关入仓服务，若不选择服务将会延时派送，并需支付&&元手续费，风险将由您承担', null, 1, " +
        //         "'2022-05-02 15:34:45', null, '2022-05-02 15:34:45', null, 'e7ce806b6b744634bf51b74b8f56e90b', 1, '13601', '2022-05-02 15:34:27', " +
        //         "'13601', '2022-05-02 15:34:45', '2022-05-02 15:34:26', '2022-05-02 15:34:44');";
        // for (int i = 0; i < 50; i++) {
        //     String sql1 = sql.replace("%s", String.valueOf(i));
        //     System.out.println(sql1);
        // }
        // System.out.println("================================================================");
        String way = "17228";
        Integer integer = Integer.valueOf(way.substring(way.length() - 1));
        System.out.println(integer);
        int i = integer / 3;
        System.out.println(i);

        int i1 = way.hashCode();
        System.out.println(i1);
        int i2 = "30000019".hashCode();
        System.out.println(i2);
        int i3 = "3000230".hashCode();
        System.out.println(i3);
        int i4 = "000001017231".hashCode();
        System.out.println(i4);
        int i5 = i4 % 3;
        System.out.println(i5);
        int i6 = i3 % 3;
        System.out.println(i6);
    }


    /**
     * @param b 字节数组
     * @return 16进制字符串
     * @throws
     * @Title:bytes2HexString
     * @Description:字节数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(String.format("%02X", b[i]));
        }
        return result.toString();
    }

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexString2Bytes
     * @Description:16进制字符串转字节数组
     */
    public static byte[] hexString2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }


    /**
     * @param strPart 字符串
     * @return 16进制字符串
     * @throws
     * @Title:string2HexUTF8
     * @Description:字符UTF8串转16进制字符串
     */
    public static String string2HexUTF8(String strPart) {

        return string2HexString(strPart, "UTF-8");
    }

    /**
     * @param strPart 字符串
     * @return 16进制字符串
     * @throws
     * @Title:string2HexUTF8
     * @Description:字符UTF-16LE串转16进制字符串,此UTF-16LE等同于C#中的Unicode
     */
    public static String string2HexUTF16LE(String strPart) {

        return string2HexString(strPart, "UTF-16LE");
    }

    /**
     * @param strPart 字符串
     * @return 16进制字符串
     * @throws
     * @Title:string2HexUnicode
     * @Description:字符Unicode串转16进制字符串
     */
    public static String string2HexUnicode(String strPart) {

        return string2HexString(strPart, "Unicode");
    }

    /**
     * @param strPart 字符串
     * @return 16进制字符串
     * @throws
     * @Title:string2HexGBK
     * @Description:字符GBK串转16进制字符串
     */
    public static String string2HexGBK(String strPart) {

        return string2HexString(strPart, "GBK");
    }

    /**
     * @param strPart    字符串
     * @param tochartype hex目标编码
     * @return 16进制字符串
     * @throws
     * @Title:string2HexString
     * @Description:字符串转16进制字符串
     */
    public static String string2HexString(String strPart, String tochartype) {
        try {
            return bytes2HexString(strPart.getBytes(tochartype));
        } catch (Exception e) {
            return "";
        }
    }

    ///

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexUTF82String
     * @Description:16进制UTF-8字符串转字符串
     */
    public static String hexUTF82String(String src) {

        return hexString2String(src, "UTF-8", "UTF-8");
    }

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexUTF16LE2String
     * @Description:16进制UTF-8字符串转字符串，,此UTF-16LE等同于C#中的Unicode
     */
    public static String hexUTF16LE2String(String src) {

        return hexString2String(src, "UTF-16LE", "UTF-8");
    }

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexGBK2String
     * @Description:16进制GBK字符串转字符串
     */
    public static String hexGBK2String(String src) {

        return hexString2String(src, "GBK", "UTF-8");
    }

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexUnicode2String
     * @Description:16进制Unicode字符串转字符串
     */
    public static String hexUnicode2String(String src) {
        return hexString2String(src, "Unicode", "UTF-8");
    }

    /**
     * @param src 16进制字符串
     * @return 字节数组
     * @throws
     * @Title:hexString2String
     * @Description:16进制字符串转字符串
     */
    public static String hexString2String(String src, String oldchartype, String chartype) {
        byte[] bts = hexString2Bytes(src);
        try {
            if (oldchartype.equals(chartype))
                return new String(bts, oldchartype);
            else
                return new String(new String(bts, oldchartype).getBytes(), chartype);
        } catch (Exception e) {

            return "";
        }
    }


}
