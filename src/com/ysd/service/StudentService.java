package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Result;
import com.ysd.entity.StudentMoban;
import com.ysd.entity.StudentQuery;
import com.ysd.entity.Students;
import com.ysd.entity.UpdateStudentQuery;

public interface StudentService {

	// ��ѯ���е�ѧ����Ϣ
	public List<Students> selectuser(StudentQuery stude);

	// ��ѯ���е�ѧ����Ϣ
	public List<Students> selectuser2(StudentQuery stude);
	
	
	public List<Students> selectuser3(StudentQuery stude);

	// ��ѯ���е�ѧ��

	public List<Students> selectAllStudentisdelete(StudentQuery student);

	// ��ѯ����ѧ��������
	public int Studentcount();

	// ���һ��ѧ����Ϣ
	public Result insertStudent(Students student);

	// ���һ��ѧ��(�Զ������״̬)
	public Result insertStudent2(Students student);

	// �޸�һ��ѧ������Ϣ
	public Result updateStudent(UpdateStudentQuery student);

	// ɾ��һ��ѧ��
	public Result deleteStudent(Integer id);

	// ��������������ѯʦ����
	public Result insertaskers(String id, String askersid, String askersname);

	// ��ȡ�����ѧ������Ϣ����Except
	public List<Students> checkStudent(String id);

	// ��ȡ���е�ѧ��(���ɱ��)
	public List<StudentMoban> selectStudentall();

	// ��ȡ���е�ѧ��(���ɱ��)
	public List<Students> selectStudentaller();

	

	// ��ԭһ��ɾ����ѧ��
	public int huanyuanstudent(Integer id);

	// ����ɾ��һ��ѧ��
	public int chedishanchustudent(Integer id);

	/* ����ѧ����ѧ����ѯѧ�������� */
	public int selectcountxueli(String state);
	
	//����ѧ����״̬��ѯѧ��������
		public int selectcountstate(@Param("studentstate")String studentstate);
		
		//����һ��ѧ��
		public Result insertStudenter2(StudentMoban student);
		
		// ����һ��ѧ��
		public Result insertStudenter(StudentMoban student);

}
