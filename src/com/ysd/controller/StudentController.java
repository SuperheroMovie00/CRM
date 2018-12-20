package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.Roles;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Studentfan;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;
import com.ysd.service.AskersService;
import com.ysd.service.RolesService;
import com.ysd.service.StudentService;

@Controller
@RequestMapping(value = "/student", name = "学生管理")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	@Autowired
	AskersService askersservice;
	@Autowired
	RolesService rolesService;

	// 获取所有的学生信息
	@RequestMapping(value = "GetStudentAll", name = "查询所有的学生")
	@ResponseBody
	public Studentfan selectallstudent(StudentQuery stude) {
        //查询所有的咨询师遍历出来id
		List<Askers> ask = askersservice.selectaskers();
		//根据用户的id查询所拥有的角色
		List<Roles> role=rolesService.selectrolefromuid(stude.getUserId());
		
		for (Askers askers : ask) {
			if(askers.getAskerId().equals(stude.getUserId())){
				List<Students> list = studentservice.selectuser2(stude);
				int r = studentservice.Studentcount();
				Studentfan cc = new Studentfan(r, list);
				return cc;
			}
		}
		for (Roles roles : role) {
			if(roles.getId().equals("b1fecad6-0aec-11e7-9a05-408d5cd46d51")){
				List<Students> list = studentservice.selectuser3(stude);
				int r = studentservice.Studentcount();
				Studentfan cc = new Studentfan(r, list);
				return cc;
			}
			
		}
		
		
		
		List<Students> list = studentservice.selectuser(stude);
		int r = studentservice.Studentcount();
		Studentfan cc = new Studentfan(r, list);
		return cc;
	}
	
	// 获取所有的学生信息
		@RequestMapping(value = "GetStudentAllisdelete", name = "查询所有的学生")
		@ResponseBody
		public Studentfan selectAllStudentisdelete(StudentQuery stude) {
			int r = studentservice.Studentcount();
			List<Students> list = studentservice.selectAllStudentisdelete(stude);
			Studentfan cc = new Studentfan(r, list);
			return cc; 
		}
	

	// 添加一个学生
	@RequestMapping(value = "insertStudent", name = "添加一个学生")
	@ResponseBody
	
	public Result insertStudent(Students student) {
		
		List<Askers> ask = askersservice.zidongfenpeizixunshi2();
		//list集合只能用size判断为空
		if(Result.kaiguan){
			if(ask.size()==0){
				return new Result(false, "没有签到的咨询师");
			}
			return studentservice.insertStudent2(student);
		}else{
			return studentservice.insertStudent(student);
		}	
	}

	

	// 修改一个学生
	@RequestMapping(value = "updateStudent", name = "修改一个学生")
	@ResponseBody
	public Result updateStudent(UpdateStudentQuery student) {

		System.out.println(student);
		return studentservice.updateStudent(student);
	}

	// 删除一个学生
	@RequestMapping(value = "deleteStudent", name = "删除一个学生")
	@ResponseBody
	public Result deleteStudent(Integer id) {
		return studentservice.deleteStudent(id);
	}

	// 批量添加咨询师
	@RequestMapping(value = "insertaskers", name = "批量添加咨询师")
	@ResponseBody
	public Result insertaskers(@RequestParam("id")String id, String askersid,
			String askersname) {
		System.out.println("传入id" + id);
		return studentservice.insertaskers(id, askersid, askersname);
	}
	
	
	@RequestMapping(value = "huanyuanstudent", name = "还原一个删除的学生")
	@ResponseBody
	public Result huanyuanstudent(Integer id){
		int r=studentservice.huanyuanstudent(id);
		if (r > 0) {
			return new Result(true, "还原成功");

		} else {
			return new Result(false, "还原失败 ");
		}
		
	}
	
	
	@RequestMapping(value = "chedishanchustudent", name = "还原一个删除的学生")
	@ResponseBody
	public Result chedishanchustudent(Integer id){
		int r=studentservice.chedishanchustudent(id);
		if (r > 0) {
			return new Result(true, "还原成功");

		} else {
			return new Result(false, "还原失败 ");
		}
	}
	
	
	//根据学历查询学生的人数
	@RequestMapping("selectcountxueli")
	@ResponseBody
	public int selectcountxueli(String state){
		return studentservice.selectcountxueli(state);
	}
	
	//查询学生的总条数
	@RequestMapping("selectcountstate")
	@ResponseBody
	public int selectcountstate(String studentstate){
		return studentservice.selectcountstate(studentstate);	
	}
	
	//查询学生的总条数
	@RequestMapping("Studentcount")
	@ResponseBody
	public int Studentcount(){
		return studentservice.Studentcount();
	}
	
	//页面加载的时候给一个初始的状态
	@RequestMapping("init")
	@ResponseBody
	public Object init(){
		return Result.kaiguan;	
	}
	
	
	//保存的时候改变状态的值
	@RequestMapping("initbaocun")
	@ResponseBody
	public Object initbaocun(boolean kaiguanstate){
		System.out.println(kaiguanstate);
		Result.kaiguan=kaiguanstate;
		return Result.kaiguan;	
	}
	
	
	

}
