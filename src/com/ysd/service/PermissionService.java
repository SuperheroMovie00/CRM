package com.ysd.service;

import java.util.List;

import com.ysd.entity.Node;
import com.ysd.entity.NodeER;
import com.ysd.entity.Result;
import com.ysd.entity.SysPermission;
import com.ysd.entity.SysPermissionQuery;
import com.ysd.entity.rolepermission;

public interface PermissionService {
	
	
	/**
	 * 条件分页查询
	 * @param permission
	 * @return
	 */
	public List<SysPermission> query(SysPermissionQuery permission);
	
	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 */
	public List<String> queryAll();
	
	/**
	 * 批量插入权限数据
	 * @param pList
	 * @return 成功插入的权限数据条数
	 */
	public int batchInsert(List<SysPermission> pList);
	
	/**
	 * 查询所有权限操作
	 * @return
	 */
	
	//根据角色的名字查询获取所有权限
	public List<Node> selectallpermission(String roleName);
	
	//获取用户所不拥有的权限
	public List<Node> queryNode(String roleId);
	
	//获取用户所拥有的权限
	public List<Node> queryNotNode(String roleId);
	
	//角色设置权限设置
	public Result rolesetpermission(List<rolepermission> role);
	
	//角色删除权限
	public Result deleterolepermission(List<rolepermission> role);
	
	//根据权限的名字查询权限
	public List<Node> selectpermissionfromname(String name);
	
	//根据用户的名字查询用户拥有的权限
	public List<String> selectpermissionfromuser(String username);
	
	
	public List<NodeER>  select(String roleId);
	
	public int deletepermission(String rid);
	
	
	 
	
	
}
