package cn.supertimor.service;

import cn.supertimor.bean.User;

public interface UserService {
	
		//�û�ע��
	public 	void regist(User user);
		//�û���¼
	public  void login(String name, String password);
}
