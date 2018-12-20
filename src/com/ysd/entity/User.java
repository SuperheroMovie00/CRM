package com.ysd.entity;

import java.util.Date;

import com.ysd.util.PoiHandler;
/**
 * 用户的实体类
 * @author 爱新觉罗
 *
 */
public class User {
	
	/*`Id` varchar(100) NOT NULL COMMENT '编号',
	  `LoginName` varchar(50) NOT NULL COMMENT '登录名',
	  `Password` varchar(50) NOT NULL COMMENT '密码',
	  `IsLockout` char(2) DEFAULT '否' COMMENT '是否锁定',
	  `LastLoginTime` timestamp NULL DEFAULT NULL COMMENT '最后一次登录时间',
	  `PsdWrongTime` int(11) DEFAULT '0' COMMENT '密码错误次数',
	  `LockTime` timestamp NULL DEFAULT NULL COMMENT '被锁定时间',
	  `ProtectEMail` varchar(200) DEFAULT NULL COMMENT '密保邮箱',
	  `protectMTel` varchar(11) DEFAULT NULL COMMENT '密保手机号',
	  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账户创立时间',*/
	
	@PoiHandler(excelHeader = "编号", excelIgnore = true)
	private String Id;//编号
	@PoiHandler(excelHeader = "登陆名")
	private String LoginName;//登陆名
	@PoiHandler(excelHeader = "密码", excelIgnore = true)
	private String Password;//密码
	@PoiHandler(excelHeader = "是否锁定")
	private String IsLockout;//是否锁定
	@PoiHandler(excelHeader = "最后一次登陆是时间")
	private String LastLoginTime;//最后一次登陆是时间
	@PoiHandler(excelHeader = "密码错误的次数 ")
	private int PsdWrongTime;//密码错误的次数 
	@PoiHandler(excelHeader = "被锁定的时间")
	private String LockTime;//被锁定的时间
	@PoiHandler(excelHeader = "密保邮箱")
	private String ProtectEMail;//密保邮箱
	@PoiHandler(excelHeader = "密保手机号")
	private String protectMTel;//密保手机号
	@PoiHandler(excelHeader = "账户创建时间")
	private String CreateTime;//账户创建时间

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

	public String getIsLockout() {
		return IsLockout;
	}

	public void setIsLockout(String isLockout) {
		IsLockout = isLockout;
	}

	public String getLastLoginTime() {
		return LastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}

	public int getPsdWrongTime() {
		return PsdWrongTime;
	}

	public void setPsdWrongTime(int psdWrongTime) {
		PsdWrongTime = psdWrongTime;
	}

	public String getLockTime() {
		return LockTime;
	}

	public void setLockTime(String lockTime) {
		LockTime = lockTime;
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

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	
	
	

	public User(String id, String loginName, String password,
			String protectEMail, String protectMTel) {
		super();
		Id = id;
		LoginName = loginName;
		Password = password;
		ProtectEMail = protectEMail;
		this.protectMTel = protectMTel;
	}
	
	
	
	


	public User(String loginName, String protectEMail,
			String protectMTel) {
		super();
	
		LoginName = loginName;
		ProtectEMail = protectEMail;
		this.protectMTel = protectMTel;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", LoginName=" + LoginName + ", Password="
				+ Password + ", IsLockout=" + IsLockout + ", LastLoginTime="
				+ LastLoginTime + ", PsdWrongTime=" + PsdWrongTime
				+ ", LockTime=" + LockTime + ", ProtectEMail=" + ProtectEMail
				+ ", protectMTel=" + protectMTel + ", CreateTime=" + CreateTime
				+ "]";
	}

}
