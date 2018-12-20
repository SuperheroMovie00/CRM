package com.ysd.service;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;

/**
 * Ա��ǩ���Ľӿ�
 * 
 * @author ���¾���
 * 
 */
public interface UserCheckService {

	// ��ʾԱ��ǩ�����ȫ������
	public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck);

	// ǩ��
	public Result qiandao(String username);

	// ǩ��(2)
	public Result qiandaoqian(String username, String id);

	// ǩ��
	public Result qiantui(String username);
	
	// ǩ��
	public Result qiantuiqian(String username) throws ParseException;

	// Ա��������
	public int usercheckcount();

	// ���ݵ�½�����ֲ�ѯǩ����״̬
	public UserChecks selectstate(String LoginName);

}
