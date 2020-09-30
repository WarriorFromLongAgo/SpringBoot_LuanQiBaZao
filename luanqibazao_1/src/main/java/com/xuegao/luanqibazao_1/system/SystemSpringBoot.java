package com.xuegao.luanqibazao_1.system;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.system
 * <br/> @ClassName：SystemSpringBoot
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/29 18:53
 */
public class SystemSpringBoot {
    private boolean headless = true;
    private static final String SYSTEM_PROPERTY_JAVA_AWT_HEADLESS = "java.awt.headless";

    public static void main(String[] args) {
        SystemSpringBoot systemSpringBoot = new SystemSpringBoot();
        systemSpringBoot.configureHeadlessProperty();

    }

    private void configureHeadlessProperty() {
        String s = System.setProperty(SYSTEM_PROPERTY_JAVA_AWT_HEADLESS,
                System.getProperty(SYSTEM_PROPERTY_JAVA_AWT_HEADLESS, Boolean.toString(this.headless)));
        System.out.println(s);
    }
}