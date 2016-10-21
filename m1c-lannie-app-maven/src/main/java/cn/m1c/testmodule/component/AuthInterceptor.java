package cn.m1c.testmodule.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.m1c.frame.constants.StatusCode;
import cn.m1c.frame.exception.M1CRuntimeException;
import cn.m1c.frame.utils.WebUtil;
import cn.m1c.frame.vo.RpcResult;

/**
 * 2016年9月19日 
 * @author  phil(s@m1c.cn,m1c softCo.,ltd)
 * @version 1.0.0
 */
public class AuthInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(getClass());
//	@Resource
//	private UserService userService;

	/*
	 * 在这里拦截权限
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl = request.getRequestURI();
		String params = WebUtil.param(request,"token");
		logger.debug("RequestURL:{},params:{}",requestUrl,params);
		if (handler instanceof HandlerMethod) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Security security = getSecurity(handlerMethod);
			String token = WebUtil.getStringByRequestParameter(request, "token", null);
			if (security != null) {
				try {
//					token = CodingUtil.urlDecode(token);
//					AssertUtil.notNull(token, StatusCode.forbidden);
//					Object tokenUserObject = JwtUtil.unSign(token);
//					AssertUtil.notNull(tokenUserObject, StatusCode.forbidden);
//					User user = JSON.parseObject(JSON.toJSONString(tokenUserObject), User.class);
//					AssertUtil.isTrue(Boolean.FALSE.equals(user.getDeleted()), StatusCode.forbidden,
//							"账号被锁定");
//					HttpHelper.setAuthUser(request, user);
				} catch (M1CRuntimeException e) {
					logger.error("帐号内部错误",e);
					RpcResult.status(e.getStatusCode(),e.getMessage()).out(response);
					return false;
				} catch (Exception e) {
					logger.error("代码异常错误。",e);
					RpcResult.status(StatusCode.forbidden).out(response);
					return false;
				}

			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	private Security getSecurity(HandlerMethod handlerMethod) {
		Security security = handlerMethod.getMethodAnnotation(Security.class);
		if (security == null) {
			Class<?> beanType = handlerMethod.getBeanType();
			security = beanType.getAnnotation(Security.class);
		}
		return security;
	}

}