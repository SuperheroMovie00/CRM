package com.ysd.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.dao.ModulesMapper;
import com.ysd.entity.Modules;
import com.ysd.entity.Result;
import com.ysd.entity.Rolemodule;
import com.ysd.service.ModulesService;

public class ModulesServiceImpl implements ModulesService {

	@Autowired
	private ModulesMapper modulesMapper;
	private String Id;

	// 查询模块信息(根据角色的名字)
	@Override
	public List<Modules> selectmodulesfromname(String roleName) {
		List<Modules> moduleslist = modulesMapper
				.selectmodulesfromname(roleName);

		return moduleslist;
	}

	// 查询所有的模块信息
	@Override
	public List<Modules> selectallmodule() {
		List<Modules> list = modulesMapper.selectallmodule();
		return list;
	}

	// 根据角色的id查询角色不拥有的模块
	public List<Modules> GetModulesByRoleId(String roleId) {
		List<Modules> list = modulesMapper.GetModulesByRoleId(roleId);
		return list;
	}

	// 根据角色的id查询角色拥有的模块
	@Override
	public List<Modules> GetNotModulesByRoleId(String roleId) {
		List<Modules> list = modulesMapper.GetNotModulesByRoleId(roleId);
		return list;
	}

	// 根据角色的id设置模块
	@Override
	public Result SetSysRights(List<Rolemodule> rolemodule) {

		int r = modulesMapper.SetSysRights(rolemodule);
		if (r > 0) {
			return new Result(true, "添加成功");
		} else {
			return new Result(false, "添加失败");
		}
	}

	@Override
	public Result Deletemodule(List<Rolemodule> rolemodule) {
		int r = 0;

		for (int i = 0; i < rolemodule.size(); i++) {
			r = modulesMapper.Deletemodule(rolemodule.get(i).getRoleId(),
					rolemodule.get(i).getModuleId());
		}
		if (r > 0) {
			return new Result(true, "删除成功");
		} else {
			return new Result(false, "删除失败");
		}
	}

	// 根据模块id删除一个模块 有级联删除的问题

	@Override
	public Result DeleteModule(Integer mid) {
		int r = modulesMapper.DeleteModule(mid);
		if (r > 0) {
			return new Result(true, "删除失败");
		} else {
			return new Result(false, "删除");
		}
	}

	// 修改模块的信息
	@Override
	public Result UpdateModule(Modules module) {
		List<Modules> list = modulesMapper.selectparentmodule(module
				.getParentId());
		System.out.println(list);
		for (Modules modules : list) {
			if (modules.getName().equals(module.getName())
					&& modules.getId() != module.getId()) {
				return new Result(false, "此节点下模块名重复");
			}
		}
		int r = modulesMapper.UpdateModule(module);
		if (r > 0) {
			return new Result(true, "修改成功");
		} else {

			return new Result(false, "修改失败");
		}

	}

	// 新增一个模块的信息
	@Override
	public Result CreateModule(Modules module) {
		
		List<Modules> list = modulesMapper.selectparentmodule(module
				.getParentId());
		
		for (Modules modules : list) {
			if (modules.getName().equals(module.getName())
					&& modules.getId() != module.getId()) {
				return new Result(false, "名字重复");
			}
		}
		
		int r = modulesMapper.CreateModule(module);
		if (r > 0) {
			return new Result(true, "添加成功");
		} else {
			return new Result(false, "添加失败");
		}
	}

	// 根据角色的名字查询模块的集合
	@Override
	public List<Modules> selectmodulefromrolename(String roleName) {
		System.out.println(roleName);
		List<Modules> list = modulesMapper.selectmodulefromrolename(roleName);
		return list;
	}

	// 根据模块的名字查询所有的模块集合
	@Override
	public List<Modules> selectmodulefromname(String Name) {
		List<Modules> list = modulesMapper.selectmodulefromname(Name);
		return list;
	}

	// 根据id查询所拥有的模块
	@Override
	public List<Modules> select(String roleId) {

		// 模块id的集合
		List<Integer> list = modulesMapper.selectmodule(roleId);
		// 查询一级菜单
		List<Modules> list2 = modulesMapper.selectmoduleList(0);
		this.serchildrend(list2, list);

		return list2;
	}

	// 设置孩子节点
	public void serchildrend(List<Modules> pId, List<Integer> moduleIdList) {
		for (Modules modules : pId) {
			List<Modules> list3 = modulesMapper.selectmoduleList(modules
					.getId());
			modules.setChildren(list3);
			if (list3 != null && !list3.isEmpty()) {
				modules.setChildren(list3);
				this.serchildrend(list3, moduleIdList);
			} else {
				if (moduleIdList.contains(modules.getId())) {
					modules.setChecked(true);
				}
			}

		}

	}

	// 根据角色的id删除所拥有的模块
	@Override
	public int deletemodule(String roleId) {
		return modulesMapper.deletemodule(roleId);
	}

	@Override
	public int insertmodule(List<Integer> ModuleId, String roleId) {
		int r = 0;
		// 遍历出来模块的id进行添加操作
		for (Integer integer : ModuleId) {
			Id = UUID.randomUUID().toString();
			r = modulesMapper.insertmodule(Id, integer, roleId);
		}
		return r;
	}
	
	// 根据父亲id查询子节点
	@Override
	public List<Modules> selectparentmodule(Integer pid) {
		return modulesMapper.selectparentmodule(pid);
	}

}
