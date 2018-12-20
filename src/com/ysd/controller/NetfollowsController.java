package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;
import com.ysd.entity.Result;
import com.ysd.service.NetfollowsService;

@Controller
@RequestMapping(value = "/netfollows", name = "跟踪管理")
public class NetfollowsController {
	@Autowired
	NetfollowsService netService;

	// 获取所有的跟踪信息
	@RequestMapping(value = "selectnetfollows", name = "获取所有的跟踪信息")
	@ResponseBody
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows) {
		return netService.selectnetfollows(follows);
	}

	// 新添加一个跟踪信息
	@RequestMapping(value = "insertnetfollows", name = "新增一个跟踪信息")
	@ResponseBody
	public Result insertnetfollows(NetfollowQuery netfollow) {
		return netService.insertnetfollows(netfollow);
	}

	// 根据名字查询一个学生的跟踪信息
	@RequestMapping(value = "selectgenzongfromname", name = "查询单个学生跟踪信息")
	@ResponseBody
	public List<Netfollows> selectgenzongfromname(String name,Integer id) {
		return netService.selectgenzongfromname(name,id);
	}

}
