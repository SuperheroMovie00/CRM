package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;


/**
 * 
 * Ա��ǩ���ӿ�
 * @author ���¾���
 *
 */
public interface UserCheckMapper {
	
	//��ѯԱ����
   public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck);
   //ǩ��
   public int qiandao(@Param("username")String username);
   //ǩ��(2)
   public int qiandaoqian(@Param("username")String username,@Param("id")String id);
   //ǩ��
   public int qiantui(@Param("username")String username);
   //ǩ��
   public int qiantuiqian(@Param("username")String username);
   //��ѯԱ��������Ϣ������
   public int usercheckcount();
   //���ݵ�½�����ֲ�ѯǩ����״̬
   public UserChecks selectstate(@Param("LoginName")String LoginName);
  
	
	

}
