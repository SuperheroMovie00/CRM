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
	
	// 获取所有的咨询师
	@Override
	public List<Askers> selectaskers() {
		List<Askers> list=askermapper.selectaskers();
		return list;
	}
	//修改一个咨询师
	@Override
	public Result updateaskers(String name,String weight, String bakContent) {
		System.out.println(name);
		System.out.println(weight);
		System.out.println(bakContent);
		int r=askermapper.updateaskers(name,weight, bakContent);
		if(r>0){
			
			return new Result(true, "修改成功");
		}else{
			return new Result(false, "修改失败");
		}
	
	}
	
	//根据签到条件查看咨询师集合
	@Override
	public List<UserChecks> selectaskersfromqiandao() {
		return askermapper.selectaskersfromqiandao();
	}
	
	
	
	//签到当前签到的咨询师
	@Override
	public int qiandaozixunshi(String id) {
		return askermapper.qiandaozixunshi(id);
	}
	
	
	//查询咨询师(权重排序,添加学生否,签到时间当天,已签到,取第一个)
	@Override
	public Askers zidongfenpeizixunshi() {
		return askermapper.zidongfenpeizixunshi();
	}
	
	
	// 添加一个学生之后将添加学生状态改为是
	@Override
	public int updatestate(String askId) {
		return askermapper.updatestate(askId);
	}
	
	
	// 如果所有的咨询师状态都是是则全部改成否
	@Override
	public int updatestatefou() {
		return askermapper.updatestatefou();
	}
	
	//新增一个咨询师
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
