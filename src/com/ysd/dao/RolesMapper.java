package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.RoleQuery;
import com.ysd.entity.Rolemoban;
import com.ysd.entity.Roles;

public interface RolesMapper {

	// 查看登陆的用户的角色信息
	public List<Roles> selectuserroles(@Param("LoginName") String LoginName);

	// 查询所有的角色信息
	public List<Roles> selectallroles(RoleQuery role);

	// 添加一个角色的信息
	public int insertrole(Roles role);

	// 删除一个角色
	public int deleterole(@Param("uid") String uid);

	// 修改一个角色
	public int updaterole(@Param("Name") String Name, @Param("Id") String Id);

	// 根据用户的uid显示用户的角色信息
	public List<Roles> selectrolefromuid(@Param("UserId") String UserId);

	// 根据用户的uid显示用户不拥有的角色信息
	public List<Roles> selectNotrolefromuid(@Param("UserId") String UserId);

	// 添加用户的角色信息
	public int AddUserToRole(@Param("username")String username,@Param("Id") String Id,
			@Param("UserId") String UserId, @Param("roleId") String roleId);

	// 移除用户的角色信息
	public int RemoveUserFromRole(@Param("UserId") String UserId,
			@Param("roleId") String roleId);

	// 查询用户信息的条数
	public int countrole();

	// 查询所有的角色
	public List<Roles> selectrolesall();

	// 角色模板下载
	public List<Rolemoban> rolemoban();

	// 新增一个角色
	public int insertrolemoban(Rolemoban role);
	
	//根据角色的名字查询角色
	public Roles selectrolefromname(@Param("rolename")String rolename);
	
	

}
