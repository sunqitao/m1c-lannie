package cn.m1c.frame.utils;

import javax.servlet.http.HttpServletRequest;

import cn.m1c.frame.model.BaseModel;
/**
 * 2016年9月19日 web request init userInfo to request
 * @author  phil(s@m1c.cn,m1c softCo.,ltd)
 * @version lannie
 */
public abstract class HttpHelper {

	private static String AUTHED_USER_KEY = "__AUTHED_USER__";
	
	public static BaseModel getAuthUser(HttpServletRequest request){
		return (BaseModel) request.getAttribute(AUTHED_USER_KEY);
	}
	
	public static void setAuthUser(HttpServletRequest request, BaseModel user){
		request.setAttribute(AUTHED_USER_KEY, user);
	}
}