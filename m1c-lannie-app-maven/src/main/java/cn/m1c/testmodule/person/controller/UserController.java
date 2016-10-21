package cn.m1c.testmodule.person.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.m1c.frame.exception.M1CRuntimeException;
import cn.m1c.frame.vo.RpcResult;
import cn.m1c.testmodule.person.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@SuppressWarnings("unused")
	@RequestMapping("/login")
	private void login(HttpServletResponse response,String loginName,String pwd){
		RpcResult rpcResult = RpcResult.success(); 
		try {
			String reString = userService.login(loginName, pwd);
			rpcResult.addDatabody("result", reString);
		} catch (M1CRuntimeException e) {
			rpcResult = RpcResult.status(e.getStatusCode());
			logger.info("login warn!",e);
		}catch (Exception e) {
			rpcResult = RpcResult.fail();
			logger.error("login error!",e);
		}
		rpcResult.out(response);
	}
	
}
