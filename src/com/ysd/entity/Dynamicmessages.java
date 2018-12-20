package com.ysd.entity;

/**
 * ¶¯Ì¬±í
 * @author °®ÐÂ¾õÂÞ
 *
 */
public class Dynamicmessages {
private int Id;
private int StudentId;
private String StudentName;
private String MessageContent;
private String IsOpen;
private String CreateTime;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getStudentId() {
	return StudentId;
}
public void setStudentId(int studentId) {
	StudentId = studentId;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getMessageContent() {
	return MessageContent;
}
public void setMessageContent(String messageContent) {
	MessageContent = messageContent;
}
public String getIsOpen() {
	return IsOpen;
}
public void setIsOpen(String isOpen) {
	IsOpen = isOpen;
}
public String getCreateTime() {
	return CreateTime;
}
public void setCreateTime(String createTime) {
	CreateTime = createTime;
}
@Override
public String toString() {
	return "Dynamicmessages [Id=" + Id + ", StudentId=" + StudentId
			+ ", StudentName=" + StudentName + ", MessageContent="
			+ MessageContent + ", IsOpen=" + IsOpen + ", CreateTime="
			+ CreateTime + "]";
}


}
