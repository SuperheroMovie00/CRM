package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Dynamicmessages;

/**
 * 动态的mapper
 * 
 * @author 爱新觉罗
 * 
 */
public interface DynamicmessagesMapper {
	
	//添加学生的动态信息
	public int insertdongtai(@Param("id")Integer id,@Param("name")String name,@Param("context")String context);
	//根据咨询师id查询动态信息
	public List<Dynamicmessages> selectDynamicmessages(String id);
	//根据咨询师id查询动态信息
	public Dynamicmessages selectDynamicmessageslimit(String id);
	//修改消息的阅读状态
	public int state(@Param("id")Integer id);

}
