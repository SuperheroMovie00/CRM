package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Dynamicmessages;

/**
 * ��̬��mapper
 * 
 * @author ���¾���
 * 
 */
public interface DynamicmessagesMapper {
	
	//���ѧ���Ķ�̬��Ϣ
	public int insertdongtai(@Param("id")Integer id,@Param("name")String name,@Param("context")String context);
	//������ѯʦid��ѯ��̬��Ϣ
	public List<Dynamicmessages> selectDynamicmessages(String id);
	//������ѯʦid��ѯ��̬��Ϣ
	public Dynamicmessages selectDynamicmessageslimit(String id);
	//�޸���Ϣ���Ķ�״̬
	public int state(@Param("id")Integer id);

}
