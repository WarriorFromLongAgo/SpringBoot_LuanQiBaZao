package com.xuegao.luanqibazao_1.sql;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.sql
 * <br/> @ClassName：SqlToDomain
 * <br/> @Description：有 swagger 和 mybatisplus 注解
 * <br/> @author：xuegao
 * <br/> @date：2020/9/17 17:57
 */
public class SqlToDomain {
    private static final String KEY = "KEY";
    private static final String INDEX = "INDEX";
    private static final String COMMENT = "COMMENT";
    private static final String AUTHOR = "xuegao";
    private static String PACKAGE_NAME;
    private static String CLASS_NAME;
    private static String TABLE_NAME;
    private static final StringBuilder CLASS_STR = new StringBuilder();
    private static final Map<String, String> INT_MAP = new HashMap<>();
    private static final Map<String, String> LONG_MAP = new HashMap<>();
    private static final Map<String, String> STRING_MAP = new HashMap<>();
    private static final Map<String, String> DATE_MAP = new HashMap<>();
    private static final Map<String, String> COMMENT_MAP = new LinkedHashMap<>();
    // 下划线 转 驼峰
    private static final Pattern LINE_PATTERN = Pattern.compile("_(\\w)");
    // 驼峰 转 下划线
    private static final Pattern UNDERLINE_WORDS_PATTERN = Pattern.compile("[A-Z]");

    static {
        INT_MAP.put("int", " Integer ");
        INT_MAP.put("tinyint", " Integer ");

        LONG_MAP.put("bigint", " Long ");

        STRING_MAP.put("char", " String ");
        STRING_MAP.put("varchar", " String ");

        DATE_MAP.put("datetime", " Date ");
    }

    public static void main(String[] args) {
        String sql = "CREATE TABLE `t_thumbs_up_userinfo`\n" +
                "(\n" +
                "    `id`           bigint(20)                      NOT NULL AUTO_INCREMENT comment '文章id',\n" +
                "    `give_user_id` bigint(20)                      NOT NULL COLLATE utf8_general_ci default 1 comment '点赞的用户id',\n" +
                "    `user_id`      bigint(20)                      NOT NULL COLLATE utf8_general_ci default 1 comment '被点赞的用户id',\n" +
                "    `status`       char(1) CHARACTER SET utf8      NOT NULL COLLATE utf8_general_ci default '0' comment '点赞状态，0取消，1点赞',\n" +
                "    `delete_flag`  char(1) CHARACTER SET utf8      NOT NULL COLLATE utf8_general_ci default '0' comment '0未删除，1已删除',\n" +
                "    `create_id`    bigint(20)                      NOT NULL COLLATE utf8_general_ci default 1 comment '创建人id',\n" +
                "    `create_name`  varchar(100) CHARACTER SET utf8 NOT NULL COLLATE utf8_general_ci default '创建人真实名称' comment '创建人真实名称',\n" +
                "    `create_time`  datetime(0)                     NOT NULL COLLATE utf8_general_ci default now() comment '创建时间',\n" +
                "    `update_id`    int(20)                         NOT NULL COLLATE utf8_general_ci default 1 comment '修改人id',\n" +
                "    `update_name`  varchar(100) CHARACTER SET utf8 NOT NULL COLLATE utf8_general_ci default '创建人真实名称' comment '修改人真实名称',\n" +
                "    `update_time`  datetime(0)                     NOT NULL COLLATE utf8_general_ci default now() comment '修改时间',\n" +
                "    PRIMARY KEY (`id`) USING BTREE,\n" +
                "    INDEX `index_give_user_id` (`give_user_id`),\n" +
                "    INDEX `index_user_id` (`user_id`)\n" +
                ") ENGINE = InnoDB\n" +
                "  AUTO_INCREMENT = 1\n" +
                "  CHARACTER SET = utf8mb4\n" +
                "  COLLATE = utf8mb4_general_ci\n" +
                "  ROW_FORMAT = Dynamic comment '对文章的点赞记录';";

        PACKAGE_NAME = "com.xuegao.springboot_tool.model.doo";
        SqlToDomain(sql);
    }

    private static void SqlToDomain(String sql) {
        sql = get1(sql);
        System.out.println(sql);
        String[] sqlArr = get2(sql);
        System.out.println(Arrays.toString(sqlArr));
        // map = id -> bigint
        Map<String, String> map = get3(sqlArr);
        System.out.println(COMMENT_MAP);
        System.out.println(map);
        generatePrefix();
        generateAttribute(map);
        generateSuffix();
        System.out.println(CLASS_STR);
    }

    public static String get1(String sql) {
        int startIndex = sql.indexOf("(");
        int endIndex = sql.lastIndexOf(")");

        StringBuilder classNameStr = new StringBuilder();
        // CREATE TABLE `t_thumbs_up_userinfo`
        String tableName = sql.substring(0, startIndex).split(" ")[2].replaceAll("`", "");
        TABLE_NAME = tableName.trim();
        String[] tableNameArr = tableName.split("_");
        tableNameArr = Arrays.copyOfRange(tableNameArr, 1, tableNameArr.length);
        for (String str : tableNameArr) {
            char[] charArr = str.toCharArray();
            char c = charArr[0];
            if (c >= 97 && c <= 122) {
                charArr[0] -= 32;
            }
            classNameStr.append(charArr);
        }
        CLASS_NAME = classNameStr.toString().trim();

        return sql.substring(startIndex + 1, endIndex);
    }

    public static String[] get2(String sql) {
        return sql.split(",");
    }

    public static Map<String, String> get3(String[] sqlArr) {
        Map<String, String> map = new LinkedHashMap<>(2);
        for (String sql : sqlArr) {
            // 根据空格 切割字符串
            List<String> spaceSplitList = Arrays.asList(sql.split(" "));
            // 如果不是空，返回true，数据保留
            // [`id`, bigint(20), NOT, NULL, AUTO_INCREMENT, comment, '文章id']
            spaceSplitList = spaceSplitList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
            System.out.println(spaceSplitList);
            if (spaceSplitList.contains(KEY) || spaceSplitList.contains(KEY.toLowerCase())) {
                continue;
            }
            if (spaceSplitList.contains(INDEX) || spaceSplitList.contains(INDEX.toLowerCase())) {
                continue;
            }
            if (spaceSplitList.contains(COMMENT) || spaceSplitList.contains(COMMENT.toLowerCase())) {
                String key = underlineWordsToCamelCase(spaceSplitList.get(0).replaceAll("`", ""));
                COMMENT_MAP.put(key, spaceSplitList.get(spaceSplitList.size() - 1).replaceAll("'", ""));
            }
            String key = spaceSplitList.get(0);
            key = key.replaceAll("`", "");
            String value = spaceSplitList.get(1);
            int endIndex = value.indexOf("(");
            value = value.substring(0, endIndex);
            map.put(underlineWordsToCamelCase(key.toLowerCase()), value.toLowerCase());
        }
        return map;
    }

    public static void generateAttribute(Map<String, String> map) {
        for (Map.Entry<String, String> keyValueEntry : map.entrySet()) {
            String key = keyValueEntry.getKey();
            String value = keyValueEntry.getValue();

            CLASS_STR.append(System.lineSeparator());

            if ("id".equalsIgnoreCase(key)) {
                CLASS_STR.append("    @TableId(\"").append(COMMENT_MAP.get(key)).append("\")");
            } else {
                CLASS_STR.append("    @TableField(\"").append(COMMENT_MAP.get(key)).append("\")");
            }
            CLASS_STR.append(System.lineSeparator());

            CLASS_STR.append("    @ApiModelProperty(value = \"").append(COMMENT_MAP.get(key)).append("\")");
            CLASS_STR.append(System.lineSeparator());

            if (INT_MAP.containsKey(value)) {
                CLASS_STR.append("    private").append(INT_MAP.get(value)).append(key).append(";");
            }
            if (LONG_MAP.containsKey(value)) {
                CLASS_STR.append("    private").append(LONG_MAP.get(value)).append(key).append(";");
            }
            if (STRING_MAP.containsKey(value)) {
                CLASS_STR.append("    private").append(STRING_MAP.get(value)).append(key).append(";");
            }
            if (DATE_MAP.containsKey(value)) {
                CLASS_STR.append("    private").append(DATE_MAP.get(value)).append(key).append(";");
            }
            CLASS_STR.append(System.lineSeparator());
        }
    }

    /**
     * <br/> @Title: 下划线转驼峰
     * <br/> @MethodName:  camelCase
     * <br/> @param underlineWords:
     * <br/> @Return java.lang.String
     * <br/> @Description:
     * <br/> @author: xuegao
     * <br/> @date:  2020/9/18 10:47
     */
    public static String underlineWordsToCamelCase(String underlineWords) {
        Matcher matcher = LINE_PATTERN.matcher(underlineWords);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /**
     * <br/> @Title: 驼峰 转 下划线
     * <br/> @MethodName:  underlineWords
     * <br/> @param camelCase:
     * <br/> @Return java.lang.String
     * <br/> @Description:
     * <br/> @author: xuegao
     * <br/> @date:  2020/9/18 10:49
     */
    public static String camelCaseToUnderlineWords(String camelCase) {
        Matcher matcher = UNDERLINE_WORDS_PATTERN.matcher(camelCase);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static void generatePrefix() {
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("package").append(" ").append(PACKAGE_NAME).append(";");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableId;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableField;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableName;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import io.swagger.annotations.ApiModelProperty;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import java.io.Serializable;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import java.util.Date;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("/**");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(" * <br/> @PackageName：").append(PACKAGE_NAME);
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(" * <br/> @ClassName：").append(CLASS_NAME);
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(" * <br/> @Description：");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(" * <br/> @author：").append(AUTHOR);
        CLASS_STR.append(System.lineSeparator());
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        CLASS_STR.append(" * <br/> @date：").append(format);
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(" */");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("@TableName(\"").append(TABLE_NAME).append("\")");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("public class ").append(CLASS_NAME).append(" implements Serializable {");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("    private static final long serialVersionUID = 1L;");
        CLASS_STR.append(System.lineSeparator());
    }

    public static void generateSuffix() {
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("}");
    }
}