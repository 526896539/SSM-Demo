package cn.supertimor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.supertimor.bean.User;
import cn.supertimor.dao.UserDao;
import cn.supertimor.service.UserService;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void login(String name, String password) {
		// TODO Auto-generated method stub
		userDao.findUserByNameAndPwd(name,password);
	}

}
