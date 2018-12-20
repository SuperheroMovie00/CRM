package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Result;
import com.ysd.entity.Rolemodule;

public interface ModulesService {
	
	    //根据用户的名字查询所拥有的权限模块
		public List<Modules> selectmodulesfromname(String roleName);
		//查询所有的模块
		public List<Modules> selectallmodule();
		//根据角色的id查询角色没有拥有的模块
		public List<Modules> GetModulesByRoleId(String roleId);
		//根据角色的id查询角色拥有的模块
		public List<Modules> GetNotModulesByRoleId(String roleId);
		//给角色设置模块信息
		public Result SetSysRights(List<Rolemodule> rolemodule);
		//给角色设置模块信息
		public Result Deletemodule(List<Rolemodule> rolemodule);
		//根据模块的id删除一个模块
		public Result DeleteModule(Integer mid);
		//修改一个模块的信息
		public Result UpdateModule(Modules module); 
		//新增一个模块信息
		public Result CreateModule(Modules module);
		//根据角色的名字查询模块的集合
		public List<Modules> selectmodulefromrolename(String roleName);
		//根据模块的名字查询所有的模块集合
		public List<Modules> selectmodulefromname(String Name);
		//查询所有模块
		public List<Modules> select(String roleId);
		//根据角色的id删除i所拥有的模块
		public int deletemodule(String roleId);
		//根据模块的id插入到相应的角色模块下
		public int insertmodule(List<Integer> ModuleId,String roleId);
		//根据父亲id查询子节点
		public List<Modules> selectparentmodule(Integer pid);
		
		
		
	
		
		
		
		
		
}
