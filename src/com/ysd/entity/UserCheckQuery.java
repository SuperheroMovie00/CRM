package com.ysd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 员工签到表传输参数实体类
 * @author 爱新觉罗
 *
 */
public class UserCheckQuery {
	 private String userName; //用户姓名
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 private String beginCreateTime; //用户创建开始时间
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 private String endCreateTime; //用户开始结束时间
	 private String order;   //排序字段
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
