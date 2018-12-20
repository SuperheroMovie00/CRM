package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.UserCheckQuery;
import com.ysd.entity.UserChecks;


/**
 * 
 * 员工签到接口
 * @author 爱新觉罗
 *
 */
public interface UserCheckMapper {
	
	//查询员工的
   public List<UserChecks> selectalluserCheck(UserCheckQuery usercheck);
   //签到
   public int qiandao(@Param("username")String username);
   //签到(2)
   public int qiandaoqian(@Param("username")String username,@Param("id")String id);
   //签退
   public int qiantui(@Param("username")String username);
   //签退
   public int qiantuiqian(@Param("username")String username);
   //查询员工表中信息的条数
   public int usercheckcount();
   //根据登陆的名字查询签到的状态
   public UserChecks selectstate(@Param("LoginName")String LoginName);
  
	
	

}
