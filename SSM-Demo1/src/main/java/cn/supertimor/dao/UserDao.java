package cn.supertimor.dao;

import org.apache.ibatis.annotations.Param;

import cn.supertimor.bean.User;

/**
 * 持久层接口
 * @author Administrator
 *
 */
public interface UserDao {

	
	//添加用户
	public void addUser(User user);
	
	//根据用户名和密码查询用户  
    //注解的两个参数会自动封装成map集合，括号内即为键  
    public void findUserByNameAndPwd(@Param("user_name")String user_name,@Param("password")String password); 
	
}
