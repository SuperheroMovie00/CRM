package com.ysd.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 学生的查询条件实体类
 * 
 * @author 爱新觉罗
 * 
 */
public class StudentQuery {
	private String userId; //用户的id
	private String studentName;//学生的名字
	private String phone;//手机
	private String zixunName;//咨询师名字
	private String isPlay;
	private String IsValid;
	private String IsReturnVist;//回访状态
	private String qq;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String beginCreateTime; // 用户创建开始时间
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String endCreateTime; // 用户开始结束时间
	private String createUser; 
	private int page, rows, offset;// 第几页 条数 偏移量

	
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZixunName() {
		return zixunName;
	}

	public void setZixunName(String zixunName) {
		this.zixunName = zixunName;
	}

	public String getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}

	public String getIsValid() {
		return IsValid;
	}

	public void setIsValid(String isValid) {
		IsValid = isValid;
	}

	public String getIsReturnVist() {
		return IsReturnVist;
	}

	public void setIsReturnVist(String isReturnVist) {
		IsReturnVist = isReturnVist;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getOffset() {
		return (page - 1) * rows;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "StudentQuery [userId=" + userId + ", studentName="
				+ studentName + ", phone=" + phone + ", zixunName=" + zixunName
				+ ", isPlay=" + isPlay + ", IsValid=" + IsValid
				+ ", IsReturnVist=" + IsReturnVist + ", qq=" + qq
				+ ", beginCreateTime=" + beginCreateTime + ", endCreateTime="
				+ endCreateTime + ", createUser=" + createUser + ", page="
				+ page + ", rows=" + rows + ", offset=" + offset + "]";
	}

	
}
