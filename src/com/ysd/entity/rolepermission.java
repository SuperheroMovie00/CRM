package com.ysd.entity;

import java.util.Date;

public class rolepermission {
	
	private String rolePermissionId;
	private String roleId;
	private String permissionId;
	private Date rolePermissionLastUpdateTime;
	public String getRolePermissionId() {
		return rolePermissionId;
	}
	public void setRolePermissionId(String rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public Date getRolePermissionLastUpdateTime() {
		return rolePermissionLastUpdateTime;
	}
	public void setRolePermissionLastUpdateTime(Date rolePermissionLastUpdateTime) {
		this.rolePermissionLastUpdateTime = rolePermissionLastUpdateTime;
	}
	@Override
	public String toString() {
		return "rolepermission [rolePermissionId=" + rolePermissionId
				+ ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}
	public rolepermission(String rolePermissionId, String roleId,
			String permissionId) {
		super();
		this.rolePermissionId = rolePermissionId;
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
	public rolepermission() {
		super();
	}
	public rolepermission(String roleId, String permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
	
	

}
