package com.ysd.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ��ԃ�Ñ���ʵ����
 * @author ���¾���
 *
 */
public class UsersQuery {
	
	    private String userName; //�û�����
	    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	    private String beginCreateTime; //�û�������ʼʱ��
	    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	    private String endCreateTime; //�û���ʼ����ʱ��
	    private String isLockout;  //�û��Ƿ�����
	    private String order;   //�����ֶ�
	    private String protectEMail;//�û�����
	    private String protectMTel; //�û��ֻ���
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
		public String getIsLockout() {
			return isLockout;
		}
		public void setIsLockout(String isLockout) {
			this.isLockout = isLockout;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
		public String getProtectEMail() {
			return protectEMail;
		}
		public void setProtectEMail(String protectEMail) {
			this.protectEMail = protectEMail;
		}
		public String getProtectMTel() {
			return protectMTel;
		}
		public void setProtectMTel(String protectMTel) {
			this.protectMTel = protectMTel;
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
		public UsersQuery(String userName, String beginCreateTime,
				String endCreateTime, String isLockout, String order,
				String protectEMail, String protectMTel, int page, int rows,
				int offsex) {
			super();
			this.userName = userName;
			this.beginCreateTime = beginCreateTime;
			this.endCreateTime = endCreateTime;
			this.isLockout = isLockout;
			this.order = order;
			this.protectEMail = protectEMail;
			this.protectMTel = protectMTel;
			this.page = page;
			this.rows = rows;
			this.offset = offset;
		}
		public UsersQuery() {
			super();
		}
		@Override
		public String toString() {
			return "UsersQuery [userName=" + userName + ", beginCreateTime="
					+ beginCreateTime + ", endCreateTime=" + endCreateTime
					+ ", isLockout=" + isLockout + ", order=" + order
					+ ", protectEMail=" + protectEMail + ", protectMTel="
					+ protectMTel + ", page=" + page + ", rows=" + rows
					+ ", offsex=" + offset + "]";
		}
	    
	    
	    

	
	
	

}
