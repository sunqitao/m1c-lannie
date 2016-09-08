package cn.m1c.frame.utils;
/**
 * @date 2016年7月29日
 * @description io tools
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c soft Co.,ltd
 * @since lannie
 */
public class IOUtil {
	public static void close(AutoCloseable... closeable){
		for (AutoCloseable c : closeable) {
			if(c != null){
				try {c.close();} catch (Exception e) {e.printStackTrace();}
			}
		}
	}
}
