package com.ysd.entity;

import java.util.List;

public class UserCheckfan {
	
	private int total;
	private List<UserChecks> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<UserChecks> getRows() {
		return rows;
	}
	public void setRows(List<UserChecks> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "UserCheckfan [total=" + total + ", rows=" + rows + "]";
	}
	public UserCheckfan() {
		super();
	}
	public UserCheckfan(int total, List<UserChecks> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	

}
