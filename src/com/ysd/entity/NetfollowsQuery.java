package com.ysd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NetfollowsQuery {
	
private String userName;
private String LoginName;
@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
private String beginCreateTime; //用户创建开始时间
@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
private String endCreateTime; //用户开始结束时间
private String huistate;
private String huitype;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getLoginName() {
	return LoginName;
}
public void setLoginName(String loginName) {
	LoginName = loginName;
}

public String getBeginCreateTime() {
	return beginCreateTime;
}
public void setBeginCreateTime(String beginCreateTime) {
	this.beginCreateTime = beginCreateTime;
}
public String getEndCreateTime() {
	return endCreateTime;
}
public void setEndCreateTime(String endCreateTime) {
	this.endCreateTime = endCreateTime;
}
public String getHuistate() {
	return huistate;
}
public void setHuistate(String huistate) {
	this.huistate = huistate;
}
public String getHuitype() {
	return huitype;
}
public void setHuitype(String huitype) {
	this.huitype = huitype;
}
@Override
public String toString() {
	return "NetfollowsQuery [userName=" + userName + ", LoginName=" + LoginName
			 + ", beginCreateTime=" + beginCreateTime
			+ ", endCreateTime=" + endCreateTime + ", huistate=" + huistate
			+ ", huitype=" + huitype + "]";
}


	
	
	
}
