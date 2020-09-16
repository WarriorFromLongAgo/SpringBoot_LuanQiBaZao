package com.xuegao.mysql.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <br/> @PackageName：com.xuegao.mysql.aop
 * <br/> @ClassName：Springboot
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/16 9:45
 */
@Aspect
public class Springboot {

    @Pointcut("execution(* com.pig4cloud.plugin.excel.converters.LocalDateStringConverter(..))")
    public void actionEnterAspect() {
    }


}