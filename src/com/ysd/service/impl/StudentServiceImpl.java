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

	// ��ȡ���е�ѧ��
	@Override
	public List<Students> selectuser(StudentQuery stude) {
		return studentmapper.selectAllStudent(stude);
	}

	// ��ȡ���е�ѧ��
	@Override
	public List<Students> selectAllStudentisdelete(StudentQuery stude) {
		return studentmapper.selectAllStudentisdelete(stude);
	}

	// ��ȡ���е�ѧ��2
	@Override
	public List<Students> selectuser2(StudentQuery stude) {
		return studentmapper.selectAllStudent2(stude);
	}

	// ѧ����Ϣ��������
	@Override
	public int Studentcount() {
		return studentmapper.Studentcount();
	}

	// ���һ��ѧ����Ϣ
	@Override
	public Result insertStudent(Students student) {
		System.out.println(student);
		int r = studentmapper.insertStudent(student);
		if (r > 0) {
			return new Result(true, "��ӳɹ�");

		} else {
			return new Result(false, "���ʧ�� ");
		}

	}

	// ���һ��ѧ����Ϣ(�Զ�����������)
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
			return new Result(true, "��ӳɹ�");
		} else {
			return new Result(false, "���ʧ�� ");
		}

	}

	// �޸�һ��ѧ������Ϣ
	@Override
	public Result updateStudent(UpdateStudentQuery student) {
		int r = studentmapper.updateStudent(student);
		if (r > 0) {
			return new Result(true, "�޸ĳɹ�");

		} else {
			return new Result(false, "�޸�ʧ�� ");
		}
	}

	// ɾ��һ��ѧ��
	@Override
	public Result deleteStudent(Integer id) {
		int r = studentmapper.deleteStudent(id);
		if (r > 0) {
			return new Result(true, "ɾ���ɹ�");

		} else {
			return new Result(false, "ɾ��ʧ�� ");
		}
	}

	// ��������������ѯʦ����
	@Override
	public Result insertaskers(String id, String askersid, String askersname) {
		int r = studentmapper.insertaskers(id, askersid, askersname);

		System.out.println("����id" + id);
		if (r > 0) {
			return new Result(true, "����ɹ�");

		} else {
			return new Result(false, "����ʧ�� ");
		}
	}

	// ��ȡ�����ѧ������Ϣ����Except
	@Override
	public List<Students> checkStudent(String id) {
		return studentmapper.checkStudent(id);
	}

	// ��ȡ���е�ѧ��(���ɱ��)
	@Override
	public List<StudentMoban> selectStudentall() {

		return studentmapper.selectStudentall();
	}

	// ����һ��ѧ��
	@Override
	public Result insertStudenter(StudentMoban student) {
		int r =studentmapper.insertStudenter(student);
		if(r>0){
			return new Result(true,"��ӳɹ�");
		}else{
			return new Result(false,"���ʧ��");
		}
	}

	// ��ȡ���е�ѧ��(���ɱ��)
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

	// ����ѧ����ѯѧ��������
	@Override
	public int selectcountxueli(String state) {
		// TODO Auto-generated method stub
		return studentmapper.selectcountxueli(state);
	}

	
	//����ѧ����״̬��ѯѧ��������
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
			return new Result(true,"��ӳɹ�");
		}else{
			return new Result(false,"���ʧ��");
		}
	}
}
