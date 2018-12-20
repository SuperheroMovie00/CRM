package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.dao.DynamicmessagesMapper;
import com.ysd.entity.Dynamicmessages;
import com.ysd.entity.Result;
import com.ysd.service.DynamicmessagesService;

public class DynamicmessagesServiceImpl implements DynamicmessagesService {

	@Autowired
	private DynamicmessagesMapper dymapper;

	// 添加学生的动态信息
	@Override
	public Result insertdongtai(Integer id, String name, String context) {
		int r=dymapper.insertdongtai(id, name, context);
		if(r>0){
			return new  Result(true, "添加动态成功");
			
		}else{
			return new  Result(false, "添加动态失败 ");
		}
	}
	
	
	//根据咨询师id查询动态信息
	@Override
	public List<Dynamicmessages> selectDynamicmessages(String id) {
		return dymapper.selectDynamicmessages(id);
	}

	//根据咨询师id查询动态信息(第一条)
	@Override
	public Dynamicmessages selectDynamicmessageslimit(String id) {
	
		return dymapper.selectDynamicmessageslimit(id);
	}


	@Override
	public int state(Integer id) {
		return dymapper.state(id);
	}
	
	
	
	

}
