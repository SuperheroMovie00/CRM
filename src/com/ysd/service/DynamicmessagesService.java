package com.ysd.service;

import java.util.List;

import com.ysd.entity.Dynamicmessages;
import com.ysd.entity.Result;

/**
 * ��̬��service
 * 
 * @author ���¾���
 * 
 */
public interface DynamicmessagesService {
	
	// ���ѧ���Ķ�̬��Ϣ
	public Result insertdongtai(Integer id,String name,String context);
	//������ѯʦid��ѯ��̬��Ϣ
	public List<Dynamicmessages> selectDynamicmessages(String id);
	//������ѯʦid��ѯ��̬��Ϣ
	public Dynamicmessages selectDynamicmessageslimit(String id);
	//�޸���Ϣ���Ķ�״̬
		public int state(Integer id);

}
