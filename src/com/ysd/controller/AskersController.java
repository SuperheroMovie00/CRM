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
@RequestMapping(value="/Askers",name="��ѯʦ����")
public class AskersController {
	@Autowired
	AskersService askersservice;
	

	//��ѯ���е���ѯʦ
	@RequestMapping(value="/selectaskers",name="��ѯ���е���ѯʦ")
	@ResponseBody
	public List<Askers> selectaskers(){
		List<Askers> list=askersservice.selectaskers();
		return list;
	}
	
	//�޸�һ����ѯʦ
	@RequestMapping(value="/updateaskers",name="�޸�һ����ѯʦ")
	@ResponseBody
	public  Result updateaskers(String name,String weight,String bakContent){
		System.out.println(name);
		System.out.println(weight);
		System.out.println(bakContent);
		return askersservice.updateaskers(name, weight, bakContent);
	}
	
	//��ѯǩ������ѯʦ
	@RequestMapping(value="/selectaskersfromqiandao",name="��ѯǩ������ѯʦ��ѯʦ")
	@ResponseBody
	public List<UserChecks> selectaskersfromqiandao(){
		return askersservice.selectaskersfromqiandao();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
