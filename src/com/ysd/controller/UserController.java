package com.ysd.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ysd.entity.Message;
import com.ysd.entity.Result;
import com.ysd.entity.Roles;
import com.ysd.entity.User;
import com.ysd.entity.Userfan;
import com.ysd.entity.UsersQuery;
import com.ysd.service.PermissionService;
import com.ysd.service.RolesService;
import com.ysd.service.UserService;
import com.ysd.util.JwtToken;
import com.ysd.util.PasswordEncoder;
import com.ysd.util.SendMail;

@Controller
@RequestMapping(value = "/user", name = "用户管理")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RolesService rolesService;
	@Autowired
	PermissionService permissionService;

	// 哈希算法声明的密码加密
	PasswordEncoder encoder = null;

	// 登陆功能
	// http://localhost:8080/CRM/login
	private String Id;

	@RequestMapping(value = "login", name = "登陆")
	@ResponseBody
	public Result login(String un, String pwd)
			throws UnsupportedEncodingException, JsonProcessingException {
		Result r = userService.selectuserbypass(un, pwd);
		String re = r.getRemark();
		String cuo = r.getCuowu();
		String id = (String) r.getMessage();
		String loginname = r.getRemark();

		// 获取当前用户所拥有的角色集合
		List<Roles> list = rolesService.selectuserroles(un);
		// 获取当前用户所拥有的权限路径集合
		List<String> permission = permissionService
				.selectpermissionfromuser(un);
		// 声明一个String类型的集合用来存放角色名字
		System.out.println(un + "权限=>" + permission);
		List<String> name = new ArrayList<String>();

		// 循环遍历出角色的名字存入name中
		for (Roles roles : list) {
			name.add(roles.getName());
		}

		// 向Result中各个属性赋值
		Message me = new Message(name, permission, id, loginname);
		boolean success = r.success;
		Result re2 = new Result(success, me, re, cuo);

		// 声明一个密钥将Result放入其中生成一个密钥
		String token = null;
		token = JwtToken.sign(r.message, 300 * 60 * 60 * 1000);
		re2.setRemark(token);
		
		
		/**
		 * 验证码判定
		 */
		/*String code = request.getParameter("code");  
		HttpSession session = request.getSession();  
		String sessionCode = (String) session.getAttribute("code");  
		if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写  
		    throw new RuntimeException("验证码对应不上code=" + code + "  sessionCode=" + sessionCode);  
		}  */
		
		return re2;
	}

	// 获取所有的的用户
	@RequestMapping(value = "GetUsers", name = "获取所有用户")
	@ResponseBody
	public Userfan GetUsers(UsersQuery usersquery) {
		System.out.println(usersquery);

		int r = userService.countuser();

		Userfan user = new Userfan(r, userService.selectuser(usersquery));
		return user;
	}

	// 添加一个用户
	// http://localhost:8080/CRM/insertuser.jsp
	@RequestMapping(value = "CreateUser", name = "添加用户")
	@ResponseBody
	public Result CreateUser(User user) {

		Id = UUID.randomUUID().toString();

		// 将用户名密码用哈希加密算法生成一个32位的加密密码（存入到数据库中）
		encoder = new PasswordEncoder(user.getLoginName(), "Md5");
		String pass = encoder.encode(user.getPassword());

		User user2 = new User(Id, user.getLoginName(), pass,
				user.getProtectEMail(), user.getProtectMTel());
		/*
		 * String remark = resu.remark; boolean success = resu.success; Result
		 * re3 = new Result(success, Id, remark);
		 */
		return userService.insertuser(user2);
	}

	// 删除用户
	@RequestMapping(value = "DeleteUser", name = "删除用户")
	@ResponseBody
	public Result deleteuser(String uid) {
		return userService.deleteuser(uid);
	}

	// 修改一个用户的信息
	@RequestMapping(value = "UpdateUser", name = "修改用户")
	@ResponseBody
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel) {
		return userService.updateuser(LoginName, ProtectEMail, protectMTel);

	}

	// 锁定一个用户
	@RequestMapping(value = "LockUser", name = "锁定用户")
	@ResponseBody
	public Result LockUser(String LoginName) {
		return userService.LockUser(LoginName);

	}

	// 解锁一个用户
	@RequestMapping(value = "UnLockUser", name = "解锁用户")
	@ResponseBody
	public Result UnLockUser(String LoginName) {

		return userService.UnLockUser(LoginName);

	}

	// 重置密码(重置为ysd123)
	@RequestMapping(value = "ResetPassword", name = "重置密码")
	@ResponseBody
	public Result ResetPassword(String Password, String LoginName) {

		// 将用户名密码用哈希加密算法生成一个32位的加密密码（存入到数据库中）
		encoder = new PasswordEncoder(LoginName, "Md5");
		String pass = encoder.encode("ysd123");
		Password = pass;
		return userService.ResetPassword(Password, LoginName);
	}

	// 修改密码自己的(不用设置权限)
	@RequestMapping(value = "updatepassword", name = "修改密码")
	@ResponseBody
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password) throws Exception {

		encoder = new PasswordEncoder(roleNames, "Md5");
		String pass = encoder.encode(oldpassword);
		return userService.updatepassword(roleNames, Id, pass, password);
	}

	// 查询所有的用户
	@RequestMapping("selectalluser")
	@ResponseBody
	public List<User> selectalluser() {
		return userService.selectalluser();
	}
	
	
	

}
