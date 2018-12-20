package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Rolemodule;

public interface ModulesMapper {

	// 根据用户的名字查询所拥有的权限模块
	public List<Modules> selectmodulesfromname(
			@Param("roleName") String roleName);

	// 查询所有的模块
	public List<Modules> selectallmodule();

	// 根据角色的id查询角色没有拥有的模块
	public List<Modules> GetModulesByRoleId(@Param("roleId") String roleId);

	// 根据角色的id查询角色拥有的模块
	public List<Modules> GetNotModulesByRoleId(@Param("roleId") String roleId);

	// 给角色设置模块信息
	public int SetSysRights(@Param("module") List<Rolemodule> rolemodule);

	// 删除用户的模块
	public int Deletemodule(@Param("RoleId") String RoleId,
			@Param("ModuleId") Integer ModuleId);

	// 刪除一个模块信息
	public int DeleteModule(@Param("mid") Integer mid);

	// 修改一个模块的信息
	public int UpdateModule(Modules module);

	// 新增一个模块信息
	public int CreateModule(Modules module);

	// 根据角色的名称查询模块的集合
	public List<Modules> selectmodulefromrolename(
			@Param("roleName") String roleName);

	// 根据模块的名字查询所有的模块集合
	public List<Modules> selectmodulefromname(@Param("Name") String Name);

	// 根据id查询所拥有的模块
	public List<Integer> selectmodule(@Param("roleId") String roleId);

	// 查询根据父亲parentid父节点
	public List<Modules> selectmoduleList(@Param("pId") Integer pId);

	// 根据角色的id删除i所拥有的模块
	public int deletemodule(@Param("roleId") String roleId);

	// 根据模块的id插入到相应的角色模块下
	public int insertmodule(@Param("Id")String Id,@Param("ModuleId")Integer ModuleId, @Param("roleId")String roleId);

    //根据父亲id查询子节点
	public List<Modules> selectparentmodule(@Param("pId")Integer pId);
	
	
	
	
}
