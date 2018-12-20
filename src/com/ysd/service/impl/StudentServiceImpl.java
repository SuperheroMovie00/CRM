package com.ysd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.dao.AskersMapper;
import com.ysd.dao.StudentMapper;
import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.StudentMoban;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;
import com.ysd.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentmapper;
	@Autowired
	private AskersMapper askermapper;

	// 获取所有的学生
	@Override
	public List<Students> selectuser(StudentQuery stude) {
		return studentmapper.selectAllStudent(stude);
	}

	// 获取所有的学生
	@Override
	public List<Students> selectAllStudentisdelete(StudentQuery stude) {
		return studentmapper.selectAllStudentisdelete(stude);
	}

	// 获取所有的学生2
	@Override
	public List<Students> selectuser2(StudentQuery stude) {
		return studentmapper.selectAllStudent2(stude);
	}

	// 学生信息的总条数
	@Override
	public int Studentcount() {
		return studentmapper.Studentcount();
	}

	// 添加一个学生信息
	@Override
	public Result insertStudent(Students student) {
		System.out.println(student);
		int r = studentmapper.insertStudent(student);
		if (r > 0) {
			return new Result(true, "添加成功");

		} else {
			return new Result(false, "添加失败 ");
		}

	}

	// 添加一个学生信息(自动分配条件下)
	@Override
	public Result insertStudent2(Students student) {
		Askers ask = askermapper.zidongfenpeizixunshi();
		if (ask == null) {
			askermapper.updatestatefou();
		}
		Askers askc = askermapper.zidongfenpeizixunshi();
		student.setAskerId(askc.getAskerId());
		student.setZiXunName(askc.getAskerName());
		int r = studentmapper.insertStudent2(student);
		if (r > 0) {
			askermapper.updatestate(askc.getAskerId());
			return new Result(true, "添加成功");
		} else {
			return new Result(false, "添加失败 ");
		}

	}

	// 修改一个学生的信息
	@Override
	public Result updateStudent(UpdateStudentQuery student) {
		int r = studentmapper.updateStudent(student);
		if (r > 0) {
			return new Result(true, "修改成功");

		} else {
			return new Result(false, "修改失败 ");
		}
	}

	// 删除一个学生
	@Override
	public Result deleteStudent(Integer id) {
		int r = studentmapper.deleteStudent(id);
		if (r > 0) {
			return new Result(true, "删除成功");

		} else {
			return new Result(false, "删除失败 ");
		}
	}

	// 批量操作分配咨询师操作
	@Override
	public Result insertaskers(String id, String askersid, String askersname) {
		int r = studentmapper.insertaskers(id, askersid, askersname);

		System.out.println("传入id" + id);
		if (r > 0) {
			return new Result(true, "分配成功");

		} else {
			return new Result(false, "分配失败 ");
		}
	}

	// 获取点击的学生的信息生成Except
	@Override
	public List<Students> checkStudent(String id) {
		return studentmapper.checkStudent(id);
	}

	// 获取所有的学生(生成表格)
	@Override
	public List<StudentMoban> selectStudentall() {

		return studentmapper.selectStudentall();
	}

	// 新增一个学生
	@Override
	public Result insertStudenter(StudentMoban student) {
		int r =studentmapper.insertStudenter(student);
		if(r>0){
			return new Result(true,"添加成功");
		}else{
			return new Result(false,"添加失败");
		}
	}

	// 获取所有的学生(生成表格)
	@Override
	public List<Students> selectStudentaller() {
		// TODO Auto-generated method stub
		return studentmapper.selectStudentaller();
	}

	@Override
	public int huanyuanstudent(Integer id) {

		return studentmapper.huanyuanstudent(id);
	}

	@Override
	public int chedishanchustudent(Integer id) {
		return studentmapper.chedishanchustudent(id);
	}

	// 根据学历查询学生的人数
	@Override
	public int selectcountxueli(String state) {
		// TODO Auto-generated method stub
		return studentmapper.selectcountxueli(state);
	}

	
	//根据学生的状态查询学生的条数
	@Override
	public int selectcountstate(String studentstate) {
		return studentmapper.selectcountstate(studentstate);
	}

	@Override
	public List<Students> selectuser3(StudentQuery stude) {
		
		return studentmapper.selectAllStudent3(stude);
	}

	
	@Override
	public Result insertStudenter2(StudentMoban student) {
		
		Askers ask = askermapper.zidongfenpeizixunshi();
		if (ask == null) {
			askermapper.updatestatefou();
		}
		Askers askc = askermapper.zidongfenpeizixunshi();
		student.setAskerId(askc.getAskerId());
		student.setZiXunName(askc.getAskerName());
		int r =studentmapper.insertStudenter2(student);
		if(r>0){
			askermapper.updatestate(askc.getAskerId());
			return new Result(true,"添加成功");
		}else{
			return new Result(false,"添加失败");
		}
	}
}
