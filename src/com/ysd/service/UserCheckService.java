package com.ysd.service;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;

/**
 * 员工签到的接口
 * 
 * @author 爱新觉罗
 * 
 */
public interface UserCheckService {

	// 显示员工签到表的全部数据
	public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck);

	// 签到
	public Result qiandao(String username);

	// 签到(2)
	public Result qiandaoqian(String username, String id);

	// 签退
	public Result qiantui(String username);
	
	// 签退
	public Result qiantuiqian(String username) throws ParseException;

	// 员工总条数
	public int usercheckcount();

	// 根据登陆的名字查询签到的状态
	public UserChecks selectstate(String LoginName);

}
