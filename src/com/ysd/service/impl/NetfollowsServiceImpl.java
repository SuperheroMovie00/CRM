package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.NetfollowsMapper;
import com.ysd.dao.PermissionMapper;
import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;
import com.ysd.entity.Result;
import com.ysd.service.NetfollowsService;

@Service
public class NetfollowsServiceImpl implements NetfollowsService {

	@Autowired
	private NetfollowsMapper netmapper;

	// 查询所有的跟踪信息
	@Override
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows) {
		return netmapper.selectnetfollows(follows);
	}

	// 新增一个跟踪信息
	@Override
	public Result insertnetfollows(NetfollowQuery netfollow) {
		int r = netmapper.insertnetfollows(netfollow);
		if (r > 0) {
			return new Result(true, "跟踪成功");
		} else {

			return new Result(false, "跟踪失败");
		}
	}

	// 查询一个学生的跟踪信息
	@Override
	public List<Netfollows> selectgenzongfromname(String name,Integer id) {
		return netmapper.selectgenzongfromname(name,id);
	}

}
