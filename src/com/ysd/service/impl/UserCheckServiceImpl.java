package com.ysd.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.UserCheckMapper;
import com.ysd.entity.Result;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;
import com.ysd.service.UserCheckService;

/**
 * 员工签到的实现类
 * 
 * @author 爱新觉罗
 * 
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {
	SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// 如2016-08-10
																				// 20:40
	@Autowired
	private UserCheckMapper usercheckmapper;

	// 显示员工签到表的所有数据
	@Override
	public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck) {
		List<UserChecks> list = usercheckmapper.selectalluserCheck(usercheck);
		return list;
	}

	// 签到
	@Override
	public Result qiandao(String username) {
		int r = usercheckmapper.qiandao(username);
		if (r > 0) {
			return new Result(true, "签到成功");

		} else {
			return new Result(false, "签到失败");
		}
	}

	// 签到(2)
	@Override
	public Result qiandaoqian(String username, String id) {
		System.out.println(id);
		int r = usercheckmapper.qiandaoqian(username, id);
		if (r > 0) {
			return new Result(true, "签到成功");

		} else {
			return new Result(false, "签到失败");
		}
	}

	// 签退
	@Override
	public Result qiantui(String username) {
		int r = usercheckmapper.qiantui(username);
		if (r > 0) {
			return new Result(true, "签退成功");

		} else {
			return new Result(false, "签退失败");
		}
	}

	// 签退
	@Override
	public Result qiantuiqian(String username) throws ParseException {
		
		UserChecks user = usercheckmapper.selectstate(username);
		
		String fromDate = user.getCheckInTime(); 
		long from = simpleFormat.parse(fromDate).getTime();
		long to = new Date().getTime();
		int minutes = (int) ((to - from) / (1000 * 60));
		
		if (minutes < 10) {
			return new Result(false, "签到时间少于10分钟,不能签退");
		} else {
			int r = usercheckmapper.qiantuiqian(username);
			if (r > 0) {
				return new Result(true, "签退成功");

			} else {
				return new Result(false, "签退失败");
			}
		}
	}

	// 员工总条数
	@Override
	public int usercheckcount() {
		return usercheckmapper.usercheckcount();
	}

	// 根据登陆的名字查询签到的状态
	@Override
	public UserChecks selectstate(String LoginName) {
		return usercheckmapper.selectstate(LoginName);
	}

}
