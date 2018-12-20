package com.ysd.entity;

import java.util.Date;
/**
 * 权限实体类
 * @author 爱新觉罗
 *
 */
public class Permission {
	private String permissionId;
	private String permissionValue;
	private String permissionModule;
	private String permissionName;
	private Date permissionLastUpdateTime;
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionValue() {
		return permissionValue;
	}
	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}
	public String getPermissionModule() {
		return permissionModule;
	}
	public void setPermissionModule(String permissionModule) {
		this.permissionModule = permissionModule;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Date getPermissionLastUpdateTime() {
		return permissionLastUpdateTime;
	}
	public void setPermissionLastUpdateTime(Date permissionLastUpdateTime) {
		this.permissionLastUpdateTime = permissionLastUpdateTime;
	}
	public Permission(String permissionId, String permissionValue,
			String permissionModule, String permissionName,
			Date permissionLastUpdateTime) {
		super();
		this.permissionId = permissionId;
		this.permissionValue = permissionValue;
		this.permissionModule = permissionModule;
		this.permissionName = permissionName;
		this.permissionLastUpdateTime = permissionLastUpdateTime;
	}
	@Override
	public String toString() {
		return "permission [permissionId=" + permissionId
				+ ", permissionValue=" + permissionValue
				+ ", permissionModule=" + permissionModule
				+ ", permissionName=" + permissionName
				+ ", permissionLastUpdateTime=" + permissionLastUpdateTime
				+ "]";
	}
	public Permission() {
		super();
	}


}
