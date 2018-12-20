package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.entity.UsersQuery;


public interface UserMapper {
	
	
	//��ѯ��½���û���Ϣ
	public User selectuserbypass(@Param("LoginName")String LoginName);
	//����û�
	public int insertuser(User user);
    //ɾ���û�
	public int deleteuser(@Param("uid")String uid);
	//��ѯ���е��û���Ϣ
	public List<User> selectuser(UsersQuery userquery);
	//�޸��û�����Ϣ
	public int updateuser(@Param("LoginName")String LoginName,@Param("ProtectEMail")String ProtectEMail,@Param("protectMTel")String protectMTel);
	//�û�������
	public int LockUser(@Param("LoginName")String LoginName);
	//�û��Ľ���
	public int UnLockUser(@Param("LoginName")String LoginName);
	//��������(����Ϊysd123)
	public int ResetPassword(@Param("Password")String Password,@Param("LoginName")String LoginName);
	//�޸�����
	public int updatepassword(@Param("Id")String Id,@Param("password")String password);
	//��ԃ�Ñ���Ϣ���l��
	public int countuser();
	//����id���û�������
	public String selectuserforId(@Param("Id")String Id);
	//��������һ
	public void psdpassword(@Param("LoginName")String LoginName);
	//�������Ĵ���
	public int numpassword(@Param("LoginName")String LoginName);
    //�������������
	public void deletepwdnum(@Param("LoginName")String LoginName);
	//��ѯ���е��û�
	public List<User> selectuserall();
	//����id��ѯ�û�(ʧЧ)
	public List<User> selectuserer(@Param("id")String id);
	//�û���ģ������
	public List<Usermoban> usermoban();
	//�û��ĵ������
	public int  insertusermoban(Usermoban user);
	//��ѯ���е��û�
	public List<User> selectalluser();
		
		
	
	
	
	
	

}
