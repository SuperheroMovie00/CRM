package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.StudentMoban;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;

public interface StudentService {

	// 查询所有的学生信息
	public List<Students> selectuser(StudentQuery stude);

	// 查询所有的学生信息
	public List<Students> selectuser2(StudentQuery stude);
	
	
	public List<Students> selectuser3(StudentQuery stude);

	// 查询所有的学生

	public List<Students> selectAllStudentisdelete(StudentQuery student);

	// 查询所有学生的条数
	public int Studentcount();

	// 添加一个学生信息
	public Result insertStudent(Students student);

	// 添加一个学生(自动分配的状态)
	public Result insertStudent2(Students student);

	// 修改一个学生的信息
	public Result updateStudent(UpdateStudentQuery student);

	// 删除一个学生
	public Result deleteStudent(Integer id);

	// 批量操作分配咨询师操作
	public Result insertaskers(String id, String askersid, String askersname);

	// 获取点击的学生的信息生成Except
	public List<Students> checkStudent(String id);

	// 获取所有的学生(生成表格)
	public List<StudentMoban> selectStudentall();

	// 获取所有的学生(生成表格)
	public List<Students> selectStudentaller();

	

	// 还原一个删除的学生
	public int huanyuanstudent(Integer id);

	// 彻底删除一个学生
	public int chedishanchustudent(Integer id);

	/* 根据学生的学历查询学生的人数 */
	public int selectcountxueli(String state);
	
	//根据学生的状态查询学生的人数
		public int selectcountstate(@Param("studentstate")String studentstate);
		
		//新增一个学生
		public Result insertStudenter2(StudentMoban student);
		
		// 新增一个学生
		public Result insertStudenter(StudentMoban student);

}
