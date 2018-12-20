package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Askers;
import com.ysd.entity.Dynamicmessages;
import com.ysd.entity.Result;
import com.ysd.service.AskersService;
import com.ysd.service.DynamicmessagesService;

/**
 * 动态的controller
 * @author 爱新觉罗
 *
 */
@Controller
@RequestMapping(value = "/dongtai", name = "动态管理")
public class DynamicmessagesController {
	
	@Autowired
	DynamicmessagesService Dyservice;
	@Autowired
	AskersService askersservice;
	

	@RequestMapping(value="insertdongtai",name="添加动态")
	@ResponseBody
	public Result insertdongtai(Integer id,String name,String context){
		return Dyservice.insertdongtai(id, name, context);
				
	}
	
	
	//判断是否是咨询师
	@RequestMapping("shifouzixun")
	@ResponseBody
	public Result shifouzixun(String id){
		List<Askers> list=askersservice.selectaskers();
		for (Askers askers : list) {
			if(askers.getAskerId().equals(id)){
				return new Result(true, "是咨询师");
			}
		}
		return new Result(false, "不是咨询师");
	}
	
	
	
	//判断是否是咨询师
		@RequestMapping("selectDynamicmessages")
		@ResponseBody
		public List<Dynamicmessages> selectDynamicmessages(String id){
			return Dyservice.selectDynamicmessages(id);
		}
		
		
	//查询第一条动态信息
		@RequestMapping("selectDynamicmessageslimit")
		@ResponseBody
		public Dynamicmessages selectDynamicmessageslimit(String id){
			return Dyservice.selectDynamicmessageslimit(id);
		}
		
	
		@RequestMapping("state")
		@ResponseBody
		public Result state(Integer id){
			int r =Dyservice.state(id);
			if(r>0){
				return new Result(true, "已读成功");
			}else{
				return new Result(false, "已读失败");
			}
			
		}
	
	
	
	
	

}
