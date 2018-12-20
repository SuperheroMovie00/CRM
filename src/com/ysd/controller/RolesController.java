package com.ysd.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Result;
import com.ysd.entity.RoleQuery;
import com.ysd.entity.Rolefan;
import com.ysd.entity.Roles;
import com.ysd.service.RolesService;

@Controller
@RequestMapping(value = "/role", name = "��ɫ����")
public class RolesController {

	private String Id;

	private static final String Name = null;
	@Autowired
	RolesService rolesService;

	// ��ȡ���еĽ�ɫ����
	@RequestMapping(value = "GetRolesAll", name = "��ѯ��ɫ")
	@ResponseBody
	public Rolefan selectallroles(RoleQuery role) {
		int r =rolesService.countrole();
		Rolefan list=new Rolefan(r,rolesService.selectallroles(role));
		return list;
	}

	// ���һ����ɫ����
	@RequestMapping(value = "CreateRole", name = "��ӽ�ɫ")
	@ResponseBody
	public Result insertrole(Roles role) {

		// ����һ��������Ψһ��idֵ
		Id = UUID.randomUUID().toString();

		Roles role1 = new Roles(Id, role.getName());
		return rolesService.insertrole(role1);
	}

	// ɾ��һ����ɫ
	@RequestMapping(value = "DeleteRole", name = "ɾ����ɫ")
	@ResponseBody
	public Result deleterole(String roleId) {
		return rolesService.deleterole(roleId);
	}

	// �޸�һ����ɫ
	@RequestMapping(value = "UpdateRole", name = "�޸Ľ�ɫ")
	@ResponseBody
	public Result UpdateRole(String Name, String Id) {
		
		return rolesService.updaterole(Name, Id);
	}

	// ��ѯ�û�ӵ�еĽ�ɫ��Ϣ
	@RequestMapping(value = "GetRoleByUserId", name = "��ѯ�û�ӵ�еĽ�ɫ��Ϣ")
	@ResponseBody
	public List<Roles> selectrolefromuid(String UserId) {

		System.out.println(UserId);
		List<Roles> list = rolesService.selectrolefromuid(UserId);
		return list;
	}
	
	

	// ��ѯ�û�û��ӵ�еĽ�ɫ��Ϣ
	@RequestMapping(value = "GetNotRoleByUserId", name = "��ѯ�û�û�еĽ�ɫ")
	@ResponseBody
	public List<Roles> selectNotrolefromuid(String UserId) {

		System.out.println(UserId);
		List<Roles> list = rolesService.selectNotrolefromuid(UserId);
		return list;
	}

	// �����û������һ����ɫ
	@RequestMapping(value = "AddUserToRole", name = "���û���ӽ�ɫ")
	@ResponseBody
	public Result AddUserToRole(String username,String Id,String UserId, String roleId) {

		// ����һ��������Ψһ��idֵ
		Id = UUID.randomUUID().toString();

		return rolesService.AddUserToRole(username,Id, UserId, roleId);
	}

	// �����û��Ƴ�һ����ɫ
	@RequestMapping(value="RemoveUserFromRole",name="�Ƴ��û���ɫ")
	@ResponseBody
	public Result RemoveUserFromRole(String UserId, String roleId) {
		// ����һ��������Ψһ��idֵ
		Id = UUID.randomUUID().toString();

		return rolesService.RemoveUserFromRole(UserId, roleId);
	}
	
	
	
	//û���κ���Ӳ�ѯ���еĽ�ɫ
	@RequestMapping("selectallrole")
	@ResponseBody
	public List<Roles> selectrolesall(){
		return rolesService.selectrolesall();
	}
	
	
	
	

}
