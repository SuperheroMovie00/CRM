package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;

public interface NetfollowsMapper {

	// 查询所有的跟踪信息
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows);

	// 新增一个跟踪 信息
	public int insertnetfollows(NetfollowQuery netfollow);

	// 查询一个学生的跟踪信息
	public List<Netfollows> selectgenzongfromname(@Param("name")String name,@Param("id")Integer id);

}
