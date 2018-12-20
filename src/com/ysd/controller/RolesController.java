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
@RequestMapping(value = "/role", name = "角色管理")
public class RolesController {

	private String Id;

	private static final String Name = null;
	@Autowired
	RolesService rolesService;

	// 获取所有的角色功能
	@RequestMapping(value = "GetRolesAll", name = "查询角色")
	@ResponseBody
	public Rolefan selectallroles(RoleQuery role) {
		int r =rolesService.countrole();
		Rolefan list=new Rolefan(r,rolesService.selectallroles(role));
		return list;
	}

	// 添加一个角色功能
	@RequestMapping(value = "CreateRole", name = "添加角色")
	@ResponseBody
	public Result insertrole(Roles role) {

		// 产生一个世界上唯一的id值
		Id = UUID.randomUUID().toString();

		Roles role1 = new Roles(Id, role.getName());
		return rolesService.insertrole(role1);
	}

	// 删除一个角色
	@RequestMapping(value = "DeleteRole", name = "删除角色")
	@ResponseBody
	public Result deleterole(String roleId) {
		return rolesService.deleterole(roleId);
	}

	// 修改一个角色
	@RequestMapping(value = "UpdateRole", name = "修改角色")
	@ResponseBody
	public Result UpdateRole(String Name, String Id) {
		
		return rolesService.updaterole(Name, Id);
	}

	// 查询用户拥有的角色信息
	@RequestMapping(value = "GetRoleByUserId", name = "查询用户拥有的角色信息")
	@ResponseBody
	public List<Roles> selectrolefromuid(String UserId) {

		System.out.println(UserId);
		List<Roles> list = rolesService.selectrolefromuid(UserId);
		return list;
	}
	
	

	// 查询用户没有拥有的角色信息
	@RequestMapping(value = "GetNotRoleByUserId", name = "查询用户没有的角色")
	@ResponseBody
	public List<Roles> selectNotrolefromuid(String UserId) {

		System.out.println(UserId);
		List<Roles> list = rolesService.selectNotrolefromuid(UserId);
		return list;
	}

	// 给此用户新添加一个角色
	@RequestMapping(value = "AddUserToRole", name = "给用户添加角色")
	@ResponseBody
	public Result AddUserToRole(String username,String Id,String UserId, String roleId) {

		// 产生一个世界上唯一的id值
		Id = UUID.randomUUID().toString();

		return rolesService.AddUserToRole(username,Id, UserId, roleId);
	}

	// 给此用户移除一个角色
	@RequestMapping(value="RemoveUserFromRole",name="移除用户角色")
	@ResponseBody
	public Result RemoveUserFromRole(String UserId, String roleId) {
		// 产生一个世界上唯一的id值
		Id = UUID.randomUUID().toString();

		return rolesService.RemoveUserFromRole(UserId, roleId);
	}
	
	
	
	//没有任何添加查询所有的角色
	@RequestMapping("selectallrole")
	@ResponseBody
	public List<Roles> selectrolesall(){
		return rolesService.selectrolesall();
	}
	
	
	
	

}
