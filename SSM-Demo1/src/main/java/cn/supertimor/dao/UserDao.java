package cn.supertimor.dao;

import org.apache.ibatis.annotations.Param;

import cn.supertimor.bean.User;

/**
 * �־ò�ӿ�
 * @author Administrator
 *
 */
public interface UserDao {

	
	//����û�
	public void addUser(User user);
	
	//�����û����������ѯ�û�  
    //ע��������������Զ���װ��map���ϣ������ڼ�Ϊ��  
    public void findUserByNameAndPwd(@Param("user_name")String user_name,@Param("password")String password); 
	
}
