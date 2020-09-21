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
    private static final String SPACE = " ";
    private static final String ONE_TAB = "    ";
    private static final String TWO_TAB = "        ";
    private static String PACKAGE_NAME;
    private static String CLASS_NAME;
    private static String COMMENT_CLASS;
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
    // 数据库表的，列名 article_id = article_id
    private static final Map<String, String> TABLE_MAP = new LinkedHashMap<>();
    // 实体类的，属性名 id = bigint
    private static final Map<String, String> ATTRIBUTE_MAP = new LinkedHashMap<>();
    // true 生成
    private static final Boolean GENERATE_TO_STRING_FLAG = true;
    private static final StringBuilder GENERATE_TO_STRING = new StringBuilder();
    private static final Boolean GENERATE_GET_FLAG = true;
    private static final StringBuilder GENERATE_GET = new StringBuilder();
    private static final Boolean GENERATE_SET_FLAG = true;
    private static final StringBuilder GENERATE_SET = new StringBuilder();
    // t_thumbs_up_userinfo
    // activity_push_center_rec
    // 是否保留表名的前缀，默认true。
    // true  = t_thumbs_up_userinfo = TThumbsUpUserinfo
    // false  = ThumbsUpUserinfo = ThumbsUpUserinfo
    private static Boolean SAVE_TABLE_NAME_PREFIX_FLAG;

    static {
        INT_MAP.put("int", "Integer");
        INT_MAP.put("tinyint", "Integer");

        LONG_MAP.put("bigint", "Long");

        STRING_MAP.put("char", "String");
        STRING_MAP.put("varchar", "String");

        DATE_MAP.put("datetime", "Date");
    }

    public static void main(String[] args) {
        // 使用指南
        // 第一步 复制SQL
        // 第二步 复制packageName的地址，非必设置项
        // 第三部 设置 SAVE_TABLE_NAME_PREFIX_FLAG （请查看类的变量设置）

        String sql = "create table t_thumbs_up_userinfo\n" +
                "(\n" +
                "    id           bigint auto_increment comment '主键'\n" +
                "        primary key,\n" +
                "    article_id   bigint                    default 0                 not null comment '文章id',\n" +
                "    give_user_id bigint                    default 0                 not null comment '点赞的用户id',\n" +
                "    user_id      bigint                    default 0                 not null comment '被点赞的用户id',\n" +
                "    status       char charset utf8         default ''                not null comment '点赞状态，0取消，1点赞',\n" +
                "    delete_flag  char charset utf8         default ''                not null comment '0未删除，1已删除',\n" +
                "    create_id    bigint                    default 0                 not null comment '创建人id',\n" +
                "    create_name  varchar(100) charset utf8 default '创建人真实名称'         not null comment '创建人真实名称',\n" +
                "    create_time  datetime                  default CURRENT_TIMESTAMP not null comment '创建时间',\n" +
                "    update_id    bigint                    default 0                 not null comment '修改人id',\n" +
                "    update_name  varchar(100) charset utf8 default '创建人真实名称'         not null comment '修改人真实名称',\n" +
                "    update_time  datetime                  default CURRENT_TIMESTAMP not null comment '修改时间'\n" +
                ")\n" +
                "    comment '对文章的点赞记录';";
        PACKAGE_NAME = "com.xuegao.springboot_tool.model.doo";
        SAVE_TABLE_NAME_PREFIX_FLAG = false;
        SqlToDomain(sql);
    }

    private static void SqlToDomain(String sql) {
        if (StringUtils.isBlank(sql)) {
            throw new RuntimeException("输入的 sql 为 空");
        }
        String sqlAttribute = get1(sql);
        // System.out.println(sqlAttribute);
        get4(sql);
        String[] sqlArr = get2(sqlAttribute);
        // System.out.println(Arrays.toString(sqlArr));
        get3(sqlArr);
        // System.out.println(COMMENT_MAP);
        // System.out.println(ATTRIBUTE_MAP);
        generatePrefix();
        generateAttribute();
        generateSuffix();
        System.out.println(CLASS_STR);
    }

    public static String get1(String sql) {
        int startIndex = sql.indexOf("(");
        int endIndex = sql.lastIndexOf(")");

        StringBuilder classNameStr = new StringBuilder();
        // CREATE TABLE `t_thumbs_up_userinfo`
        // CREATE TABLE `activity_push_center_rec`
        String tableName = sql.substring(0, startIndex).split(" ")[2].replaceAll("`", "");
        TABLE_NAME = tableName.trim();
        String[] tableNameArr = tableName.split("_");
        if (!SAVE_TABLE_NAME_PREFIX_FLAG) {
            tableNameArr = Arrays.copyOfRange(tableNameArr, 1, tableNameArr.length);
        }
        for (String str : tableNameArr) {
            classNameStr.append(wordToFirstCapital(str));
        }
        CLASS_NAME = classNameStr.toString().trim();

        return sql.substring(startIndex + 1, endIndex);
    }

    public static String[] get2(String sql) {
        return sql.split(",");
    }

    public static void get3(String[] sqlArr) {
        for (String sql : sqlArr) {
            // 根据空格 切割字符串
            List<String> spaceSplitList = Arrays.asList(sql.split(" "));
            // 如果不是空，返回true，数据保留
            // [`id`, bigint(20), NOT, NULL, AUTO_INCREMENT, comment, '文章id']
            spaceSplitList = spaceSplitList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
            // System.out.println(spaceSplitList);
            if (spaceSplitList.contains(KEY) || spaceSplitList.contains(KEY.toLowerCase())) {
                boolean id = sql.contains("ID");
                boolean id1 = sql.contains("id");
                boolean id2 = sql.contains("Id");
                boolean flag = sql.contains("ID") || sql.contains("id") || sql.contains("Id");
                if (!flag) {
                    System.out.println(spaceSplitList);
                    continue;
                }
            }
            if (spaceSplitList.contains(INDEX) || spaceSplitList.contains(INDEX.toLowerCase())) {
                continue;
            }
            if (spaceSplitList.contains(COMMENT) || spaceSplitList.contains(COMMENT.toLowerCase())) {
                String key = underlineWordsToCamelCase(spaceSplitList.get(0).replaceAll("`", ""));
                COMMENT_MAP.put(key, spaceSplitList.get(spaceSplitList.size() - 1).replaceAll("'", "").trim());
            }
            String key = spaceSplitList.get(0);
            key = key.replaceAll("`", "");
            String value = spaceSplitList.get(1);
            if (value.contains("(")) {
                int endIndex = value.indexOf("(");
                value = value.substring(0, endIndex);
            }
            key = key.toLowerCase();
            TABLE_MAP.put(underlineWordsToCamelCase(key), key);
            ATTRIBUTE_MAP.put(underlineWordsToCamelCase(key), value.toLowerCase().trim());
        }
    }

    public static void get4(String commonSql) {
        // datagrip
        // comment '对文章的点赞记录';
        // navicat
        // ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '对文章的点赞记录' ROW_FORMAT = Dynamic;
        // mysql xxx
        // ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COMMENT='幸运转盘活动积分结算微官网推送入职记录表'

        int startIndex = commonSql.lastIndexOf(")");
        String[] attributeArr = commonSql.substring(startIndex + 1).split(" ");
        for (int i = 0; i < attributeArr.length; i++) {
            String attribute = attributeArr[i];
            if (StringUtils.isBlank(attribute)) {
                continue;
            }
            if (attribute.contains("=") && attribute.length() > 2) {
                String[] split = attribute.split("=");
                if (COMMENT.equalsIgnoreCase(split[0])) {
                    COMMENT_CLASS = split[1].replaceAll("'", "")
                            .replaceAll("`", "")
                            .replaceAll(";", "")
                            .trim();
                    break;
                }
                continue;
            }
            if (!COMMENT.equalsIgnoreCase(attribute)) {
                continue;
            }
            if ("=".equals(attributeArr[i + 1])) {
                COMMENT_CLASS = attributeArr[i + 2]
                        .replaceAll("`", "")
                        .replaceAll("'", "")
                        .replaceAll(";", "")
                        .trim();
            } else {
                COMMENT_CLASS = attributeArr[i + 1]
                        .replaceAll("`", "")
                        .replaceAll("'", "")
                        .replaceAll(";", "")
                        .trim();
            }
            if (StringUtils.isNotBlank(COMMENT_CLASS)) {
                break;
            }
        }
    }

    public static void get5(String commonSql) {
        int startIndex = commonSql.lastIndexOf(")");
        String[] attributeArr = commonSql.substring(startIndex).split(" ");
        for (int i = 0; i < attributeArr.length; i++) {
            String attribute = attributeArr[i];
            if (!COMMENT.equalsIgnoreCase(attribute)) {
                continue;
            }
            if ("=".equals(attributeArr[i + 1])) {
                COMMENT_CLASS = attributeArr[i + 2]
                        .replaceAll("`", "")
                        .replaceAll("'", "")
                        .replaceAll(";", "")
                        .trim();
            } else {
                COMMENT_CLASS = attributeArr[i + 1]
                        .replaceAll("`", "")
                        .replaceAll("'", "")
                        .replaceAll(";", "")
                        .trim();
            }
        }
    }

    public static void generateAttribute() {
        System.out.println(" ATTRIBUTE_MAP 打印");
        GENERATE_TO_STRING.append(System.lineSeparator());
        GENERATE_TO_STRING.append(System.lineSeparator());
        GENERATE_TO_STRING.append("" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        return \"").append(CLASS_NAME).append("{\" +");
        for (Map.Entry<String, String> keyValueEntry : ATTRIBUTE_MAP.entrySet()) {
            String attribute = keyValueEntry.getKey();
            String sqlType = keyValueEntry.getValue();
            System.out.println(attribute + "===============" + sqlType);
            CLASS_STR.append(System.lineSeparator());

            if ("id".equalsIgnoreCase(attribute)) {
                CLASS_STR.append(ONE_TAB).append("@TableId(\"").append(TABLE_MAP.get(attribute)).append("\")");
            } else {
                CLASS_STR.append(ONE_TAB).append("@TableField(\"").append(TABLE_MAP.get(attribute)).append("\")");
            }
            CLASS_STR.append(System.lineSeparator());
            CLASS_STR.append(ONE_TAB).append("@ApiModelProperty(value").append(SPACE).append("=").append(SPACE).append("\"").append(COMMENT_MAP.get(attribute)).append("\")");
            CLASS_STR.append(System.lineSeparator());
            CLASS_STR.append(ONE_TAB).append("private").append(SPACE).append(sqlTypeToJavaType(sqlType)).append(SPACE).append(attribute).append(";");
            CLASS_STR.append(System.lineSeparator());

            if (GENERATE_GET_FLAG) {
                generateGet(attribute, sqlType);
            }
            if (GENERATE_SET_FLAG) {
                generateSet(attribute, sqlType);
            }
            if (GENERATE_TO_STRING_FLAG) {
                generateToString(attribute);
            }
        }
        CLASS_STR.append(GENERATE_GET);
        CLASS_STR.append(GENERATE_SET);
        GENERATE_TO_STRING.append(System.lineSeparator());
        GENERATE_TO_STRING.append(ONE_TAB).append(ONE_TAB).append(ONE_TAB).append("\"").append("}").append("\"").append(";");
        GENERATE_TO_STRING.append(System.lineSeparator());
        GENERATE_TO_STRING.append(ONE_TAB).append("}");
        CLASS_STR.append(GENERATE_TO_STRING);
    }

    public static void generatePrefix() {
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("package").append(SPACE).append(PACKAGE_NAME).append(";");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableId;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableField;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import com.baomidou.mybatisplus.annotation.TableName;");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("import io.swagger.annotations.ApiModel;");
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
        CLASS_STR.append("@ApiModel(value = \"").append(COMMENT_CLASS).append("\")");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("@TableName(\"").append(TABLE_NAME).append("\")");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("public class ").append(CLASS_NAME).append(" implements Serializable {");
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append(ONE_TAB).append("private static final long serialVersionUID = 1L;");
        CLASS_STR.append(System.lineSeparator());
    }

    public static void generateGet(String attribute, String sqlType) {
        // public Long getId() {
        //     return id;
        // }
        GENERATE_GET.append(System.lineSeparator());
        GENERATE_GET.append(System.lineSeparator());
        GENERATE_GET.append(ONE_TAB)
                .append("public")
                .append(SPACE)
                .append(sqlTypeToJavaType(sqlType))
                .append(SPACE)
                .append("get")
                .append(wordToFirstCapital(attribute))
                .append("()")
                .append(SPACE)
                .append("{");
        GENERATE_GET.append(System.lineSeparator());
        GENERATE_GET.append(TWO_TAB)
                .append("return")
                .append(SPACE)
                .append(attribute)
                .append(";");
        GENERATE_GET.append(System.lineSeparator());
        GENERATE_GET.append(ONE_TAB)
                .append("}");
    }

    public static void generateSet(String attribute, String sqlType) {
        // public void setId(Long id) {
        //     this.id = id;
        // }
        GENERATE_SET.append(System.lineSeparator());
        GENERATE_SET.append(System.lineSeparator());
        GENERATE_SET.append(ONE_TAB)
                .append("public")
                .append(SPACE)
                .append("void")
                .append(SPACE)
                .append("set")
                .append(wordToFirstCapital(attribute))
                .append("(")
                .append(sqlTypeToJavaType(sqlType))
                .append(SPACE)
                .append(attribute)
                .append(")")
                .append(SPACE)
                .append("{");
        GENERATE_SET.append(System.lineSeparator());
        GENERATE_SET.append(TWO_TAB)
                .append("this")
                .append(".")
                .append(attribute)
                .append(SPACE)
                .append("=")
                .append(SPACE)
                .append(attribute)
                .append(";");
        GENERATE_SET.append(System.lineSeparator());
        GENERATE_SET.append(ONE_TAB)
                .append("}");
    }

    public static void generateToString(String attribute) {
        // "id=" + id +
        GENERATE_TO_STRING.append(System.lineSeparator());
        GENERATE_TO_STRING
                .append(ONE_TAB)
                .append(ONE_TAB)
                .append(ONE_TAB);
        if ("id".equalsIgnoreCase(attribute)) {
            GENERATE_TO_STRING.append("\"").append(attribute).append("=\"").append(SPACE).append("+").append(SPACE).append(attribute).append(SPACE).append("+");

        } else {
            GENERATE_TO_STRING.append("\"").append(", ").append(attribute).append("=\"").append(SPACE).append("+").append(SPACE).append(attribute).append(SPACE).append("+");
        }
    }

    public static void generateSuffix() {
        CLASS_STR.append(System.lineSeparator());
        CLASS_STR.append("}");
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

    /**
     * <br/> @Title: mysql 里面的 sqltype 转换成 java里面的，如datetime转换成date
     * <br/> @MethodName:  sqlTypeToJavaType
     * <br/> @param sqlType:
     * <br/> @return java.lang.String
     * <br/> @Description:
     * <br/> @author: xuegao
     * <br/> @date:  2020/9/21 14:01
     */
    public static String sqlTypeToJavaType(String sqlType) {
        String javaType = "";
        if (INT_MAP.containsKey(sqlType)) {
            javaType = INT_MAP.get(sqlType);
        } else if (LONG_MAP.containsKey(sqlType)) {
            javaType = LONG_MAP.get(sqlType);
        } else if (STRING_MAP.containsKey(sqlType)) {
            javaType = STRING_MAP.get(sqlType);
        } else if (DATE_MAP.containsKey(sqlType)) {
            javaType = DATE_MAP.get(sqlType);
        } else {
            throw new RuntimeException("sqlTypeToJavaType exception");
        }
        return javaType;
    }

    /**
     * <br/> @Title: 首字母大写
     * <br/> @MethodName:  wordToFirstCapital
     * <br/> @param word:
     * <br/> @return java.lang.String
     * <br/> @Description:
     * <br/> @author: xuegao
     * <br/> @date:  2020/9/21 14:12
     */
    public static String wordToFirstCapital(String word) {
        char[] charArr = word.toCharArray();
        char c = charArr[0];
        if (c >= 'a' && c <= 'z') {
            charArr[0] -= 32;
        }
        return String.valueOf(charArr);
    }

}