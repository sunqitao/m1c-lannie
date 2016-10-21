package cn.m1c.testmodule.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 2016年8月3日
 * @description 自定义注解
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c soft Co.,ltd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Security {

}