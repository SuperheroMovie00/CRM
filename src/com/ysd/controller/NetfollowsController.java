package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;
import com.ysd.entity.Result;
import com.ysd.service.NetfollowsService;

@Controller
@RequestMapping(value = "/netfollows", name = "���ٹ���")
public class NetfollowsController {
	@Autowired
	NetfollowsService netService;

	// ��ȡ���еĸ�����Ϣ
	@RequestMapping(value = "selectnetfollows", name = "��ȡ���еĸ�����Ϣ")
	@ResponseBody
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows) {
		return netService.selectnetfollows(follows);
	}

	// �����һ��������Ϣ
	@RequestMapping(value = "insertnetfollows", name = "����һ��������Ϣ")
	@ResponseBody
	public Result insertnetfollows(NetfollowQuery netfollow) {
		return netService.insertnetfollows(netfollow);
	}

	// �������ֲ�ѯһ��ѧ���ĸ�����Ϣ
	@RequestMapping(value = "selectgenzongfromname", name = "��ѯ����ѧ��������Ϣ")
	@ResponseBody
	public List<Netfollows> selectgenzongfromname(String name,Integer id) {
		return netService.selectgenzongfromname(name,id);
	}

}
