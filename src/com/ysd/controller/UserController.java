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
@RequestMapping(value = "/user", name = "�û�����")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RolesService rolesService;
	@Autowired
	PermissionService permissionService;

	// ��ϣ�㷨�������������
	PasswordEncoder encoder = null;

	// ��½����
	// http://localhost:8080/CRM/login
	private String Id;

	@RequestMapping(value = "login", name = "��½")
	@ResponseBody
	public Result login(String un, String pwd)
			throws UnsupportedEncodingException, JsonProcessingException {
		Result r = userService.selectuserbypass(un, pwd);
		String re = r.getRemark();
		String cuo = r.getCuowu();
		String id = (String) r.getMessage();
		String loginname = r.getRemark();

		// ��ȡ��ǰ�û���ӵ�еĽ�ɫ����
		List<Roles> list = rolesService.selectuserroles(un);
		// ��ȡ��ǰ�û���ӵ�е�Ȩ��·������
		List<String> permission = permissionService
				.selectpermissionfromuser(un);
		// ����һ��String���͵ļ���������Ž�ɫ����
		System.out.println(un + "Ȩ��=>" + permission);
		List<String> name = new ArrayList<String>();

		// ѭ����������ɫ�����ִ���name��
		for (Roles roles : list) {
			name.add(roles.getName());
		}

		// ��Result�и������Ը�ֵ
		Message me = new Message(name, permission, id, loginname);
		boolean success = r.success;
		Result re2 = new Result(success, me, re, cuo);

		// ����һ����Կ��Result������������һ����Կ
		String token = null;
		token = JwtToken.sign(r.message, 300 * 60 * 60 * 1000);
		re2.setRemark(token);
		
		
		/**
		 * ��֤���ж�
		 */
		/*String code = request.getParameter("code");  
		HttpSession session = request.getSession();  
		String sessionCode = (String) session.getAttribute("code");  
		if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //������֤���Сд  
		    throw new RuntimeException("��֤���Ӧ����code=" + code + "  sessionCode=" + sessionCode);  
		}  */
		
		return re2;
	}

	// ��ȡ���еĵ��û�
	@RequestMapping(value = "GetUsers", name = "��ȡ�����û�")
	@ResponseBody
	public Userfan GetUsers(UsersQuery usersquery) {
		System.out.println(usersquery);

		int r = userService.countuser();

		Userfan user = new Userfan(r, userService.selectuser(usersquery));
		return user;
	}

	// ���һ���û�
	// http://localhost:8080/CRM/insertuser.jsp
	@RequestMapping(value = "CreateUser", name = "����û�")
	@ResponseBody
	public Result CreateUser(User user) {

		Id = UUID.randomUUID().toString();

		// ���û��������ù�ϣ�����㷨����һ��32λ�ļ������루���뵽���ݿ��У�
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

	// ɾ���û�
	@RequestMapping(value = "DeleteUser", name = "ɾ���û�")
	@ResponseBody
	public Result deleteuser(String uid) {
		return userService.deleteuser(uid);
	}

	// �޸�һ���û�����Ϣ
	@RequestMapping(value = "UpdateUser", name = "�޸��û�")
	@ResponseBody
	public Result updateuser(String LoginName, String ProtectEMail,
			String protectMTel) {
		return userService.updateuser(LoginName, ProtectEMail, protectMTel);

	}

	// ����һ���û�
	@RequestMapping(value = "LockUser", name = "�����û�")
	@ResponseBody
	public Result LockUser(String LoginName) {
		return userService.LockUser(LoginName);

	}

	// ����һ���û�
	@RequestMapping(value = "UnLockUser", name = "�����û�")
	@ResponseBody
	public Result UnLockUser(String LoginName) {

		return userService.UnLockUser(LoginName);

	}

	// ��������(����Ϊysd123)
	@RequestMapping(value = "ResetPassword", name = "��������")
	@ResponseBody
	public Result ResetPassword(String Password, String LoginName) {

		// ���û��������ù�ϣ�����㷨����һ��32λ�ļ������루���뵽���ݿ��У�
		encoder = new PasswordEncoder(LoginName, "Md5");
		String pass = encoder.encode("ysd123");
		Password = pass;
		return userService.ResetPassword(Password, LoginName);
	}

	// �޸������Լ���(��������Ȩ��)
	@RequestMapping(value = "updatepassword", name = "�޸�����")
	@ResponseBody
	public Result updatepassword(String roleNames, String Id,
			String oldpassword, String password) throws Exception {

		encoder = new PasswordEncoder(roleNames, "Md5");
		String pass = encoder.encode(oldpassword);
		return userService.updatepassword(roleNames, Id, pass, password);
	}

	// ��ѯ���е��û�
	@RequestMapping("selectalluser")
	@ResponseBody
	public List<User> selectalluser() {
		return userService.selectalluser();
	}
	
	
	

}
