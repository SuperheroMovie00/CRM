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

	// ��ѯ�û��Ľ�ɫ��Ϣ(���ݵ�½����)
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

	// ��ѯ���еĽ�ɫ��Ϣ
	@Override
	public List<Roles> selectallroles(RoleQuery role) {
		List<Roles> list = rolesMapper.selectallroles(role);
		return list;
	}

	// ���һ����ɫ(����һ����ɫ����)
	@Override
	public Result insertrole(Roles role) {
		Roles t=rolesMapper.selectrolefromname(role.getName());
		if(t==null){
			int r = rolesMapper.insertrole(role);
			if (r > 0) {
				return new Result(true, role.getId(), "��ӳɹ�");
			} else {
				return new Result(false, "���ʧ��");
			}
		}else{
			return new Result(false, "���û����ظ�");
			
		}
		

		

	}

	// ɾ��һ����ɫ��Ϣ(����һ��uid)
	@Override
	public Result deleterole(String roleId) {

		int r = rolesMapper.deleterole(roleId);
		if (r > 0) {
			return new Result(true, "��ӳɹ�");

		} else {

			return new Result(false, "���ʧ��");
		}
	}

	// �޸�һ����ɫ��Ϣ
	@Override
	public Result updaterole(String Name, String Id) {
		Roles t=rolesMapper.selectrolefromname(Name);
		if(t==null){
			int r = rolesMapper.updaterole(Name, Id);
			if (r > 0) {
				return new Result(true, "�޸ĳɹ�");
			} else {
				return new Result(false, "�޸�ʧ��");
			}
			
		}else if(t.getId().equals(Id)){
			int r = rolesMapper.updaterole(Name, Id);
			if (r > 0) {
				return new Result(true, "�޸ĳɹ�");
			} else {
				return new Result(false, "�޸�ʧ��");
			}
		}else{
			return new Result(false, "�˽�ɫ���Ѵ���");
		}
	}

	// �����û���uid��ʾ�û��Ľ�ɫ��Ϣ
	@Override
	public List<Roles> selectrolefromuid(String UserId) {
		System.out.println(UserId);

		List<Roles> list = rolesMapper.selectrolefromuid(UserId);
		return list;
	}

	// ���ݵ��û���uid��ʾ�û���ӵ�еĽ�ɫ��Ϣ
	@Override
	public List<Roles> selectNotrolefromuid(String UserId) {
		System.out.println(UserId);

		List<Roles> list = rolesMapper.selectNotrolefromuid(UserId);
		return list;
	}

	// ����û��Ľ�ɫ��Ϣ
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
			return new Result(true, "���ӽ�ɫ�ɹ�");
		} else {
			return new Result(false, "���ӽ�ɫʧ��");
		}

	}

	// �Ƴ��û��Ľ�ɫ��Ϣ
	@Override
	public Result RemoveUserFromRole(String UserId, String roleId) {
		
		if(roleId.equals("bab0aa41-0aec-11e7-9a05-408d5cd46d51")){
			askermapper.deleteasker(UserId);
		}
		int r = rolesMapper.RemoveUserFromRole(UserId, roleId);
		if (r > 0) {
			return new Result(true, "���ӽ�ɫ�ɹ�");
		} else {
			return new Result(false, "���ӽ�ɫʧ��");
		}
	}

	// ��ѯ������Ϣ������
	@Override
	public int countrole() {
		return rolesMapper.countrole();
	}
	
	/*��ѯ���е��û�*/
	@Override
	public List<Roles> selectrolesall() {
		return rolesMapper.selectrolesall();
	}
	
	/*��ɫ��������ģ������*/
	public List<Rolemoban> rolemoban(){
		return rolesMapper.rolemoban();
	}
	
	
	//����һ����ɫ
	@Override
	public int insertrolemoban(Rolemoban role) {
		return rolesMapper.insertrolemoban(role);
	}

	//���ݽ�ɫ�����ֲ�ѯ��ɫ
	@Override
	public Roles selectrolefromname(String rolename) {
		return rolesMapper.selectrolefromname(rolename);
	}

}
