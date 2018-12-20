package com.ysd.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.bijiMapper;
import com.ysd.entity.Result;
import com.ysd.entity.biji;
import com.ysd.service.bijiService;

@Service
public class bijiServiceimpl implements bijiService {
	private String Id;

	@Autowired
	private bijiMapper bijimapper;

	// �����û���id��ѯ�Ʊʼ�
	@Override
	public List<biji> selectallbiji(String uid) {
		return bijimapper.selectallbiji(uid);
	}

	// ���һ���Ʊʼ�
	@Override
	public Result insertbiji(String id, String context) {
		
		Id = UUID.randomUUID().toString();
		
		int r = bijimapper.insertbiji(Id, id, context);
		if (r > 0) {
			return new Result(true, "��ӳɹ�");

		} else {
			return new Result(false, "���ʧ��");
		}
	}

	
	@Override
	public Result updatebiji(String bid, String context) {
		
		int r = bijimapper.updatebiji(bid, context);
		if (r > 0) {
			return new Result(true, "�޸ĳɹ�");
		} else {
			return new Result(false, "�޸�ʧ��");
		}
	}

	@Override
	public Result deletebiji(String bid) {
		
		int r = bijimapper.deletebiji(bid);
		if (r > 0) {
			return new Result(true, "ɾ���ɹ�");
		} else {
			return new Result(false, "ɾ��ʧ��");
		}
	}

}
