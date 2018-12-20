package com.ysd.entity;
/**
 * 
 *员工的签到实体类
 * @author 爱新觉罗
 *
 */
public class UserChecks {
private int Id;
private String UserId;
private String UserName;
private String  CheckInTime;
private String CheckState;
private String IsCancel;
private String CheckOutTime;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getCheckInTime() {
	return CheckInTime;
}
public void setCheckInTime(String checkInTime) {
	CheckInTime = checkInTime;
}
public String getCheckState() {
	return CheckState;
}
public void setCheckState(String checkState) {
	CheckState = checkState;
}
public String getIsCancel() {
	return IsCancel;
}
public void setIsCancel(String isCancel) {
	IsCancel = isCancel;
}
public String getCheckOutTime() {
	return CheckOutTime;
}
public void setCheckOutTime(String checkOutTime) {
	CheckOutTime = checkOutTime;
}
public UserChecks(int id, String userId, String userName, String checkInTime,
		String checkState, String isCancel, String checkOutTime) {
	super();
	Id = id;
	UserId = userId;
	UserName = userName;
	CheckInTime = checkInTime;
	CheckState = checkState;
	IsCancel = isCancel;
	CheckOutTime = checkOutTime;
}
public UserChecks() {
	super();
}
@Override
public String toString() {
	return "UserChecks [Id=" + Id + ", UserId=" + UserId + ", UserName="
			+ UserName + ", CheckInTime=" + CheckInTime + ", CheckState="
			+ CheckState + ", IsCancel=" + IsCancel + ", CheckOutTime="
			+ CheckOutTime + "]";
}	
}
