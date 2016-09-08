package cn.m1c.frame.enums;

/**
 * @date 2016年7月27日
 * @description enum interface
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c softCo.,ltd
 * @since lannie
 */
public interface BaseEnum<T> {
    
    public String getName();

    public int getOrdinal();

    public String getChineseName();

    public T parsing(String element);
}
