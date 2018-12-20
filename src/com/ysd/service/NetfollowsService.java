package com.ysd.service;

import java.util.List;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;
import com.ysd.entity.Result;

public interface NetfollowsService {

	// ��ѯ���еĸ�����Ϣ
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows);

	// ����һ��������Ϣ
	public Result insertnetfollows(NetfollowQuery netfollow);

	// ��ѯһ��ѧ���ĸ�����Ϣ
	public List<Netfollows> selectgenzongfromname(String name,Integer id);

}
