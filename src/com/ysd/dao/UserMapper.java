package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.entity.UsersQuery;


public interface UserMapper {
	
	
	//查询登陆的用户信息
	public User selectuserbypass(@Param("LoginName")String LoginName);
	//添加用户
	public int insertuser(User user);
    //删除用户
	public int deleteuser(@Param("uid")String uid);
	//查询所有的用户信息
	public List<User> selectuser(UsersQuery userquery);
	//修改用户的信息
	public int updateuser(@Param("LoginName")String LoginName,@Param("ProtectEMail")String ProtectEMail,@Param("protectMTel")String protectMTel);
	//用户的锁定
	public int LockUser(@Param("LoginName")String LoginName);
	//用户的解锁
	public int UnLockUser(@Param("LoginName")String LoginName);
	//重置密码(重置为ysd123)
	public int ResetPassword(@Param("Password")String Password,@Param("LoginName")String LoginName);
	//修改密码
	public int updatepassword(@Param("Id")String Id,@Param("password")String password);
	//查詢用戶信息總條數
	public int countuser();
	//根據id查用户的密码
	public String selectuserforId(@Param("Id")String Id);
	//密码错误加一
	public void psdpassword(@Param("LoginName")String LoginName);
	//密码错误的次数
	public int numpassword(@Param("LoginName")String LoginName);
    //清除密码错误次数
	public void deletepwdnum(@Param("LoginName")String LoginName);
	//查询所有的用户
	public List<User> selectuserall();
	//根据id查询用户(失效)
	public List<User> selectuserer(@Param("id")String id);
	//用户的模板下载
	public List<Usermoban> usermoban();
	//用户的导入添加
	public int  insertusermoban(Usermoban user);
	//查询所有的用户
	public List<User> selectalluser();
		
		
	
	
	
	
	

}
