package com.ysd.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.Roles;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserCheckfan;
import com.ysd.entity.UserChecks;
import com.ysd.service.AskersService;
import com.ysd.service.RolesService;
import com.ysd.service.UserCheckService;

/**
 * 员工签到的控制层
 * 
 * @author 爱新觉罗
 * 
 */
@Controller
@RequestMapping(value = "/usercheck", name = "员工签到")
public class UserCheckController {

	@Autowired
	UserCheckService userCheck;
	@Autowired
	RolesService rolesService;
	@Autowired
	AskersService askersservice;

	// 查询用户签到表中所有的数据(传入一个模糊查询的)
	@RequestMapping(value = "selectalluserCheck", name = "查询所有的员工")
	@ResponseBody
	public UserCheckfan selectalluserCheck(UserCheckQuery usercheck) {

		System.out.println(usercheck);

		List<UserChecks> list = userCheck.selectalluserCheck(usercheck);
		int r = userCheck.usercheckcount();
		UserCheckfan userfan = new UserCheckfan(r, list);
		return userfan;
	}

	// 签到
	@RequestMapping(value = "qiandao", name = "签到")
	@ResponseBody
	public Result qiandao(String username) {
		return userCheck.qiandao(username);
	}

	// 签到(2)
	@RequestMapping(value = "qiandaoqian", name = "签到")
	@ResponseBody
	public Result qiandaoqian(String username, String id) {

		// 判断签到的人是否是咨询师
		List<Askers> list = askersservice.selectaskers();
		//将咨询师表中的相应的咨询师的签到信息修改下
		for (Askers askers : list) {
			if(askers.getAskerId().equals(id)){
				askersservice.qiandaozixunshi(id);
			}
		}
		return userCheck.qiandaoqian(username, id);

	}

	// 签退
	@RequestMapping(value = "qiantui", name = "签退")
	@ResponseBody
	public Result qiantui(String username) {
		return userCheck.qiantui(username);
	}

	// 签退(2)
	@RequestMapping(value = "qiantuiqian", name = "签退")
	@ResponseBody
	public Result qiantuiqian(String username) throws ParseException{
		
		return userCheck.qiantuiqian(username);
	}

	// 根据登陆的名字查询签到的状态
	@RequestMapping(value = "state", name = "状态")
	@ResponseBody
	public UserChecks state(String LoginName) {
		UserChecks userChecks = userCheck.selectstate(LoginName);
		System.out.println("userChecks=>" + userChecks);
		return userChecks;
	}

}
