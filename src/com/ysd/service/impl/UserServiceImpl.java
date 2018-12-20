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

	// 查询用户根据名字和密码(登陆)
	@Override
	public Result selectuserbypass(String LoginName, String Password) {

		
		User u = userMapper.selectuserbypass(LoginName);
		if (u == null)
			return new Result(false, null, null, "用户名不能为空");
		if (u.getIsLockout().equals("是")) {
			return new Result(false, null, null, "已锁定");
		}
		if (Password == "")
			return new Result(false, null, null, "密码不能为空");
		// 将用户名密码用哈希加密算法生成一个32位的加密密码（存入到数据库中）
		encoder = new PasswordEncoder(LoginName, "Md5");
		String pwdd = encoder.encode(Password);
		if (!u.getPassword().equals(pwdd)) {
			userMapper.psdpassword(LoginName);

			int r = userMapper.numpassword(LoginName);
			if (r == 5) {
				userMapper.LockUser(LoginName);
				userMapper.deletepwdnum(LoginName);
			}
			return new Result(false, null, null, "密码错误次数" + r + "还剩下" + (5 - r)
					+ "次尝试的机会");
		}
		userMapper.deletepwdnum(LoginName);
		return new Result(true, u.getId(), u.getLoginName(), "验证通过");
		

	}

	// 添加一个用户(传入一个用户)
	@Override
	public Result insertuser(User user) {
		
		User u=userMapper.selectuserbypass(user.getLoginName());
		if(u==null){
			int r = userMapper.insertuser(user);
			if (r > 0) {
				return new Result(true, user.getId());

			} else {
				return new Result(false, "添加失败");

			}
		}else{
			return new Result(false, "此用户名已存在");
		}
		
	}

	// 删除一个用户(根据用户的uid)
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

	// 查询所有的用户
	@Override
	public List<User> selectuser(UsersQuery usersquery) {
		List<User> list = userMapper.selectuser(usersquery);
		System.out.println(list);
		return list;
	}

	// 修改一个用户的信息
	@Override
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel) {
		int r = userMapper.updateuser(LoginName, ProtectEMail, protectMTel);
		if (r > 0) {
			return new Result(true, "修改成功");
		} else {
			return new Result(false, "修改失败");
		}
	}

	// 锁定一个用户(根据登录名)
	@Override
	public Result LockUser(String LoginName) {
		int r = userMapper.LockUser(LoginName);
		if (r > 0) {
			return new Result(true, "锁定成功");
		} else {
			return new Result(false, "锁定失败");
		}

	}

	// 解锁一个用户
	@Override
	public Result UnLockUser(String LoginName) {
		int r = userMapper.UnLockUser(LoginName);
		if (r > 0) {
			return new Result(true, "解锁成功");
		} else {
			return new Result(false, "解锁失败");
		}
	}

	// 重置密码(重置为ysd123)
	@Override
	public Result ResetPassword(String Password, String LoginName) {
		int r = userMapper.ResetPassword(Password, LoginName);
		if (r > 0) {
			return new Result(true, "重置成功");
		} else {
			return new Result(false, "重置失败");
		}

	}

	// 修改密码
	@Override
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password) throws Exception {

		String oldpass = userMapper.selectuserforId(Id);
		if (oldpass.equals(oldpassword)) {

			// 将新密码加密并存入数据库中
			encoder = new PasswordEncoder(roleNames, "Md5");
			String passss = encoder.encode(password);

			int r = userMapper.updatepassword(Id, passss);
			if (r > 0) {
				SendMail.fa(password);
				return new Result(true, "密码修改成功");
			} else {
				return new Result(false, "密码修改失败");
			}

		} else {
			return new Result(false, "输入与原来的输入不一致");
		}
	}

	// 查询用户总条数
	@Override
	public int countuser() {
		return userMapper.countuser();
	}
	
	
	
	//查询所有的用户
	@Override
	public List<User> selectuserall() {
		return userMapper.selectuserall();
	}
	
	
	
	//查询所有的用户(失效)
	@Override
	public List<User> selectuserer(String id) {
		
		return userMapper.selectuserer(id);
	}

	@Override
	public List<Usermoban> usermoban() {
		
		return userMapper.usermoban();
	}
	
	
	//用户的导入添加
	@Override
	public int insertusermoban(Usermoban user) {
		
		return userMapper.insertusermoban(user);
	}
	
	// 查询所有的用户
	@Override
	public List<User> selectalluser() {
		
		return userMapper.selectalluser();
	}

}
