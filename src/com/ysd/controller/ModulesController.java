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
@RequestMapping(value="/module",name="ģ�����")
public class ModulesController {
	
	
	
	@Autowired
	ModulesService modulesService;
	@Autowired
	UserService userService;
	@Autowired
	RolesService rolesService;
	
	
	//���ݽ�ɫ�����ֲ�ѯģ����
    /*localhost:8080/CRM/GetSysRightsHtmlTreeString*/
	@RequestMapping(value="GetSysRightsHtmlTreeString",name="��ѯģ����")
	@ResponseBody
	public List<Modules> GetSysRightsHtmlTreeString(String roleName){
		List<Modules> list=modulesService.selectmodulesfromname(roleName);
		return list;
	}
	
	
	//��ѯ���е�ģ��
	@RequestMapping(value="GetAllModule",name="��ѯģ��")
	@ResponseBody
	public List<Modules> GetAllModule(){
		List<Modules> list=modulesService.selectallmodule();
		return list;
	}
	
	
	//���ݽ�ɫ��id��ѯ����ӵ�е�ģ��		
	@RequestMapping(value="GetModulesByRoleId",name="��ȡ��ɫû�е�ģ��")
	@ResponseBody
	public List<Modules> GetModulesByRoleId(String roleId){
		List<Modules> list=modulesService.GetModulesByRoleId(roleId);
		return list;
	}
	
	//���ݽ�ɫ��id��ѯ��ӵ�е�ģ��		
		@RequestMapping(value="GetNotModulesByRoleId",name="��ȡ��ɫӵ�е�ģ��")
		@ResponseBody
		public List<Modules> GetNotModulesByRoleId(String roleId){
			List<Modules> list=modulesService.GetNotModulesByRoleId(roleId);
			return list;
		}
	
	
	
	//����ɫ����ģ��     
	@RequestMapping(value="SetSysRights",name="����ɫ����ģ��")
	@ResponseBody
	public Result SetSysRights(@RequestParam("ModuleId")List<Integer> ModuleId,String roleId){
	     System.out.println(ModuleId);
		List<Rolemodule> list=new ArrayList<Rolemodule>();
		
		for (int i = 0; i < ModuleId.size(); i++) {
			//UUID����һ��Ψһֵ��forѭ���������Ҳ��뵽Rolemodule������
			String id=UUID.randomUUID().toString();
			list.add(i, new Rolemodule(id, roleId, ModuleId.get(i)));
		}
		return modulesService.SetSysRights(list);	
	}
	
	//����ɫɾ��ģ��     
		@RequestMapping(value="Deletemodule",name="����ɫɾ��ģ��")
		@ResponseBody
		public Result Deletemodule(@RequestParam("ModuleId")List<Integer> ModuleId,String roleId){
			
			
			List<Rolemodule> list=new ArrayList<Rolemodule>();
			
			for (int i = 0; i < ModuleId.size(); i++) {
				//UUID����һ��Ψһֵ��forѭ���������Ҳ��뵽Rolemodule������
				list.add(i, new Rolemodule(roleId, ModuleId.get(i)));
			}
			return modulesService.Deletemodule(list);	
		}
	
	
	
	//ɾ��һ��ģ����Ϣ
	@RequestMapping(value="DeleteModule",name="ɾ��һ��ģ����Ϣ")
	@ResponseBody
	public Result DeleteModule(Integer mid){
		return modulesService.DeleteModule(mid);
	}
	
	//�޸�һ��ģ����Ϣ
	@RequestMapping(value="UpdateModule",name="�޸�һ��ģ����Ϣ")
	@ResponseBody
	public Result UpdateModule(Modules module){
		return modulesService.UpdateModule(module);
	}
	
	
	
	//����һ��ģ�����Ϣ
	@RequestMapping(value="CreateModule",name="����һ��ģ����Ϣ")
	@ResponseBody
	public Result CreateModule(Modules module){
		return modulesService.CreateModule(module);
	}
	
	
	
	
	//���ݽ�ɫ�����ֲ�ѯ���е�ģ����Ϣ
	@RequestMapping("selectmodulefromrolename")
	@ResponseBody
	public List<Modules> selectmodulefromrolename(String roleName){
		System.out.println(roleName);
		return modulesService.selectmodulefromrolename(roleName);
	}
	
	
	//����ģ������ֲ�ѯ���е�ģ����Ϣ
	@RequestMapping(value="selectmodulefromname",name="����ģ������ֲ�ģ��")
	@ResponseBody
	public List<Modules> selectmodulefromname(String Name){
		System.out.println(Name);
		return modulesService.selectmodulefromname(Name);
	}
	
	
	
	
	//��ѯ��ɫ�����е�ģ��
	@RequestMapping("select")
	@ResponseBody
	public List<Modules> select(String roleId){
		return modulesService.select(roleId);
	}
	
	//
	@RequestMapping("modulebaocun")
	@ResponseBody
	public Result modulebaocun(@RequestParam("ModuleId")List<Integer> ModuleId, String roleId){
		//����ɾ���˽�ɫӵ�е���ģ��
		modulesService.deletemodule(roleId);
		//�ٲ���ѡ�е�ģ��
		int r=modulesService.insertmodule(ModuleId, roleId);
		
		if (r > 0) {
			return new Result(true, "��ӳɹ�");
		} else {
			return new Result(false, "���ʧ��");
		}
	}
	
	
	//���ݸ���id��ѯ���ӽڵ��Ԫ��
	@RequestMapping("selectparentmodule")
	@ResponseBody
	public List<Modules> selectparentmodule(Integer pid){
		return modulesService.selectparentmodule(pid);
	}
	
	
	
	
	
	
	
	

}
