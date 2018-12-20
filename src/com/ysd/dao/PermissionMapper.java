package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Node;
import com.ysd.entity.NodeER;
import com.ysd.entity.SysPermission;
import com.ysd.entity.SysPermissionQuery;
import com.ysd.entity.rolepermission;

public interface PermissionMapper {

	/**
	 * 条件分页查询
	 * 
	 * @param permission
	 * @return
	 */
	public List<SysPermission> query(SysPermissionQuery permission);

	/**
	 * 查询所有权限集合
	 * 
	 * @return 权限字符串集合
	 */
	public List<String> queryAll();

	/**
	 * 批量插入权限数据
	 * 
	 * @param pList
	 * @return 成功插入的权限数据条数
	 */
	public int batchInsert(List<SysPermission> pList);

	/**
	 * 查询用户所用有权限操作
	 * 
	 * @return
	 */

	// 获取用户所不拥有的权限
	public List<Node> queryNode(@Param("roleId") String roleId);

	// 获取用户所拥有的权限
	public List<Node> queryNotNode(@Param("roleId") String roleId);

	/**
	 * 权限设置
	 */

	// 权限设置
	public int rolesetpermission(List<rolepermission> role);

	// 权限删除
	public int deleterolepermission(@Param("roleId") String roleId,
			@Param("permissionId") String permissionId);

	// 根据角色的名字查询所有的权限
	public List<Node> selectallpermission(@Param("roleName") String roleName);

	// 根据权限的名字查询权限
	public List<Node> selectpermissionfromname(@Param("name") String name);

	// 根据用户的名字查询用户拥有的权限
	public List<String> selectpermissionfromuser(
			@Param("username") String username);

	public List<String> select(String roleid);

	public List<NodeER> selecter();

	public int deletepermission(@Param("rid") String rid);

}
