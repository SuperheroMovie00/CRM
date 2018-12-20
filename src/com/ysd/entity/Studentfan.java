package com.ysd.entity;

import java.util.List;

public class Studentfan {

	private int total;
	private List<Students> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Students> getRows() {
		return rows;
	}
	public void setRows(List<Students> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Studentfan [total=" + total + ", rows=" + rows + "]";
	}
	public Studentfan(int total, List<Students> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Studentfan() {
		super();
	}
	
	
	
	
}
