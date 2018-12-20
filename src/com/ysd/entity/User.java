package com.ysd.entity;

import java.util.Date;

import com.ysd.util.PoiHandler;
/**
 * �û���ʵ����
 * @author ���¾���
 *
 */
public class User {
	
	/*`Id` varchar(100) NOT NULL COMMENT '���',
	  `LoginName` varchar(50) NOT NULL COMMENT '��¼��',
	  `Password` varchar(50) NOT NULL COMMENT '����',
	  `IsLockout` char(2) DEFAULT '��' COMMENT '�Ƿ�����',
	  `LastLoginTime` timestamp NULL DEFAULT NULL COMMENT '���һ�ε�¼ʱ��',
	  `PsdWrongTime` int(11) DEFAULT '0' COMMENT '����������',
	  `LockTime` timestamp NULL DEFAULT NULL COMMENT '������ʱ��',
	  `ProtectEMail` varchar(200) DEFAULT NULL COMMENT '�ܱ�����',
	  `protectMTel` varchar(11) DEFAULT NULL COMMENT '�ܱ��ֻ���',
	  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�˻�����ʱ��',*/
	
	@PoiHandler(excelHeader = "���", excelIgnore = true)
	private String Id;//���
	@PoiHandler(excelHeader = "��½��")
	private String LoginName;//��½��
	@PoiHandler(excelHeader = "����", excelIgnore = true)
	private String Password;//����
	@PoiHandler(excelHeader = "�Ƿ�����")
	private String IsLockout;//�Ƿ�����
	@PoiHandler(excelHeader = "���һ�ε�½��ʱ��")
	private String LastLoginTime;//���һ�ε�½��ʱ��
	@PoiHandler(excelHeader = "�������Ĵ��� ")
	private int PsdWrongTime;//�������Ĵ��� 
	@PoiHandler(excelHeader = "��������ʱ��")
	private String LockTime;//��������ʱ��
	@PoiHandler(excelHeader = "�ܱ�����")
	private String ProtectEMail;//�ܱ�����
	@PoiHandler(excelHeader = "�ܱ��ֻ���")
	private String protectMTel;//�ܱ��ֻ���
	@PoiHandler(excelHeader = "�˻�����ʱ��")
	private String CreateTime;//�˻�����ʱ��

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
