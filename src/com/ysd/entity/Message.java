package com.ysd.entity;

import java.util.List;

/**
 * ����ֵʵ����
 *
 * @author ���¾���
 */
public class Message {
    private List<String> roleNames;
    private List<String> permission;
    private String uid;
    private String name;
    
    
	public List<String> getPermission() {
		return permission;
	}
	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
	public List<String> getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Message(List<String> roleNames, List<String> permission, String uid,
			String name) {
		super();
		this.roleNames = roleNames;
		this.permission = permission;
		this.uid = uid;
		this.name = name;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [roleNames=" + roleNames + ", permission=" + permission
				+ ", uid=" + uid + ", name=" + name + "]";
	}
	
	
  
}
