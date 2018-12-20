package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.UserChecks;
import com.ysd.service.AskersService;


@Controller
@RequestMapping(value="/Askers",name="咨询师管理")
public class AskersController {
	@Autowired
	AskersService askersservice;
	

	//查询所有的咨询师
	@RequestMapping(value="/selectaskers",name="查询所有的咨询师")
	@ResponseBody
	public List<Askers> selectaskers(){
		List<Askers> list=askersservice.selectaskers();
		return list;
	}
	
	//修改一个咨询师
	@RequestMapping(value="/updateaskers",name="修改一个咨询师")
	@ResponseBody
	public  Result updateaskers(String name,String weight,String bakContent){
		System.out.println(name);
		System.out.println(weight);
		System.out.println(bakContent);
		return askersservice.updateaskers(name, weight, bakContent);
	}
	
	//查询签到的咨询师
	@RequestMapping(value="/selectaskersfromqiandao",name="查询签到的咨询师咨询师")
	@ResponseBody
	public List<UserChecks> selectaskersfromqiandao(){
		return askersservice.selectaskersfromqiandao();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
