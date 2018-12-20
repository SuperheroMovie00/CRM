package com.ysd.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.Roles;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserCheckfan;
import com.ysd.entity.UserChecks;
import com.ysd.service.AskersService;
import com.ysd.service.RolesService;
import com.ysd.service.UserCheckService;

/**
 * Ա��ǩ���Ŀ��Ʋ�
 * 
 * @author ���¾���
 * 
 */
@Controller
@RequestMapping(value = "/usercheck", name = "Ա��ǩ��")
public class UserCheckController {

	@Autowired
	UserCheckService userCheck;
	@Autowired
	RolesService rolesService;
	@Autowired
	AskersService askersservice;

	// ��ѯ�û�ǩ���������е�����(����һ��ģ����ѯ��)
	@RequestMapping(value = "selectalluserCheck", name = "��ѯ���е�Ա��")
	@ResponseBody
	public UserCheckfan selectalluserCheck(UserCheckQuery usercheck) {

		System.out.println(usercheck);

		List<UserChecks> list = userCheck.selectalluserCheck(usercheck);
		int r = userCheck.usercheckcount();
		UserCheckfan userfan = new UserCheckfan(r, list);
		return userfan;
	}

	// ǩ��
	@RequestMapping(value = "qiandao", name = "ǩ��")
	@ResponseBody
	public Result qiandao(String username) {
		return userCheck.qiandao(username);
	}

	// ǩ��(2)
	@RequestMapping(value = "qiandaoqian", name = "ǩ��")
	@ResponseBody
	public Result qiandaoqian(String username, String id) {

		// �ж�ǩ�������Ƿ�����ѯʦ
		List<Askers> list = askersservice.selectaskers();
		//����ѯʦ���е���Ӧ����ѯʦ��ǩ����Ϣ�޸���
		for (Askers askers : list) {
			if(askers.getAskerId().equals(id)){
				askersservice.qiandaozixunshi(id);
			}
		}
		return userCheck.qiandaoqian(username, id);

	}

	// ǩ��
	@RequestMapping(value = "qiantui", name = "ǩ��")
	@ResponseBody
	public Result qiantui(String username) {
		return userCheck.qiantui(username);
	}

	// ǩ��(2)
	@RequestMapping(value = "qiantuiqian", name = "ǩ��")
	@ResponseBody
	public Result qiantuiqian(String username) throws ParseException{
		
		return userCheck.qiantuiqian(username);
	}

	// ���ݵ�½�����ֲ�ѯǩ����״̬
	@RequestMapping(value = "state", name = "״̬")
	@ResponseBody
	public UserChecks state(String LoginName) {
		UserChecks userChecks = userCheck.selectstate(LoginName);
		System.out.println("userChecks=>" + userChecks);
		return userChecks;
	}

}
