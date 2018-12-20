package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.NetfollowQuery;
import com.ysd.entity.Netfollows;
import com.ysd.entity.NetfollowsQuery;

public interface NetfollowsMapper {

	// ��ѯ���еĸ�����Ϣ
	public List<Netfollows> selectnetfollows(NetfollowsQuery follows);

	// ����һ������ ��Ϣ
	public int insertnetfollows(NetfollowQuery netfollow);

	// ��ѯһ��ѧ���ĸ�����Ϣ
	public List<Netfollows> selectgenzongfromname(@Param("name")String name,@Param("id")Integer id);

}
