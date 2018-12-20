package com.ysd.entity;

import com.ysd.util.PoiHandler;

public class Usermoban {
	@PoiHandler(excelHeader = "用户的id", excelIgnore = true)
	private String Id;
	@PoiHandler(excelHeader = "用户的名字")
	private String LoginName;
	@PoiHandler(excelHeader = "用户的密码", excelIgnore = true)
	private String Password;
	@PoiHandler(excelHeader = "用户的邮箱")
	private String ProtectEMail;
	@PoiHandler(excelHeader = "用户的手机号")
	private String protectMTel;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getProtectEMail() {
		return ProtectEMail;
	}
	public void setProtectEMail(String protectEMail) {
		ProtectEMail = protectEMail;
	}
	public String getProtectMTel() {
		return protectMTel;
	}
	public void setProtectMTel(String protectMTel) {
		this.protectMTel = protectMTel;
	}
	@Override
	public String toString() {
		return "Usermoban [Id=" + Id + ", LoginName=" + LoginName
				+ ", Password=" + Password + ", ProtectEMail=" + ProtectEMail
				+ ", protectMTel=" + protectMTel + "]";
	}

}
