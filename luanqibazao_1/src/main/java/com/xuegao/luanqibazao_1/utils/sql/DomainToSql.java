package com.xuegao.luanqibazao_1.utils.sql;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.sql
 * <br/> @ClassName：modelToSsqlTabe
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/8/24 11:26
 */
public class
DomainToSql {
    private final static Logger logger = LoggerFactory.getLogger(DomainToSql.class);

    private static String table_prefix = "t_";
    private static String classPath = "E:\\GiteeDemo\\SpringBoot_LuanQiBaZao\\luanqibazao_1\\src\\main\\java\\com\\xuegao\\luanqibazao_1\\domain\\UserVO.java";
    private static String dirPath = "E:\\GiteeDemo\\SpringBoot_LuanQiBaZao\\luanqibazao_1";
    private static String packagePath = "com\\xuegao\\luanqibazao_1\\domain\\UserVO";

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        if (classPath.contains("\\") && classPath.contains(".")) {
            //实体类所在的package在磁盘上的绝对路径
            String[] split = classPath.split("\\\\");
            String[] split1 = split[split.length - 1].split("\\.");
            String className = split1[0];
            StringBuilder sql = new StringBuilder();

            className = deleteDomain(className).toLowerCase();
            System.out.println(className);
            // sql.append(table_prefix).append(className);

            // System.out.println(sql.toString());
            // Class<?> aClass = generateSql(sql, className);
            // System.out.println(aClass.getSimpleName());

            Class aClass = getClassFromJavaFile(dirPath, packagePath);
            if (aClass != null) {
                System.out.println(aClass.getSimpleName());
            }
            sql.append(generateSql1(aClass));
            System.out.println(sql.toString());
        }
    }


    /**
     * 根据实体类生成建表语句
     */
    public static String generateSql1(Class aClass) {
        Field[] fields = aClass.getDeclaredFields();
        StringBuilder column = new StringBuilder();
        String varchar = " varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
        for (Field f : fields) {
            if (!"serialVersionUID".equals(f.getName())) {
                column.append(" \n `" + f.getName() + "`").append(varchar);
            }
        }
        StringBuffer sql = new StringBuffer();
        sql.append("\n DROP TABLE IF EXISTS `" + aClass.getName() + "`; ")
                .append(" \n CREATE TABLE `" + aClass.getName() + "`  (")
                .append(" \n `id` int(11) NOT NULL AUTO_INCREMENT,")
                .append(" \n " + column)
                .append(" \n PRIMARY KEY (`id`) USING BTREE,")
                .append("\n INDEX `id`(`id`) USING BTREE")
                .append(" \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;");
        return sql.toString();

    }

    private static String deleteDomain(String className) {
        return className
                .replaceAll("DO", "")
                .replaceAll("VO", "")
                .replaceAll("DTO", "")
                .replaceAll("BO", "");
    }

    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("class java.lang.String", "varchar(255)");
        map.put("class java.lang.Integer", "int");
        map.put("class java.lang.Long", "integer unsigned");
        map.put("class java.lang.byte[]", "blob");
        map.put("class java.lang.Boolean", "bit");
        map.put("class java.math.BigInteger", "bigint unsigned");
        map.put("class java.lang.Float", "float");
        map.put("class java.lang.Double", "float");
        map.put("class java.sql.Date", "datetime");
        map.put("class java.sql.Time", "time");
        map.put("class java.sql.Timestamp", "datetime");
        map.put("class java.util.Date", "datetime");
        map.put("class java.lang.Byte", "tinyint");
    }

    /**
     * 编译java文件，并加载其Class的工具
     * dirPath: 不含包目录的java文件所在目录， F:/today/javadir/
     * pakagePath: 包路径，com.chenyf.entity
     */
    public static Class getClassFromJavaFile(String dirPath, String pakagePath) {
        if (StringUtils.isBlank(dirPath) || StringUtils.isBlank(pakagePath)) {
            //校验参数是否为空
            return null;
        }

        String pakageDir = pakagePath.replaceAll("\\.", "/").replaceAll("\\\\", "/");   // 将路径中的 . 替换为 / , 替换后的pakageDir = com/chenyf/entity
        String filePath = dirPath.replaceAll("\\\\", "/").concat("/src/main/java/").concat(pakageDir).concat(".java");  // src/main/java为java文件的特定目录

        //编译
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int compilationResult = javac.run(null, null, null, filePath);

        if (compilationResult != 0) {
            //compilationResult == 0,说明编译成功，在Java文件的同目录下会生成相应的class文件
            throw new IllegalArgumentException("编译失败");
        }

        Class<?> clazz = null;
        try {

            MyClassLoader loader = new MyClassLoader(dirPath); //使用自定义ClassLoader
            clazz = loader.findClass(pakagePath);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return clazz;
    }

    /**
     * 自定义ClassLoader
     */
    private static final class MyClassLoader extends ClassLoader {

        private String classDir;    // 文件目录，例如:"file:/today/javadir/src/main/java/"

        @Override
        public Class<?> findClass(String name) {
            classDir = classDir.replaceAll("\\\\", "/");
            name = name.replaceAll("\\\\", "/");
            String realPath = classDir + name.replace(".", "/") + ".class";  //class文件的真实路径
            byte[] cLassBytes = null;
            Path path = null;

            try {

                path = Paths.get(new URI(realPath));
                cLassBytes = Files.readAllBytes(path);

            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            name = name.replaceAll("/", ".");
            Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);  //调用父类的defineClass方法
            return clazz;
        }

        public MyClassLoader(String classDir) {
            this.classDir = "file:/".concat(classDir).concat("/src/main/java/"); //拼接 “file:/”前缀
        }

    }
}