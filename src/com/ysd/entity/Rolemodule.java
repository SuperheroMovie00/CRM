package com.ysd.entity;
/**
 *用户模块实体类
 * @author 爱新觉罗
 *
 */




public class Rolemodule {
	
	private String Id;
	private String RoleId;
	private int ModuleId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public int getModuleId() {
		return ModuleId;
	}
	public void setModuleId(int moduleId) {
		ModuleId = moduleId;
	}
	public Rolemodule(String id, String roleId, int moduleId) {
		super();
		Id = id;
		RoleId = roleId;
		ModuleId = moduleId;
	}
	
	
	public Rolemodule(String roleId, int moduleId) {
		super();
		RoleId = roleId;
		ModuleId = moduleId;
	}
	public Rolemodule() {
		super();
	}
	@Override
	public String toString() {
		return "rolemodule [Id=" + Id + ", RoleId=" + RoleId + ", ModuleId="
				+ ModuleId + "]";
	}
	
	
	

}
