package com.ysd.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 模块实体类
 * @author 爱新觉罗
 *
 */
public class Modules {
	@JsonProperty("id")
	private int Id;
	@JsonProperty("text")
	private String Name;
	private int ParentId;
	private String Path;
	private int Weight;
	private String Ops;
	private int Int0;
	private List<Modules> children;
	private boolean checked;
	

	public List<Modules> getChildren() {
		return children;
	}
	public void setChildren(List<Modules> children) {
		this.children = children;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	

	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public String getOps() {
		return Ops;
	}
	public void setOps(String ops) {
		Ops = ops;
	}
	public int getInt0() {
		return Int0;
	}
	public void setInt0(int int0) {
		Int0 = int0;
	}
	
	
	
	public Modules() {
		super();
	}
	public Modules(int id, String name, String path, int weight) {
		super();
		Id = id;
		Name = name;
		Path = path;
		Weight = weight;
	}
	public Modules(int id, String name, int parentId, String path, int weight,
			String ops, int int0, List<Modules> children, boolean checked) {
		super();
		Id = id;
		Name = name;
		ParentId = parentId;
		Path = path;
		Weight = weight;
		Ops = ops;
		Int0 = int0;
		this.children = children;
		this.checked = checked;
	}
	public Modules(String name, int parentId, String path, int weight) {
		super();
		Name = name;
		ParentId = parentId;
		Path = path;
		Weight = weight;
	}
	public Modules(int id, String name, int parentId, String path, int weight) {
		super();
		Id = id;
		Name = name;
		ParentId = parentId;
		Path = path;
		Weight = weight;
	}
	
	
	
	
	
	
	
}
