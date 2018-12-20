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

	// ��ѯģ����Ϣ(���ݽ�ɫ������)
	@Override
	public List<Modules> selectmodulesfromname(String roleName) {
		List<Modules> moduleslist = modulesMapper
				.selectmodulesfromname(roleName);

		return moduleslist;
	}

	// ��ѯ���е�ģ����Ϣ
	@Override
	public List<Modules> selectallmodule() {
		List<Modules> list = modulesMapper.selectallmodule();
		return list;
	}

	// ���ݽ�ɫ��id��ѯ��ɫ��ӵ�е�ģ��
	public List<Modules> GetModulesByRoleId(String roleId) {
		List<Modules> list = modulesMapper.GetModulesByRoleId(roleId);
		return list;
	}

	// ���ݽ�ɫ��id��ѯ��ɫӵ�е�ģ��
	@Override
	public List<Modules> GetNotModulesByRoleId(String roleId) {
		List<Modules> list = modulesMapper.GetNotModulesByRoleId(roleId);
		return list;
	}

	// ���ݽ�ɫ��id����ģ��
	@Override
	public Result SetSysRights(List<Rolemodule> rolemodule) {

		int r = modulesMapper.SetSysRights(rolemodule);
		if (r > 0) {
			return new Result(true, "��ӳɹ�");
		} else {
			return new Result(false, "���ʧ��");
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
			return new Result(true, "ɾ���ɹ�");
		} else {
			return new Result(false, "ɾ��ʧ��");
		}
	}

	// ����ģ��idɾ��һ��ģ�� �м���ɾ��������

	@Override
	public Result DeleteModule(Integer mid) {
		int r = modulesMapper.DeleteModule(mid);
		if (r > 0) {
			return new Result(true, "ɾ��ʧ��");
		} else {
			return new Result(false, "ɾ��");
		}
	}

	// �޸�ģ�����Ϣ
	@Override
	public Result UpdateModule(Modules module) {
		List<Modules> list = modulesMapper.selectparentmodule(module
				.getParentId());
		System.out.println(list);
		for (Modules modules : list) {
			if (modules.getName().equals(module.getName())
					&& modules.getId() != module.getId()) {
				return new Result(false, "�˽ڵ���ģ�����ظ�");
			}
		}
		int r = modulesMapper.UpdateModule(module);
		if (r > 0) {
			return new Result(true, "�޸ĳɹ�");
		} else {

			return new Result(false, "�޸�ʧ��");
		}

	}

	// ����һ��ģ�����Ϣ
	@Override
	public Result CreateModule(Modules module) {
		
		List<Modules> list = modulesMapper.selectparentmodule(module
				.getParentId());
		
		for (Modules modules : list) {
			if (modules.getName().equals(module.getName())
					&& modules.getId() != module.getId()) {
				return new Result(false, "�����ظ�");
			}
		}
		
		int r = modulesMapper.CreateModule(module);
		if (r > 0) {
			return new Result(true, "��ӳɹ�");
		} else {
			return new Result(false, "���ʧ��");
		}
	}

	// ���ݽ�ɫ�����ֲ�ѯģ��ļ���
	@Override
	public List<Modules> selectmodulefromrolename(String roleName) {
		System.out.println(roleName);
		List<Modules> list = modulesMapper.selectmodulefromrolename(roleName);
		return list;
	}

	// ����ģ������ֲ�ѯ���е�ģ�鼯��
	@Override
	public List<Modules> selectmodulefromname(String Name) {
		List<Modules> list = modulesMapper.selectmodulefromname(Name);
		return list;
	}

	// ����id��ѯ��ӵ�е�ģ��
	@Override
	public List<Modules> select(String roleId) {

		// ģ��id�ļ���
		List<Integer> list = modulesMapper.selectmodule(roleId);
		// ��ѯһ���˵�
		List<Modules> list2 = modulesMapper.selectmoduleList(0);
		this.serchildrend(list2, list);

		return list2;
	}

	// ���ú��ӽڵ�
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

	// ���ݽ�ɫ��idɾ����ӵ�е�ģ��
	@Override
	public int deletemodule(String roleId) {
		return modulesMapper.deletemodule(roleId);
	}

	@Override
	public int insertmodule(List<Integer> ModuleId, String roleId) {
		int r = 0;
		// ��������ģ���id������Ӳ���
		for (Integer integer : ModuleId) {
			Id = UUID.randomUUID().toString();
			r = modulesMapper.insertmodule(Id, integer, roleId);
		}
		return r;
	}
	
	// ���ݸ���id��ѯ�ӽڵ�
	@Override
	public List<Modules> selectparentmodule(Integer pid) {
		return modulesMapper.selectparentmodule(pid);
	}

}
