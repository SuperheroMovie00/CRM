package com.ysd.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.UserMapper;
import com.ysd.entity.Result;
import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.entity.UsersQuery;
import com.ysd.service.UserService;
import com.ysd.util.PasswordEncoder;
import com.ysd.util.SendMail;

@Service
public class UserServiceImpl implements UserService {

	PasswordEncoder encoder = null;
	@Autowired
	private UserMapper userMapper;

	// ��ѯ�û��������ֺ�����(��½)
	@Override
	public Result selectuserbypass(String LoginName, String Password) {

		
		User u = userMapper.selectuserbypass(LoginName);
		if (u == null)
			return new Result(false, null, null, "�û�������Ϊ��");
		if (u.getIsLockout().equals("��")) {
			return new Result(false, null, null, "������");
		}
		if (Password == "")
			return new Result(false, null, null, "���벻��Ϊ��");
		// ���û��������ù�ϣ�����㷨����һ��32λ�ļ������루���뵽���ݿ��У�
		encoder = new PasswordEncoder(LoginName, "Md5");
		String pwdd = encoder.encode(Password);
		if (!u.getPassword().equals(pwdd)) {
			userMapper.psdpassword(LoginName);

			int r = userMapper.numpassword(LoginName);
			if (r == 5) {
				userMapper.LockUser(LoginName);
				userMapper.deletepwdnum(LoginName);
			}
			return new Result(false, null, null, "����������" + r + "��ʣ��" + (5 - r)
					+ "�γ��ԵĻ���");
		}
		userMapper.deletepwdnum(LoginName);
		return new Result(true, u.getId(), u.getLoginName(), "��֤ͨ��");
		

	}

	// ���һ���û�(����һ���û�)
	@Override
	public Result insertuser(User user) {
		
		User u=userMapper.selectuserbypass(user.getLoginName());
		if(u==null){
			int r = userMapper.insertuser(user);
			if (r > 0) {
				return new Result(true, user.getId());

			} else {
				return new Result(false, "���ʧ��");

			}
		}else{
			return new Result(false, "���û����Ѵ���");
		}
		
	}

	// ɾ��һ���û�(�����û���uid)
	@Override
	public Result deleteuser(String uid) {

		System.out.println(uid);
		int r = userMapper.deleteuser(uid);

		if (r > 0) {
			return new Result(true, uid);
		} else {
			return new Result(false, uid);
		}
	}

	// ��ѯ���е��û�
	@Override
	public List<User> selectuser(UsersQuery usersquery) {
		List<User> list = userMapper.selectuser(usersquery);
		System.out.println(list);
		return list;
	}

	// �޸�һ���û�����Ϣ
	@Override
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel) {
		int r = userMapper.updateuser(LoginName, ProtectEMail, protectMTel);
		if (r > 0) {
			return new Result(true, "�޸ĳɹ�");
		} else {
			return new Result(false, "�޸�ʧ��");
		}
	}

	// ����һ���û�(���ݵ�¼��)
	@Override
	public Result LockUser(String LoginName) {
		int r = userMapper.LockUser(LoginName);
		if (r > 0) {
			return new Result(true, "�����ɹ�");
		} else {
			return new Result(false, "����ʧ��");
		}

	}

	// ����һ���û�
	@Override
	public Result UnLockUser(String LoginName) {
		int r = userMapper.UnLockUser(LoginName);
		if (r > 0) {
			return new Result(true, "�����ɹ�");
		} else {
			return new Result(false, "����ʧ��");
		}
	}

	// ��������(����Ϊysd123)
	@Override
	public Result ResetPassword(String Password, String LoginName) {
		int r = userMapper.ResetPassword(Password, LoginName);
		if (r > 0) {
			return new Result(true, "���óɹ�");
		} else {
			return new Result(false, "����ʧ��");
		}

	}

	// �޸�����
	@Override
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password) throws Exception {

		String oldpass = userMapper.selectuserforId(Id);
		if (oldpass.equals(oldpassword)) {

			// ����������ܲ��������ݿ���
			encoder = new PasswordEncoder(roleNames, "Md5");
			String passss = encoder.encode(password);

			int r = userMapper.updatepassword(Id, passss);
			if (r > 0) {
				SendMail.fa(password);
				return new Result(true, "�����޸ĳɹ�");
			} else {
				return new Result(false, "�����޸�ʧ��");
			}

		} else {
			return new Result(false, "������ԭ�������벻һ��");
		}
	}

	// ��ѯ�û�������
	@Override
	public int countuser() {
		return userMapper.countuser();
	}
	
	
	
	//��ѯ���е��û�
	@Override
	public List<User> selectuserall() {
		return userMapper.selectuserall();
	}
	
	
	
	//��ѯ���е��û�(ʧЧ)
	@Override
	public List<User> selectuserer(String id) {
		
		return userMapper.selectuserer(id);
	}

	@Override
	public List<Usermoban> usermoban() {
		
		return userMapper.usermoban();
	}
	
	
	//�û��ĵ������
	@Override
	public int insertusermoban(Usermoban user) {
		
		return userMapper.insertusermoban(user);
	}
	
	// ��ѯ���е��û�
	@Override
	public List<User> selectalluser() {
		
		return userMapper.selectalluser();
	}

}
