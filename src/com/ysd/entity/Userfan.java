package com.ysd.entity;

import java.util.List;
/**
 * �û���ҳ��ʵ����
 * @author ���¾���
 *
 */
public class Userfan {
	private int total;
	private List<User> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<User> getRows() {
		return rows;
	}
	public void setRows(List<User> rows) {
		this.rows = rows;
	}
	public Userfan(int total, List<User> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Userfan [total=" + total + ", rows=" + rows + "]";
	}
	public Userfan() {
		super();
	}
	
	
	
	
	
	

}
