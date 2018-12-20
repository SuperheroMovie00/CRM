package com.ysd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.StudentMoban;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;

/**
 * 
 * ѧ����mapper�ӿ�
 * 
 * @author ���¾���
 * 
 */
public interface StudentMapper {

	// ��ѯ���е�ѧ��

	public List<Students> selectAllStudent(StudentQuery student);
	
	public List<Students> selectAllStudent3(StudentQuery student);
	
	// ��ѯ���е�ѧ��

	public List<Students> selectAllStudentisdelete(StudentQuery student);

	// ��ѯ���е�ѧ��

	public List<Students> selectAllStudent2(StudentQuery student);

	// ��ѯ����ѧ��������
	public int Studentcount();

	// ���һ��ѧ����Ϣ
	public int insertStudent(Students student);

	// ���һ��ѧ��(�Զ������״̬)
	public int insertStudent2(Students student);

	// �޸�һ��ѧ������Ϣ
	public int updateStudent(UpdateStudentQuery student);

	// ɾ��һ��ѧ��
	public int deleteStudent(@Param("id") Integer id);

	// ��������������ѯʦ����
	public int insertaskers(@Param("id") String id,
			@Param("askersid") String askersid,
			@Param("askersname") String askersname);
	
	//��ȡ�����ѧ������Ϣ����Except
	public List<Students> checkStudent(@Param("id")String id);
	
	
	//��ȡ���е�ѧ��(���ɱ��)
	public List<StudentMoban> selectStudentall();
	
	//��ȡ���е�ѧ��(���ɱ��)
	public List<Students> selectStudentaller();
	
	//����һ��ѧ��
	public int insertStudenter(StudentMoban student);
	
	//
	public int insertStudenter2(StudentMoban student);
	
	//��ԭһ��ɾ����ѧ��
	public int huanyuanstudent(@Param("id")Integer id);
	
	//����ɾ��һ��ѧ��
	public int chedishanchustudent(@Param("id")Integer id);
	
	/*����ѧ����ѧ����ѯѧ��������*/
	public int selectcountxueli(@Param("state")String state);
	
	//����ѧ����״̬��ѯѧ��������
	public int selectcountstate(@Param("studentstate")String studentstate);
	
	
	

}
