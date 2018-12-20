package com.ysd.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @Description:   
 * @author         高中燁
 * @Date           2018-5-16 下午10:50:07  
 * @Email
 * 树控件数据格式化
每个节点都具备以下属性：

id：节点ID，对加载远程数据很重要。
text：显示节点文本。
state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
checked：表示该节点是否被选中。
attributes: 被添加到节点的自定义属性。
children: 一个节点数组声明了若干节点。
 */

@JsonInclude(Include.NON_NULL)	//如果该属性为NULL则不参与序列化
public class Node {
	
	
	private String id;//节点ID，对加载远程数据很重要。
	private String text;//显示节点文本。
	private String state;//节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点
	private Boolean checked;//表示该节点是否被选中。
	private Map<String, Object> attributes;//被添加到节点的自定义属性。
	private List<Node> children;//一个节点数组声明了若干节点。
	
	
	
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
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", text=" + text + ", state=" + state
				+ ", checked=" + checked + ", attributes=" + attributes
				+ ", children=" + children + "]";
	}
	
	
	
	
	

}
