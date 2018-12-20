package com.ysd.service;

import java.util.List;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;
import com.ysd.entity.Result;

public interface NetfollowsService {

	// 查询所有的跟踪信息
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows);

	// 新增一个跟踪信息
	public Result insertnetfollows(NetfollowQuery netfollow);

	// 查询一个学生的跟踪信息
	public List<Netfollows> selectgenzongfromname(String name,Integer id);

}
