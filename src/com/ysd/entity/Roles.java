package com.ysd.entity;

import com.ysd.util.PoiHandler;

/**
 * 角色的实体类
 * @author 爱新觉罗
 *
 */
public class Roles {
	@PoiHandler(excelHeader = "角色的id", excelIgnore = true)
	private String Id;//角色的id
	@PoiHandler(excelHeader = "角色的名字")
	private String Name;//角色的名字
	@PoiHandler(excelHeader = "预留int")
	private int Int0;//预留int
	@PoiHandler(excelHeader = "预留字符串")
	private String String0;//预留字符串
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getInt0() {
		return Int0;
	}
	public void setInt0(int int0) {
		Int0 = int0;
	}
	public String getString0() {
		return String0;
	}
	public void setString0(String string0) {
		String0 = string0;
	}
	@Override
	public String toString() {
		return "Roles [Id=" + Id + ", Name=" + Name + ", Int0=" + Int0
				+ ", String0=" + String0 + "]";
	}
	public Roles(String id, String name) {
		super();
		Id = id;
		Name = name;
	}
	public Roles() {
		super();
	}
	
	
	
	
	

}
