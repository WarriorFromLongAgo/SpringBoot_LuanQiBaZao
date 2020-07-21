package com.xuegao.multi_thread2.limit.annotation;

import java.lang.annotation.*;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.annotation
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 14:06
 */
@Inherited
@Documented
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RedisLimit {
    /**
     *
     */
    int limit() default 5;

    /**
     *
     */
    int sec() default 5;
}
