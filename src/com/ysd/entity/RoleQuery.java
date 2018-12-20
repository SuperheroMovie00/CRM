package com.ysd.entity;

public class RoleQuery {
	
	private String rolename;
	 private int page,rows,offset;//第几页 条数  偏移量
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
		return "RoleQuery [rolename=" + rolename + ", page=" + page + ", rows="
				+ rows + ", offset=" + offset + "]";
	}
	 
	 
	 

}
