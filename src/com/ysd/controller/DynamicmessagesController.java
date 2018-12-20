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
 * ��̬��controller
 * @author ���¾���
 *
 */
@Controller
@RequestMapping(value = "/dongtai", name = "��̬����")
public class DynamicmessagesController {
	
	@Autowired
	DynamicmessagesService Dyservice;
	@Autowired
	AskersService askersservice;
	

	@RequestMapping(value="insertdongtai",name="��Ӷ�̬")
	@ResponseBody
	public Result insertdongtai(Integer id,String name,String context){
		return Dyservice.insertdongtai(id, name, context);
				
	}
	
	
	//�ж��Ƿ�����ѯʦ
	@RequestMapping("shifouzixun")
	@ResponseBody
	public Result shifouzixun(String id){
		List<Askers> list=askersservice.selectaskers();
		for (Askers askers : list) {
			if(askers.getAskerId().equals(id)){
				return new Result(true, "����ѯʦ");
			}
		}
		return new Result(false, "������ѯʦ");
	}
	
	
	
	//�ж��Ƿ�����ѯʦ
		@RequestMapping("selectDynamicmessages")
		@ResponseBody
		public List<Dynamicmessages> selectDynamicmessages(String id){
			return Dyservice.selectDynamicmessages(id);
		}
		
		
	//��ѯ��һ����̬��Ϣ
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
				return new Result(true, "�Ѷ��ɹ�");
			}else{
				return new Result(false, "�Ѷ�ʧ��");
			}
			
		}
	
	
	
	
	

}
