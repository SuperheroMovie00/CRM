package com.ysd.entity;

/**
 * 笔记的实体类
 * 
 * @author 爱新觉罗
 * 
 */
public class biji {

	private String bId;
	private String UserId;
	private String context;
	private String createtime;
	private String xiugaitime;

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getXiugaitime() {
		return xiugaitime;
	}

	public void setXiugaitime(String xiugaitime) {
		this.xiugaitime = xiugaitime;
	}

	@Override
	public String toString() {
		return "biji [bId=" + bId + ", UserId=" + UserId + ", context="
				+ context + ", createtime=" + createtime + ", xiugaitime="
				+ xiugaitime + "]";
	}

}
