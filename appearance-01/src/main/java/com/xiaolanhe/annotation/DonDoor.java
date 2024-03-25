package com.xiaolanhe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.annotation
 * @date 2024/3/25 23:31
 */


// 切面注解定义
/**
 1.此注解添加到需要扩展白名单的方法上
 2.两个入参，key：获取某个字段例如用户ID、returnJson：确定白名单拦截后返回的具体内容。
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DonDoor {
    String key() default "";

    String returnJson() default "";
}
