package com.ysd.entity;
/**
 * 返回值实体类
 * @author 爱新觉罗
 *
 */


public class Result {


	public boolean success;
	public Object message;
	public String remark;
	public String cuowu;
	public static boolean kaiguan=false;
	

	public String getCuowu() {
		return cuowu;
	}


	public void setCuowu(String cuowu) {
		this.cuowu = cuowu;
	}


	public boolean isSuccess() {
		return success;
	}
	
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Result(boolean success, Object message, String remark) {
		super();
		this.success = success;
		this.message = message;
		this.remark = remark;
	}
	
	public Result() {
		super();
	}


	public Result(boolean success, Object message) {
		super();
		this.success = success;
		this.message = message;
	}


	public Result(boolean success, String remark) {
		super();
		this.success = success;
		this.remark = remark;
	}


	public Result(boolean success, Object message, String remark, String cuowu) {
		super();
		this.success = success;
		this.message = message;
		this.remark = remark;
		this.cuowu = cuowu;
	}


	public Result(String cuowu) {
		super();
		this.cuowu = cuowu;
	}
	
	
	
	
	
	

}
