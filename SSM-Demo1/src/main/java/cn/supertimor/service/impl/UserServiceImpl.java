package cn.supertimor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.supertimor.bean.User;
import cn.supertimor.dao.UserDao;
import cn.supertimor.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired  
    private UserDao userDao;  
      
    @Override  
    public void regist(User user) {  
        userDao.addUser(user);  
    }  
  
    @Override  
    public void login(String user_name, String password) {  
        userDao.findUserByNameAndPwd(user_name,password);  
    }  
}
