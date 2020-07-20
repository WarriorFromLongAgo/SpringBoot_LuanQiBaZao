package com.xuegao.multi_thread2.limit.annotation;

import java.lang.annotation.*;

/**
 * <br/> @PackageName：${PACKAGE_NAME}
 * <br/> @ClassName：${Name}
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：${DATE} ${TIME}
 */
@Inherited
@Documented
@Target(value = {ElementType.METHOD,ElementType.FIELD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RateLimit {

}
