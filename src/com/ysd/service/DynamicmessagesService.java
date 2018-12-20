package com.ysd.service;

import java.util.List;

import com.ysd.entity.Dynamicmessages;
import com.ysd.entity.Result;

/**
 * 动态的service
 * 
 * @author 爱新觉罗
 * 
 */
public interface DynamicmessagesService {
	
	// 添加学生的动态信息
	public Result insertdongtai(Integer id,String name,String context);
	//根据咨询师id查询动态信息
	public List<Dynamicmessages> selectDynamicmessages(String id);
	//根据咨询师id查询动态信息
	public Dynamicmessages selectDynamicmessageslimit(String id);
	//修改消息的阅读状态
		public int state(Integer id);

}
