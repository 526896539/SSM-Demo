package cn.supertimor.service;

import cn.supertimor.bean.User;

public interface UserService {
	
	//用户注册  
    void regist(User user);  
    //用户登录  
    void login(String user_name, String password);  

}
