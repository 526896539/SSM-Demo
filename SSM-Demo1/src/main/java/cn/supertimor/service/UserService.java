package cn.supertimor.service;

import cn.supertimor.bean.User;

public interface UserService {
	
	//�û�ע��  
    void regist(User user);  
    //�û���¼  
    void login(String user_name, String password);  

}
