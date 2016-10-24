package cn.m1c.testmodule.person.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import cn.m1c.frame.exception.M1CRuntimeException;
import cn.m1c.frame.vo.RpcResult;
import cn.m1c.testmodule.person.model.User;
import cn.m1c.testmodule.person.service.UserService;

@Controller
@RequestMapping("/api2/account")
public class UserController {
	@Resource
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginByPhone",method = RequestMethod.POST )
	private void login(HttpServletResponse response,@RequestBody User  user ){
		RpcResult rpcResult = RpcResult.success(); 
		try {
			String reString = userService.login("","");
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
