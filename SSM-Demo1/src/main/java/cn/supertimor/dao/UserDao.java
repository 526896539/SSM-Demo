package cn.supertimor.dao;

import org.apache.ibatis.annotations.Param;

import cn.supertimor.bean.User;

public interface UserDao {
	//����û�
		public void addUser(User user);
		
		//�����û����������ѯ�û�
		//ע��������������Զ���װ��map���ϣ������ڼ�Ϊ��
		public void findUserByNameAndPwd(@Param("name")String name, @Param("password")String password);
}
