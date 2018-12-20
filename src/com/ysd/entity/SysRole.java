package com.ysd.entity;
/**
 * 
 * @Description:   
 * @author         Mashuai 
 * @Date           2018-5-16 下午10:50:29  
 * @Email          1119616605@qq.com
 * 

CREATE TABLE `roletb` (
  `roleId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleName` varchar(20) NOT NULL COMMENT '角色名称',
  `roleExplain` varchar(100) DEFAULT NULL COMMENT '角色说明',
  `roleCreateTime` datetime DEFAULT NULL COMMENT '角色创建时间',
  `roleLastUpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '角色最近修改时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
 */
public class SysRole {

}
