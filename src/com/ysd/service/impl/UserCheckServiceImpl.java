package com.ysd.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.UserCheckMapper;
import com.ysd.entity.Result;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;
import com.ysd.service.UserCheckService;

/**
 * Ա��ǩ����ʵ����
 * 
 * @author ���¾���
 * 
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {
	SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// ��2016-08-10
																				// 20:40
	@Autowired
	private UserCheckMapper usercheckmapper;

	// ��ʾԱ��ǩ�������������
	@Override
	public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck) {
		List<UserChecks> list = usercheckmapper.selectalluserCheck(usercheck);
		return list;
	}

	// ǩ��
	@Override
	public Result qiandao(String username) {
		int r = usercheckmapper.qiandao(username);
		if (r > 0) {
			return new Result(true, "ǩ���ɹ�");

		} else {
			return new Result(false, "ǩ��ʧ��");
		}
	}

	// ǩ��(2)
	@Override
	public Result qiandaoqian(String username, String id) {
		System.out.println(id);
		int r = usercheckmapper.qiandaoqian(username, id);
		if (r > 0) {
			return new Result(true, "ǩ���ɹ�");

		} else {
			return new Result(false, "ǩ��ʧ��");
		}
	}

	// ǩ��
	@Override
	public Result qiantui(String username) {
		int r = usercheckmapper.qiantui(username);
		if (r > 0) {
			return new Result(true, "ǩ�˳ɹ�");

		} else {
			return new Result(false, "ǩ��ʧ��");
		}
	}

	// ǩ��
	@Override
	public Result qiantuiqian(String username) throws ParseException {
		
		UserChecks user = usercheckmapper.selectstate(username);
		
		String fromDate = user.getCheckInTime(); 
		long from = simpleFormat.parse(fromDate).getTime();
		long to = new Date().getTime();
		int minutes = (int) ((to - from) / (1000 * 60));
		
		if (minutes < 10) {
			return new Result(false, "ǩ��ʱ������10����,����ǩ��");
		} else {
			int r = usercheckmapper.qiantuiqian(username);
			if (r > 0) {
				return new Result(true, "ǩ�˳ɹ�");

			} else {
				return new Result(false, "ǩ��ʧ��");
			}
		}
	}

	// Ա��������
	@Override
	public int usercheckcount() {
		return usercheckmapper.usercheckcount();
	}

	// ���ݵ�½�����ֲ�ѯǩ����״̬
	@Override
	public UserChecks selectstate(String LoginName) {
		return usercheckmapper.selectstate(LoginName);
	}

}
