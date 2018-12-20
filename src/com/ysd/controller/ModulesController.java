package com.ysd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ysd.entity.Modules;
import com.ysd.entity.Result;
import com.ysd.entity.Rolemodule;
import com.ysd.service.ModulesService;
import com.ysd.service.RolesService;
import com.ysd.service.UserService;

@Controller
@RequestMapping(value="/module",name="模块管理")
public class ModulesController {
	
	
	
	@Autowired
	ModulesService modulesService;
	@Autowired
	UserService userService;
	@Autowired
	RolesService rolesService;
	
	
	//根据角色的名字查询模块树
    /*localhost:8080/CRM/GetSysRightsHtmlTreeString*/
	@RequestMapping(value="GetSysRightsHtmlTreeString",name="查询模块树")
	@ResponseBody
	public List<Modules> GetSysRightsHtmlTreeString(String roleName){
		List<Modules> list=modulesService.selectmodulesfromname(roleName);
		return list;
	}
	
	
	//查询所有的模块
	@RequestMapping(value="GetAllModule",name="查询模块")
	@ResponseBody
	public List<Modules> GetAllModule(){
		List<Modules> list=modulesService.selectallmodule();
		return list;
	}
	
	
	//根据角色的id查询所不拥有的模块		
	@RequestMapping(value="GetModulesByRoleId",name="获取角色没有的模块")
	@ResponseBody
	public List<Modules> GetModulesByRoleId(String roleId){
		List<Modules> list=modulesService.GetModulesByRoleId(roleId);
		return list;
	}
	
	//根据角色的id查询所拥有的模块		
		@RequestMapping(value="GetNotModulesByRoleId",name="获取角色拥有的模块")
		@ResponseBody
		public List<Modules> GetNotModulesByRoleId(String roleId){
			List<Modules> list=modulesService.GetNotModulesByRoleId(roleId);
			return list;
		}
	
	
	
	//给角色设置模块     
	@RequestMapping(value="SetSysRights",name="给角色设置模块")
	@ResponseBody
	public Result SetSysRights(@RequestParam("ModuleId")List<Integer> ModuleId,String roleId){
	     System.out.println(ModuleId);
		List<Rolemodule> list=new ArrayList<Rolemodule>();
		
		for (int i = 0; i < ModuleId.size(); i++) {
			//UUID生成一个唯一值并for循环遍历并且插入到Rolemodule集合中
			String id=UUID.randomUUID().toString();
			list.add(i, new Rolemodule(id, roleId, ModuleId.get(i)));
		}
		return modulesService.SetSysRights(list);	
	}
	
	//给角色删除模块     
		@RequestMapping(value="Deletemodule",name="给角色删除模块")
		@ResponseBody
		public Result Deletemodule(@RequestParam("ModuleId")List<Integer> ModuleId,String roleId){
			
			
			List<Rolemodule> list=new ArrayList<Rolemodule>();
			
			for (int i = 0; i < ModuleId.size(); i++) {
				//UUID生成一个唯一值并for循环遍历并且插入到Rolemodule集合中
				list.add(i, new Rolemodule(roleId, ModuleId.get(i)));
			}
			return modulesService.Deletemodule(list);	
		}
	
	
	
	//删除一个模块信息
	@RequestMapping(value="DeleteModule",name="删除一个模块信息")
	@ResponseBody
	public Result DeleteModule(Integer mid){
		return modulesService.DeleteModule(mid);
	}
	
	//修改一个模块信息
	@RequestMapping(value="UpdateModule",name="修改一个模块信息")
	@ResponseBody
	public Result UpdateModule(Modules module){
		return modulesService.UpdateModule(module);
	}
	
	
	
	//新增一个模块的信息
	@RequestMapping(value="CreateModule",name="新增一个模块信息")
	@ResponseBody
	public Result CreateModule(Modules module){
		return modulesService.CreateModule(module);
	}
	
	
	
	
	//根据角色的名字查询所有的模块信息
	@RequestMapping("selectmodulefromrolename")
	@ResponseBody
	public List<Modules> selectmodulefromrolename(String roleName){
		System.out.println(roleName);
		return modulesService.selectmodulefromrolename(roleName);
	}
	
	
	//根据模块的名字查询所有的模块信息
	@RequestMapping(value="selectmodulefromname",name="根据模块的名字查模块")
	@ResponseBody
	public List<Modules> selectmodulefromname(String Name){
		System.out.println(Name);
		return modulesService.selectmodulefromname(Name);
	}
	
	
	
	
	//查询角色所有有的模块
	@RequestMapping("select")
	@ResponseBody
	public List<Modules> select(String roleId){
		return modulesService.select(roleId);
	}
	
	//
	@RequestMapping("modulebaocun")
	@ResponseBody
	public Result modulebaocun(@RequestParam("ModuleId")List<Integer> ModuleId, String roleId){
		//首先删除此角色拥有的所模块
		modulesService.deletemodule(roleId);
		//再插入选中的模块
		int r=modulesService.insertmodule(ModuleId, roleId);
		
		if (r > 0) {
			return new Result(true, "添加成功");
		} else {
			return new Result(false, "添加失败");
		}
	}
	
	
	//根据父亲id查询其子节点的元素
	@RequestMapping("selectparentmodule")
	@ResponseBody
	public List<Modules> selectparentmodule(Integer pid){
		return modulesService.selectparentmodule(pid);
	}
	
	
	
	
	
	
	
	

}
