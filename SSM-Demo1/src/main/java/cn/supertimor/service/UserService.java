package cn.supertimor.service;

import cn.supertimor.bean.User;

public interface UserService {
	
		//用户注册
	public 	void regist(User user);
		//用户登录
	public  void login(String name, String password);
}
