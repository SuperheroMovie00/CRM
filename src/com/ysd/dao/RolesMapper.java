package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.RoleQuery;
import com.ysd.entity.Rolemoban;
import com.ysd.entity.Roles;

public interface RolesMapper {

	// �鿴��½���û��Ľ�ɫ��Ϣ
	public List<Roles> selectuserroles(@Param("LoginName") String LoginName);

	// ��ѯ���еĽ�ɫ��Ϣ
	public List<Roles> selectallroles(RoleQuery role);

	// ���һ����ɫ����Ϣ
	public int insertrole(Roles role);

	// ɾ��һ����ɫ
	public int deleterole(@Param("uid") String uid);

	// �޸�һ����ɫ
	public int updaterole(@Param("Name") String Name, @Param("Id") String Id);

	// �����û���uid��ʾ�û��Ľ�ɫ��Ϣ
	public List<Roles> selectrolefromuid(@Param("UserId") String UserId);

	// �����û���uid��ʾ�û���ӵ�еĽ�ɫ��Ϣ
	public List<Roles> selectNotrolefromuid(@Param("UserId") String UserId);

	// ����û��Ľ�ɫ��Ϣ
	public int AddUserToRole(@Param("username")String username,@Param("Id") String Id,
			@Param("UserId") String UserId, @Param("roleId") String roleId);

	// �Ƴ��û��Ľ�ɫ��Ϣ
	public int RemoveUserFromRole(@Param("UserId") String UserId,
			@Param("roleId") String roleId);

	// ��ѯ�û���Ϣ������
	public int countrole();

	// ��ѯ���еĽ�ɫ
	public List<Roles> selectrolesall();

	// ��ɫģ������
	public List<Rolemoban> rolemoban();

	// ����һ����ɫ
	public int insertrolemoban(Rolemoban role);
	
	//���ݽ�ɫ�����ֲ�ѯ��ɫ
	public Roles selectrolefromname(@Param("rolename")String rolename);
	
	

}
