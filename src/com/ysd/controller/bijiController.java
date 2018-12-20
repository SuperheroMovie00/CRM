package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Result;
import com.ysd.entity.biji;
import com.ysd.service.bijiService;

@Controller
@RequestMapping(value="/biji",name="笔记管理")
public class bijiController {
	
	@Autowired
	bijiService bijiservice;
	
	@RequestMapping(value="/selectallbiji",name="查询所有的笔记")
	@ResponseBody
	public List<biji> selectallbiji(String uid){
		return bijiservice.selectallbiji(uid);
	}
	
	@RequestMapping(value="/insertbiji",name="新建笔记")
	@ResponseBody
	public Result insertbiji(String uid,String context){
		return bijiservice.insertbiji(uid, context);
	}
	
	@RequestMapping(value="/updatebiji",name="修改笔记")
	@ResponseBody
	public Result updatebiji(String bid,String context){
		return bijiservice.updatebiji(bid, context);
	}
	
	@RequestMapping(value="/deletebiji",name="删除笔记")
	@ResponseBody
	public Result deletebiji(String bid){
		return bijiservice.deletebiji(bid);
	}
	
	

}
