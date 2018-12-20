package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.ysd.entity.Result;
import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.entity.UsersQuery;

public interface UserService {

	// 查询所有的用户信息
	public Result selectuserbypass(String LoginName, String Password);

	// 添加用户
	public Result insertuser(User user);

	// 删除用户
	public Result deleteuser(String uid);

	// 查询所有的用户信息
	public List<User> selectuser(UsersQuery usersquert);

	// 修改用户信息
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel);

	// 用户的锁定
	public Result LockUser(String LoginName);

	// 用户的解锁
	public Result UnLockUser(String LoginName);

	// 重置密码(重置为ysd123)
	public Result ResetPassword(String Password, String LoginName);

	// 查詢用戶信息總條數
	public int countuser();

	// 修改密码
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password)  throws Exception;

	// 查询所有的用户
	public List<User> selectuserall();

	// 查询所有的用户(失效)
	public List<User> selectuserer(String id);

	// 用户的模板下载
	public List<Usermoban> usermoban();

	// 用户的导入添加
	public int insertusermoban(Usermoban user);

	// 查询所有的用户
	public List<User> selectalluser();

}
