package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.StudentMoban;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;

/**
 * 
 * 学生的mapper接口
 * 
 * @author 爱新觉罗
 * 
 */
public interface StudentMapper {

	// 查询所有的学生

	public List<Students> selectAllStudent(StudentQuery student);
	
	public List<Students> selectAllStudent3(StudentQuery student);
	
	// 查询所有的学生

	public List<Students> selectAllStudentisdelete(StudentQuery student);

	// 查询所有的学生

	public List<Students> selectAllStudent2(StudentQuery student);

	// 查询所有学生的条数
	public int Studentcount();

	// 添加一个学生信息
	public int insertStudent(Students student);

	// 添加一个学生(自动分配的状态)
	public int insertStudent2(Students student);

	// 修改一个学生的信息
	public int updateStudent(UpdateStudentQuery student);

	// 删除一个学生
	public int deleteStudent(@Param("id") Integer id);

	// 批量操作分配咨询师操作
	public int insertaskers(@Param("id") String id,
			@Param("askersid") String askersid,
			@Param("askersname") String askersname);
	
	//获取点击的学生的信息生成Except
	public List<Students> checkStudent(@Param("id")String id);
	
	
	//获取所有的学生(生成表格)
	public List<StudentMoban> selectStudentall();
	
	//获取所有的学生(生成表格)
	public List<Students> selectStudentaller();
	
	//新增一个学生
	public int insertStudenter(StudentMoban student);
	
	//
	public int insertStudenter2(StudentMoban student);
	
	//还原一个删除的学生
	public int huanyuanstudent(@Param("id")Integer id);
	
	//彻底删除一个学生
	public int chedishanchustudent(@Param("id")Integer id);
	
	/*根据学生的学历查询学生的人数*/
	public int selectcountxueli(@Param("state")String state);
	
	//根据学生的状态查询学生的人数
	public int selectcountstate(@Param("studentstate")String studentstate);
	
	
	

}
