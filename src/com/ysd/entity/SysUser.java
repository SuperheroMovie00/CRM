package com.ysd.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @Description:   
 * @author         Mashuai 
 * @Date           2018-5-16 下午10:51:33  
 * @Email          1119616605@qq.com
 * 
 * 

CREATE TABLE `usertb` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(20) DEFAULT NULL COMMENT '用户登录名',
  `userPassWord` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `userIsLockout` tinyint(1) DEFAULT '0' COMMENT '用户是否锁定:默认不锁定',
  `userUpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户信息最后一次被修改时间:数据库自己维护记录的修改时间',
  `userCreateTime` datetime DEFAULT NULL COMMENT '用户账号创建时间',
  `userLastLoginTime` datetime NOT NULL COMMENT '用户上一次登录时间',
  `userLastLoginIp` varchar(20) DEFAULT NULL COMMENT '用户上一次登录实际IP地址',
  `userPassWrongCout` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '用户输入密码错误次数',
  `userLockoutTime` datetime DEFAULT NULL COMMENT '用户输入密码错误次数达到上限锁定时间',
  `userEmail` varchar(50) DEFAULT NULL COMMENT '用户密保邮箱',
  `userTelephone` varchar(20) DEFAULT NULL COMMENT '用户密保电话',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

 */
public class SysUser {
	
	private Integer userId;
	private String userName;
	private String userPassWord;
	private Boolean userIsLockout;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区 
	private Date userUpdateTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
	private Date userCreateTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
	private Date userLastLoginTime;
	private String userLastLoginIp;
	private Integer userPassWrongCout = 0;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")	//日期格式化为中国的时区 东8区
	private Date userLockoutTime;
	private String userEmail;
	private String userTelephone;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public Boolean getUserIsLockout() {
		return userIsLockout;
	}
	public void setUserIsLockout(Boolean userIsLockout) {
		this.userIsLockout = userIsLockout;
	}
	public Date getUserUpdateTime() {
		return userUpdateTime;
	}
	public void setUserUpdateTime(Date userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}
	public Date getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public Date getUserLastLoginTime() {
		return userLastLoginTime;
	}
	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}
	public String getUserLastLoginIp() {
		return userLastLoginIp;
	}
	public void setUserLastLoginIp(String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}
	public Integer getUserPassWrongCout() {
		return userPassWrongCout;
	}
	public void setUserPassWrongCout(Integer userPassWrongCout) {
		this.userPassWrongCout = userPassWrongCout;
	}
	public Date getUserLockoutTime() {
		return userLockoutTime;
	}
	public void setUserLockoutTime(Date userLockoutTime) {
		this.userLockoutTime = userLockoutTime;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName
				+ ", userPassWord=" + userPassWord + ", userIsLockout="
				+ userIsLockout + ", userUpdateTime=" + userUpdateTime
				+ ", userCreateTime=" + userCreateTime + ", userLastLoginTime="
				+ userLastLoginTime + ", userLastLoginIp=" + userLastLoginIp
				+ ", userPassWrongCout=" + userPassWrongCout
				+ ", userLockoutTime=" + userLockoutTime + ", userEmail="
				+ userEmail + ", userTelephone=" + userTelephone + "]";
	}
	
	
	
	
	
	
	
	
	

}
