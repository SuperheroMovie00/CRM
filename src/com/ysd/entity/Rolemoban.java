package com.ysd.entity;

import com.ysd.util.PoiHandler;

public class Rolemoban {
	
@PoiHandler(excelHeader = "��ɫ��id", excelIgnore = true)
private  String Id;
@PoiHandler(excelHeader = "��ɫ�� ����")
private  String Name;

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
@Override
public String toString() {
	return "Rolemoban [Id=" + Id + ", Name=" + Name + "]";
}




}
