package com.ysd.entity;
/**
 * 网络跟踪传入参数实体类
 * @author 爱新觉罗
 *
 */
public class NetfollowQuery {
	
	private int Studentid;
	private String Studentname;
	private String FollowTime;
	
	private String FollowState;
	private String Userid;
	private String FollowType;
	
	private String NextFollowTime;
	private String Content;
	
	
	public int getStudentid() {
		return Studentid;
	}
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public String getFollowTime() {
		return FollowTime;
	}
	public void setFollowTime(String followTime) {
		FollowTime = followTime;
	}
	public String getFollowState() {
		return FollowState;
	}
	public void setFollowState(String followState) {
		FollowState = followState;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getFollowType() {
		return FollowType;
	}
	public void setFollowType(String followType) {
		FollowType = followType;
	}
	public String getNextFollowTime() {
		return NextFollowTime;
	}
	public void setNextFollowTime(String nextFollowTime) {
		NextFollowTime = nextFollowTime;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Override
	public String toString() {
		return "NetfollowQuery [Studentid=" + Studentid + ", Studentname="
				+ Studentname + ", FollowTime=" + FollowTime + ", FollowState="
				+ FollowState + ", Userid=" + Userid + ", FollowType="
				+ FollowType + ", NextFollowTime=" + NextFollowTime
				+ ", Content=" + Content + "]";
	}
}
