package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Result;
import com.ysd.entity.Rolemodule;

public interface ModulesService {
	
	    //�����û������ֲ�ѯ��ӵ�е�Ȩ��ģ��
		public List<Modules> selectmodulesfromname(String roleName);
		//��ѯ���е�ģ��
		public List<Modules> selectallmodule();
		//���ݽ�ɫ��id��ѯ��ɫû��ӵ�е�ģ��
		public List<Modules> GetModulesByRoleId(String roleId);
		//���ݽ�ɫ��id��ѯ��ɫӵ�е�ģ��
		public List<Modules> GetNotModulesByRoleId(String roleId);
		//����ɫ����ģ����Ϣ
		public Result SetSysRights(List<Rolemodule> rolemodule);
		//����ɫ����ģ����Ϣ
		public Result Deletemodule(List<Rolemodule> rolemodule);
		//����ģ���idɾ��һ��ģ��
		public Result DeleteModule(Integer mid);
		//�޸�һ��ģ�����Ϣ
		public Result UpdateModule(Modules module); 
		//����һ��ģ����Ϣ
		public Result CreateModule(Modules module);
		//���ݽ�ɫ�����ֲ�ѯģ��ļ���
		public List<Modules> selectmodulefromrolename(String roleName);
		//����ģ������ֲ�ѯ���е�ģ�鼯��
		public List<Modules> selectmodulefromname(String Name);
		//��ѯ����ģ��
		public List<Modules> select(String roleId);
		//���ݽ�ɫ��idɾ��i��ӵ�е�ģ��
		public int deletemodule(String roleId);
		//����ģ���id���뵽��Ӧ�Ľ�ɫģ����
		public int insertmodule(List<Integer> ModuleId,String roleId);
		//���ݸ���id��ѯ�ӽڵ�
		public List<Modules> selectparentmodule(Integer pid);
		
		
		
	
		
		
		
		
		
}
