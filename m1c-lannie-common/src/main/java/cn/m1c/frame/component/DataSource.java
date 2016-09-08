package cn.m1c.frame.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 2016年8月15日
 * @description 多数据源
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c soft Co.,ltd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    String value();
}