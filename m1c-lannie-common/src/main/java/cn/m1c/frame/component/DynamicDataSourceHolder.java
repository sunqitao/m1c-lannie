package cn.m1c.frame.component;
/**
 * 2016年11月19日  借用threadlocal 存储当前数据源
 * @author  phil(s@m1c.cn,m1c softCo.,ltd)
 * @version lannie
 */
public class DynamicDataSourceHolder {
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }
}