package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Rolemodule;

public interface ModulesMapper {

	// �����û������ֲ�ѯ��ӵ�е�Ȩ��ģ��
	public List<Modules> selectmodulesfromname(
			@Param("roleName") String roleName);

	// ��ѯ���е�ģ��
	public List<Modules> selectallmodule();

	// ���ݽ�ɫ��id��ѯ��ɫû��ӵ�е�ģ��
	public List<Modules> GetModulesByRoleId(@Param("roleId") String roleId);

	// ���ݽ�ɫ��id��ѯ��ɫӵ�е�ģ��
	public List<Modules> GetNotModulesByRoleId(@Param("roleId") String roleId);

	// ����ɫ����ģ����Ϣ
	public int SetSysRights(@Param("module") List<Rolemodule> rolemodule);

	// ɾ���û���ģ��
	public int Deletemodule(@Param("RoleId") String RoleId,
			@Param("ModuleId") Integer ModuleId);

	// �h��һ��ģ����Ϣ
	public int DeleteModule(@Param("mid") Integer mid);

	// �޸�һ��ģ�����Ϣ
	public int UpdateModule(Modules module);

	// ����һ��ģ����Ϣ
	public int CreateModule(Modules module);

	// ���ݽ�ɫ�����Ʋ�ѯģ��ļ���
	public List<Modules> selectmodulefromrolename(
			@Param("roleName") String roleName);

	// ����ģ������ֲ�ѯ���е�ģ�鼯��
	public List<Modules> selectmodulefromname(@Param("Name") String Name);

	// ����id��ѯ��ӵ�е�ģ��
	public List<Integer> selectmodule(@Param("roleId") String roleId);

	// ��ѯ���ݸ���parentid���ڵ�
	public List<Modules> selectmoduleList(@Param("pId") Integer pId);

	// ���ݽ�ɫ��idɾ��i��ӵ�е�ģ��
	public int deletemodule(@Param("roleId") String roleId);

	// ����ģ���id���뵽��Ӧ�Ľ�ɫģ����
	public int insertmodule(@Param("Id")String Id,@Param("ModuleId")Integer ModuleId, @Param("roleId")String roleId);

    //���ݸ���id��ѯ�ӽڵ�
	public List<Modules> selectparentmodule(@Param("pId")Integer pId);
	
	
	
	
}
