package com.ysd.entity;

import com.ysd.util.PoiHandler;

/**
 * ��ɫ��ʵ����
 * @author ���¾���
 *
 */
public class Roles {
	@PoiHandler(excelHeader = "��ɫ��id", excelIgnore = true)
	private String Id;//��ɫ��id
	@PoiHandler(excelHeader = "��ɫ������")
	private String Name;//��ɫ������
	@PoiHandler(excelHeader = "Ԥ��int")
	private int Int0;//Ԥ��int
	@PoiHandler(excelHeader = "Ԥ���ַ���")
	private String String0;//Ԥ���ַ���
	
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
