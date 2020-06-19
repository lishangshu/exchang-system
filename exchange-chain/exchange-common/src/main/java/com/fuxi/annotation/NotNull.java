package com.fuxi.annotation;

/**
 * @Author: chenghaiming
 * @Date:2018/8/11
 * @Description：
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NotNull {
    String value();
}