package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.ysd.entity.Result;
import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.entity.UsersQuery;

public interface UserService {

	// ��ѯ���е��û���Ϣ
	public Result selectuserbypass(String LoginName, String Password);

	// ����û�
	public Result insertuser(User user);

	// ɾ���û�
	public Result deleteuser(String uid);

	// ��ѯ���е��û���Ϣ
	public List<User> selectuser(UsersQuery usersquert);

	// �޸��û���Ϣ
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel);

	// �û�������
	public Result LockUser(String LoginName);

	// �û��Ľ���
	public Result UnLockUser(String LoginName);

	// ��������(����Ϊysd123)
	public Result ResetPassword(String Password, String LoginName);

	// ��ԃ�Ñ���Ϣ���l��
	public int countuser();

	// �޸�����
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password)  throws Exception;

	// ��ѯ���е��û�
	public List<User> selectuserall();

	// ��ѯ���е��û�(ʧЧ)
	public List<User> selectuserer(String id);

	// �û���ģ������
	public List<Usermoban> usermoban();

	// �û��ĵ������
	public int insertusermoban(Usermoban user);

	// ��ѯ���е��û�
	public List<User> selectalluser();

}
