package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.biji;

/**
 * �ʼ�dao�ӿ�
 * @author ���¾���
 *
 */
public interface bijiMapper {
	
	//�����û���id��ѯ�Ʊʼ�
	public List<biji>  selectallbiji(@Param("uid")String uid);
	//���һ���Ʊʼ�
	public int insertbiji(@Param("bid")String bid,@Param("id")String id,@Param("context")String context);
    //�޸ıʼ�
	public int updatebiji(@Param("bid")String bid,@Param("context")String context);
	//ɾ���ʼ�
	public int deletebiji(@Param("bid")String bid);
}
