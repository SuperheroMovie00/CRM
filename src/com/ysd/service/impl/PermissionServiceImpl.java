package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.PermissionMapper;
import com.ysd.entity.Node;
import com.ysd.entity.NodeER;
import com.ysd.entity.Result;
import com.ysd.entity.SysPermission;
import com.ysd.entity.SysPermissionQuery;
import com.ysd.entity.rolepermission;
import com.ysd.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper mapper;

	@Override
	public List<SysPermission> query(SysPermissionQuery permission) {
		return mapper.query(permission);
	}

	@Override
	public List<String> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public int batchInsert(List<SysPermission> pList) {
		return mapper.batchInsert(pList);
	}

	// 获取角色所拥有的权限(显示成树)
	@Override
	public List<Node> queryNode(String roleId) {
		return mapper.queryNode(roleId);
	}

	// 获取角色所没有的权限(显示成树)
	@Override
	public List<Node> queryNotNode(String roleId) {
		return mapper.queryNotNode(roleId);
	}

	// 角色设置权限
	@Override
	public Result rolesetpermission(List<rolepermission> role) {
		int r = mapper.rolesetpermission(role);
		if (r > 0) {
			return new Result(true, "权限设置成功");
		} else {
			return new Result(false, "权限设置失败");
		}
	}

	// 角色删除权限
	@Override
	public Result deleterolepermission(List<rolepermission> role) {
		int r = 0;
		for (int i = 0; i < role.size(); i++) {
			r = mapper.deleterolepermission(role.get(i).getRoleId(), role
					.get(i).getPermissionId());
		}
		if (r > 0) {
			return new Result(true, "权限删除成功");
		} else {
			return new Result(false, "权限删除失败");
		}
	}

	// 查询所有的权限
	@Override
	public List<Node> selectallpermission(String roleName) {

		return mapper.selectallpermission(roleName);
	}

	// 根据权限的名字查询权限
	@Override
	public List<Node> selectpermissionfromname(String name) {
		System.out.println(name);
		return mapper.selectpermissionfromname(name);
	}

	// 根据用户的名字查询用户拥有的权限
	@Override
	public List<String> selectpermissionfromuser(String username) {
		return mapper.selectpermissionfromuser(username);
	}

	
	
	//给角色设置权限
	@Override
	public List<NodeER> select(String roleId) {

		// 查询所有的权限
		List<NodeER> list2 = mapper.selecter();
		// 查询角色拥有的权限id
		List<String> list = mapper.select(roleId);
		for (int i = 0; i < list2.size(); i++) {
			List<NodeER> list3 = list2.get(i).getChildren();
			for (NodeER nodeER : list3) {
				for (String nodeer : list) {
					if (nodeER.getId().contains(nodeer)) {
						list2.get(i).setChecked(true);
					}
				}
			}
		}

		return list2;
	}

	@Override
	public int deletepermission(String rid) {
		
		return mapper.deletepermission(rid);
	}
	
	
	

}
