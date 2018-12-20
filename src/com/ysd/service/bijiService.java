package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.biji;

public interface bijiService {

	// �����û���id��ѯ�Ʊʼ�
	public List<biji> selectallbiji(@Param("uid") String uid);

	// ���һ���Ʊʼ�
	public Result insertbiji(@Param("id") String id,
			@Param("context") String context);

	// �޸ıʼ�
	public Result updatebiji(@Param("bid") String bid,
			@Param("context") String context);

	// ɾ���ʼ�
	public Result deletebiji(@Param("bid") String bid);

}
