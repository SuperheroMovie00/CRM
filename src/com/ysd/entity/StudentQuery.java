package com.ysd.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ѧ���Ĳ�ѯ����ʵ����
 * 
 * @author ���¾���
 * 
 */
public class StudentQuery {
	private String userId; //�û���id
	private String studentName;//ѧ��������
	private String phone;//�ֻ�
	private String zixunName;//��ѯʦ����
	private String isPlay;
	private String IsValid;
	private String IsReturnVist;//�ط�״̬
	private String qq;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String beginCreateTime; // �û�������ʼʱ��
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String endCreateTime; // �û���ʼ����ʱ��
	private String createUser; 
	private int page, rows, offset;// �ڼ�ҳ ���� ƫ����

	
	
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
