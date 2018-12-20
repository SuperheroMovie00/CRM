package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.AskersMapper;
import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.UserChecks;
import com.ysd.service.AskersService;
@Service
public class AskersServiceImpl implements AskersService {

	
	@Autowired
	private AskersMapper askermapper;
	
	// ��ȡ���е���ѯʦ
	@Override
	public List<Askers> selectaskers() {
		List<Askers> list=askermapper.selectaskers();
		return list;
	}
	//�޸�һ����ѯʦ
	@Override
	public Result updateaskers(String name,String weight, String bakContent) {
		System.out.println(name);
		System.out.println(weight);
		System.out.println(bakContent);
		int r=askermapper.updateaskers(name,weight, bakContent);
		if(r>0){
			
			return new Result(true, "�޸ĳɹ�");
		}else{
			return new Result(false, "�޸�ʧ��");
		}
	
	}
	
	//����ǩ�������鿴��ѯʦ����
	@Override
	public List<UserChecks> selectaskersfromqiandao() {
		return askermapper.selectaskersfromqiandao();
	}
	
	
	
	//ǩ����ǰǩ������ѯʦ
	@Override
	public int qiandaozixunshi(String id) {
		return askermapper.qiandaozixunshi(id);
	}
	
	
	//��ѯ��ѯʦ(Ȩ������,���ѧ����,ǩ��ʱ�䵱��,��ǩ��,ȡ��һ��)
	@Override
	public Askers zidongfenpeizixunshi() {
		return askermapper.zidongfenpeizixunshi();
	}
	
	
	// ���һ��ѧ��֮�����ѧ��״̬��Ϊ��
	@Override
	public int updatestate(String askId) {
		return askermapper.updatestate(askId);
	}
	
	
	// ������е���ѯʦ״̬��������ȫ���ĳɷ�
	@Override
	public int updatestatefou() {
		return askermapper.updatestatefou();
	}
	
	//����һ����ѯʦ
	@Override
	public int insertasker(String id,String askname) {
		return askermapper.insertasker(id,askname);
	}
	
	
	@Override
	public int insertaskerer(String id,String askname) {
		return askermapper.insertaskerer(id,askname);
	}
	@Override
	public int deleteasker(String id) {
		
		return askermapper.deleteasker(id);
	}
	@Override
	public List<Askers> zidongfenpeizixunshi2() {
		return askermapper.zidongfenpeizixunshi2();
	}
	
	

}
