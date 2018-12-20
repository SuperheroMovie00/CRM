package com.ysd.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 查詢用戶的实体类
 * @author 爱新觉罗
 *
 */
public class UsersQuery {
	
	    private String userName; //用户姓名
	    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	    private String beginCreateTime; //用户创建开始时间
	    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	    private String endCreateTime; //用户开始结束时间
	    private String isLockout;  //用户是否锁定
	    private String order;   //排序字段
	    private String protectEMail;//用户邮箱
	    private String protectMTel; //用户手机号
	    private int page,rows,offset;//第几页 条数  偏移量
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
