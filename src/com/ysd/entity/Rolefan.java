package com.ysd.entity;

import java.util.List;
/**
 * 角色分页的实体类
 * @author 爱新觉罗
 *
 */
public class Rolefan {
	private int total;
	private List<Roles> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Roles> getRows() {
		return rows;
	}
	public void setRows(List<Roles> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Rolefan [total=" + total + ", rows=" + rows + "]";
	}
	public Rolefan(int total, List<Roles> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Rolefan() {
		super();
	}
	
	

}
