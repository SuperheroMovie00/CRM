package com.ysd.entity;
/**
 * ÍøÂç¸ú×ÙÊµÌåÀà
 * @author °®ÐÂ¾õÂÞ
 *
 */
public class Netfollows {
	
	private int Id;
	private int StudentId;
	private String StudentName;
	private String FollowTime;
	private String NextFollowTime;
	private String Content;
	private String LoginName;
	private String FollowType;
	private String CreateTime;
	private String FollowState;
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
	public String getFollowTime() {
		return FollowTime;
	}
	public void setFollowTime(String followTime) {
		FollowTime = followTime;
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
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getFollowType() {
		return FollowType;
	}
	public void setFollowType(String followType) {
		FollowType = followType;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getFollowState() {
		return FollowState;
	}
	public void setFollowState(String followState) {
		FollowState = followState;
	}
	@Override
	public String toString() {
		return "Netfollows [Id=" + Id + ", StudentId=" + StudentId
				+ ", StudentName=" + StudentName + ", FollowTime=" + FollowTime
				+ ", NextFollowTime=" + NextFollowTime + ", Content=" + Content
				+ ", LoginName=" + LoginName + ", FollowType=" + FollowType
				+ ", CreateTime=" + CreateTime + ", FollowState=" + FollowState
				+ "]";
	}
	

}
