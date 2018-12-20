package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.UserChecks;

/**
 * AskersService service�ӿ�
 * 
 * @author ���¾���
 * 
 */
public interface AskersService {
	// ��ȡ���е���ѯʦ
	public List<Askers> selectaskers();

	// �޸�һ����ѯʦ
	public Result updateaskers(String name, String weight, String bakContent);

	// ����ǩ�������鿴��ѯʦ����
	public List<UserChecks> selectaskersfromqiandao();

	// ǩ����ǰǩ������ѯʦ
	public int qiandaozixunshi(String id);

	// ��ѯ��ѯʦ(Ȩ������,���ѧ����,ǩ��ʱ�䵱��,��ǩ��,ȡ��һ��)
	public Askers zidongfenpeizixunshi();
	
	
	public List<Askers> zidongfenpeizixunshi2();

	// ���һ��ѧ��֮�����ѧ��״̬��Ϊ��
	public int updatestate(String askId);

	// ������е���ѯʦ״̬��������ȫ���ĳɷ�
	public int updatestatefou();

	// ����һ����ѯʦ
	public int insertasker(String id, String askname);

	// ����һ����ѯʦ
	public int insertaskerer(String id, String askname);

	// �Ƴ�һ����ѯʦ
	public int deleteasker(@Param("id") String id);
}
