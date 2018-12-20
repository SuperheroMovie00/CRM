package com.ysd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Ա��ǩ���������ʵ����
 * @author ���¾���
 *
 */
public class UserCheckQuery {
	 private String userName; //�û�����
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 private String beginCreateTime; //�û�������ʼʱ��
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 private String endCreateTime; //�û���ʼ����ʱ��
	 private String order;   //�����ֶ�
	 private int page,rows,offset;//�ڼ�ҳ ����  ƫ����
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
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
		return (page-1)*rows;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@Override
	public String toString() {
		return "UserCheckQuery [userName=" + userName + ", beginCreateTime="
				+ beginCreateTime + ", endCreateTime=" + endCreateTime
				+ ", order=" + order + ", page=" + page + ", rows=" + rows
				+ ", offset=" + offset + "]";
	}
	 
	 
	 
	 
	 
	 
	 
	 

}
