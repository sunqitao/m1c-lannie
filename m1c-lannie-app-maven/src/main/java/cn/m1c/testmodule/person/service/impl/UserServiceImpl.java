package cn.m1c.testmodule.person.service.impl;

import org.springframework.stereotype.Service;

import cn.m1c.testmodule.person.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	public String login(String loginName, String pwd) {
		return "loginName:"+loginName+"  pwd:正确";
	}

}
