package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.biji;

/**
 * 笔记dao接口
 * @author 爱新觉罗
 *
 */
public interface bijiMapper {
	
	//根据用户的id查询云笔记
	public List<biji>  selectallbiji(@Param("uid")String uid);
	//添加一条云笔记
	public int insertbiji(@Param("bid")String bid,@Param("id")String id,@Param("context")String context);
    //修改笔记
	public int updatebiji(@Param("bid")String bid,@Param("context")String context);
	//删除笔记
	public int deletebiji(@Param("bid")String bid);
}
