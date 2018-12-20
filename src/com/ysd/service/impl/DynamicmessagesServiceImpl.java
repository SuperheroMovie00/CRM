package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.dao.DynamicmessagesMapper;
import com.ysd.entity.Dynamicmessages;
import com.ysd.entity.Result;
import com.ysd.service.DynamicmessagesService;

public class DynamicmessagesServiceImpl implements DynamicmessagesService {

	@Autowired
	private DynamicmessagesMapper dymapper;

	// ���ѧ���Ķ�̬��Ϣ
	@Override
	public Result insertdongtai(Integer id, String name, String context) {
		int r=dymapper.insertdongtai(id, name, context);
		if(r>0){
			return new  Result(true, "��Ӷ�̬�ɹ�");
			
		}else{
			return new  Result(false, "��Ӷ�̬ʧ�� ");
		}
	}
	
	
	//������ѯʦid��ѯ��̬��Ϣ
	@Override
	public List<Dynamicmessages> selectDynamicmessages(String id) {
		return dymapper.selectDynamicmessages(id);
	}

	//������ѯʦid��ѯ��̬��Ϣ(��һ��)
	@Override
	public Dynamicmessages selectDynamicmessageslimit(String id) {
	
		return dymapper.selectDynamicmessageslimit(id);
	}


	@Override
	public int state(Integer id) {
		return dymapper.state(id);
	}
	
	
	
	

}
