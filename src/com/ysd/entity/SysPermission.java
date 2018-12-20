package com.ysd.entity;

import java.sql.Timestamp;

/**
 * 
 * @Description:   权限实体类
 * @author         Mashuai 
 * @Date           2018-5-10 下午5:46:22  
 * @Email          1119616605@qq.com
 * 
CREATE TABLE `permissiontb` (
  `permissionId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permissionName` varchar(50) NOT NULL COMMENT '权限名称',
  `permissionValue` varchar(50) DEFAULT NULL COMMENT '权限资源对象',
  `permissionLastUpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '权限最近一次修改时间',
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

 */
public class SysPermission {
	
	private String permissionId;//权限ID
	private String permissionValue;//权限
	private String permissionModule;//权限所属模块
	private String permissionName;//权限备注说明介绍
	private Timestamp permissionLastUpdateTime;//权限修改日期时间
	
	
	
	
	
	
	
	public SysPermission(String permissionValue, String permissionModule,
			String permissionName) {
		super();
		this.permissionValue = permissionValue;
		this.permissionModule = permissionModule;
		this.permissionName = permissionName;
	}
	public SysPermission() {
		super();
	}
	public String  getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String  permissionId) {
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
	public Timestamp getPermissionLastUpdateTime() {
		return permissionLastUpdateTime;
	}
	public void setPermissionLastUpdateTime(Timestamp permissionLastUpdateTime) {
		this.permissionLastUpdateTime = permissionLastUpdateTime;
	}
	@Override
	public String toString() {
		return "SysPermission [permissionId=" + permissionId
				+ ", permissionValue=" + permissionValue
				+ ", permissionModule=" + permissionModule
				+ ", permissionName=" + permissionName
				+ ", permissionLastUpdateTime=" + permissionLastUpdateTime
				+ "]";
	}
	public SysPermission(String permissionId, String permissionValue,
			String permissionModule, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionValue = permissionValue;
		this.permissionModule = permissionModule;
		this.permissionName = permissionName;
	}
	
	
	
	

}
