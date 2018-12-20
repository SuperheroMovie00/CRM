package com.ysd.entity;

/**
 * 查询参数对象的基类
 * @author MS
 *
 */
public class QueryBase {
	
	/**
	 * 接收EasyUI当前显示第几页
	 */
	protected Integer page = 1;//默认显示第1页
	/**
	 * 接收EesyUI每页显示的条数
	 */
	protected Integer rows = 30;//默认每页显示30条
	/**
	 * MySql分页查询limit的第一个参数,查询起始索引
	 */
	protected Integer startIndex;//默认显示第1-30条数据
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStartIndex() {
		return (page-1) * rows;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
	

}
