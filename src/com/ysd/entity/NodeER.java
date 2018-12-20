package com.ysd.entity;

import java.util.List;
import java.util.Map;

public class NodeER {

	private String id;//�ڵ�ID���Լ���Զ�����ݺ���Ҫ��
	private String text;//��ʾ�ڵ��ı���
	private String context;
	private String permissionid;
	private String state;//�ڵ�״̬��'open' �� 'closed'��Ĭ�ϣ�'open'�����Ϊ'closed'��ʱ�򣬽����Զ�չ���ýڵ�
	private Boolean checked;//��ʾ�ýڵ��Ƿ�ѡ�С�
	private Map<String, Object> attributes;//����ӵ��ڵ���Զ������ԡ�
	private List<NodeER> children;//һ���ڵ��������������ɽڵ㡣
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<NodeER> getChildren() {
		return children;
	}
	public void setChildren(List<NodeER> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NodeER [id=" + id + ", text=" + text + ", context=" + context
				+ ", permissionid=" + permissionid + ", state=" + state
				+ ", checked=" + checked + ", attributes=" + attributes
				+ ", children=" + children + "]";
	}
	
	
	
	
}
