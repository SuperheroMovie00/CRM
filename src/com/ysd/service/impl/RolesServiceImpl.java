package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.AskersMapper;
import com.ysd.dao.RolesMapper;
import com.ysd.dao.UserCheckMapper;
import com.ysd.entity.Result;
import com.ysd.entity.RoleQuery;
import com.ysd.entity.Rolemoban;
import com.ysd.entity.Roles;
import com.ysd.entity.UserChecks;
import com.ysd.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

	// 查询用户的角色信息(根据登陆名字)
	@Autowired
	private RolesMapper rolesMapper;
	@Autowired
	private UserCheckMapper usercheckmapper;
	@Autowired
	private AskersMapper askermapper;


	@Override
	public List<Roles> selectuserroles(String LoginName) {
		List<Roles> list = rolesMapper.selectuserroles(LoginName);
		return list;
	}

	// 查询所有的角色信息
	@Override
	public List<Roles> selectallroles(RoleQuery role) {
		List<Roles> list = rolesMapper.selectallroles(role);
		return list;
	}

	// 添加一个角色(传入一个角色对象)
	@Override
	public Result insertrole(Roles role) {
		Roles t=rolesMapper.selectrolefromname(role.getName());
		if(t==null){
			int r = rolesMapper.insertrole(role);
			if (r > 0) {
				return new Result(true, role.getId(), "添加成功");
			} else {
				return new Result(false, "添加失败");
			}
		}else{
			return new Result(false, "此用户名重复");
			
		}
		

		

	}

	// 删除一个角色信息(传入一个uid)
	@Override
	public Result deleterole(String roleId) {

		int r = rolesMapper.deleterole(roleId);
		if (r > 0) {
			return new Result(true, "添加成功");

		} else {

			return new Result(false, "添加失败");
		}
	}

	// 修改一个角色信息
	@Override
	public Result updaterole(String Name, String Id) {
		Roles t=rolesMapper.selectrolefromname(Name);
		if(t==null){
			int r = rolesMapper.updaterole(Name, Id);
			if (r > 0) {
				return new Result(true, "修改成功");
			} else {
				return new Result(false, "修改失败");
			}
			
		}else if(t.getId().equals(Id)){
			int r = rolesMapper.updaterole(Name, Id);
			if (r > 0) {
				return new Result(true, "修改成功");
			} else {
				return new Result(false, "修改失败");
			}
		}else{
			return new Result(false, "此角色名已存在");
		}
	}

	// 根据用户的uid显示用户的角色信息
	@Override
	public List<Roles> selectrolefromuid(String UserId) {
		System.out.println(UserId);

		List<Roles> list = rolesMapper.selectrolefromuid(UserId);
		return list;
	}

	// 根据的用户的uid显示用户不拥有的角色信息
	@Override
	public List<Roles> selectNotrolefromuid(String UserId) {
		System.out.println(UserId);

		List<Roles> list = rolesMapper.selectNotrolefromuid(UserId);
		return list;
	}

	// 添加用户的角色信息
	@Override
	public Result AddUserToRole(String username,String Id, String UserId, String roleId) {
		
		System.out.println(username);
		System.out.println(Id);
		System.out.println(UserId);
		System.out.println(roleId);
		
		if(roleId.equals("bab0aa41-0aec-11e7-9a05-408d5cd46d51")){
			UserChecks userChecks=usercheckmapper.selectstate(username);
			if(userChecks!=null){
				askermapper.insertasker(UserId, username);
			}else{
				askermapper.insertaskerer(UserId, username);
			} 
		}
		
		int r = rolesMapper.AddUserToRole(username,Id, UserId, roleId);

		if (r > 0) {
			return new Result(true, "附加角色成功");
		} else {
			return new Result(false, "附加角色失败");
		}

	}

	// 移除用户的角色信息
	@Override
	public Result RemoveUserFromRole(String UserId, String roleId) {
		
		if(roleId.equals("bab0aa41-0aec-11e7-9a05-408d5cd46d51")){
			askermapper.deleteasker(UserId);
		}
		int r = rolesMapper.RemoveUserFromRole(UserId, roleId);
		if (r > 0) {
			return new Result(true, "附加角色成功");
		} else {
			return new Result(false, "附加角色失败");
		}
	}

	// 查询所有信息的条数
	@Override
	public int countrole() {
		return rolesMapper.countrole();
	}
	
	/*查询所有的用户*/
	@Override
	public List<Roles> selectrolesall() {
		return rolesMapper.selectrolesall();
	}
	
	/*角色批量导入模板下载*/
	public List<Rolemoban> rolemoban(){
		return rolesMapper.rolemoban();
	}
	
	
	//新增一个角色
	@Override
	public int insertrolemoban(Rolemoban role) {
		return rolesMapper.insertrolemoban(role);
	}

	//根据角色的名字查询角色
	@Override
	public Roles selectrolefromname(String rolename) {
		return rolesMapper.selectrolefromname(rolename);
	}

}
