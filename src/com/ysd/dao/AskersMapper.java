package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Askers;
import com.ysd.entity.UserChecks;

/**
 * askers��dao�ӿ�
 * @author ���¾���
 *
 */
public interface AskersMapper {

	//��ȡ���е���ѯʦ
	public List<Askers> selectaskers();
	//�޸�һ����ѯʦ
	public int updateaskers(@Param("name")String name,@Param("weight")String weight,@Param("bakContent")String bakContent);
	//����ǩ�������鿴��ѯʦ����
	public List<UserChecks> selectaskersfromqiandao();
	//ǩ����ǰǩ������ѯʦ
	public int qiandaozixunshi(@Param("id")String id);
	//��ѯ��ѯʦ(Ȩ������,���ѧ��s��,ǩ��ʱ�䵱��,��ǩ��,ȡ��һ��)
	public Askers zidongfenpeizixunshi();
	
	public List<Askers> zidongfenpeizixunshi2();
	//���һ��ѧ��֮�����ѧ��״̬��Ϊ��
	public int updatestate(@Param("askId")String askId);
	//������е���ѯʦ״̬��������ȫ���ĳɷ�
	public int updatestatefou();
	//����һ����ѯʦ
	public int insertasker(@Param("id")String id,@Param("askname")String askname);
	//����һ����ѯʦ
	public int insertaskerer(@Param("id")String id,@Param("askname")String askname);
	//�Ƴ�һ����ѯʦ
	public int deleteasker(@Param("id") String id);
	
	

	
	
	
}
