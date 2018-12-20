package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.UserChecks;

/**
 * AskersService service接口
 * 
 * @author 爱新觉罗
 * 
 */
public interface AskersService {
	// 获取所有的咨询师
	public List<Askers> selectaskers();

	// 修改一个咨询师
	public Result updateaskers(String name, String weight, String bakContent);

	// 根据签到条件查看咨询师集合
	public List<UserChecks> selectaskersfromqiandao();

	// 签到当前签到的咨询师
	public int qiandaozixunshi(String id);

	// 查询咨询师(权重排序,添加学生否,签到时间当天,已签到,取第一个)
	public Askers zidongfenpeizixunshi();
	
	
	public List<Askers> zidongfenpeizixunshi2();

	// 添加一个学生之后将添加学生状态改为是
	public int updatestate(String askId);

	// 如果所有的咨询师状态都是是则全部改成否
	public int updatestatefou();

	// 新增一个咨询师
	public int insertasker(String id, String askname);

	// 新增一个咨询师
	public int insertaskerer(String id, String askname);

	// 移除一个咨询师
	public int deleteasker(@Param("id") String id);
}
