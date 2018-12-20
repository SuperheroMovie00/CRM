package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.biji;

public interface bijiService {

	// 根据用户的id查询云笔记
	public List<biji> selectallbiji(@Param("uid") String uid);

	// 添加一条云笔记
	public Result insertbiji(@Param("id") String id,
			@Param("context") String context);

	// 修改笔记
	public Result updatebiji(@Param("bid") String bid,
			@Param("context") String context);

	// 删除笔记
	public Result deletebiji(@Param("bid") String bid);

}
