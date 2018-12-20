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
@RequestMapping(value = "/student", name = "ѧ������")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	@Autowired
	AskersService askersservice;
	@Autowired
	RolesService rolesService;

	// ��ȡ���е�ѧ����Ϣ
	@RequestMapping(value = "GetStudentAll", name = "��ѯ���е�ѧ��")
	@ResponseBody
	public Studentfan selectallstudent(StudentQuery stude) {
        //��ѯ���е���ѯʦ��������id
		List<Askers> ask = askersservice.selectaskers();
		//�����û���id��ѯ��ӵ�еĽ�ɫ
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
	
	// ��ȡ���е�ѧ����Ϣ
		@RequestMapping(value = "GetStudentAllisdelete", name = "��ѯ���е�ѧ��")
		@ResponseBody
		public Studentfan selectAllStudentisdelete(StudentQuery stude) {
			int r = studentservice.Studentcount();
			List<Students> list = studentservice.selectAllStudentisdelete(stude);
			Studentfan cc = new Studentfan(r, list);
			return cc; 
		}
	

	// ���һ��ѧ��
	@RequestMapping(value = "insertStudent", name = "���һ��ѧ��")
	@ResponseBody
	
	public Result insertStudent(Students student) {
		
		List<Askers> ask = askersservice.zidongfenpeizixunshi2();
		//list����ֻ����size�ж�Ϊ��
		if(Result.kaiguan){
			if(ask.size()==0){
				return new Result(false, "û��ǩ������ѯʦ");
			}
			return studentservice.insertStudent2(student);
		}else{
			return studentservice.insertStudent(student);
		}	
	}

	

	// �޸�һ��ѧ��
	@RequestMapping(value = "updateStudent", name = "�޸�һ��ѧ��")
	@ResponseBody
	public Result updateStudent(UpdateStudentQuery student) {

		System.out.println(student);
		return studentservice.updateStudent(student);
	}

	// ɾ��һ��ѧ��
	@RequestMapping(value = "deleteStudent", name = "ɾ��һ��ѧ��")
	@ResponseBody
	public Result deleteStudent(Integer id) {
		return studentservice.deleteStudent(id);
	}

	// ���������ѯʦ
	@RequestMapping(value = "insertaskers", name = "���������ѯʦ")
	@ResponseBody
	public Result insertaskers(@RequestParam("id")String id, String askersid,
			String askersname) {
		System.out.println("����id" + id);
		return studentservice.insertaskers(id, askersid, askersname);
	}
	
	
	@RequestMapping(value = "huanyuanstudent", name = "��ԭһ��ɾ����ѧ��")
	@ResponseBody
	public Result huanyuanstudent(Integer id){
		int r=studentservice.huanyuanstudent(id);
		if (r > 0) {
			return new Result(true, "��ԭ�ɹ�");

		} else {
			return new Result(false, "��ԭʧ�� ");
		}
		
	}
	
	
	@RequestMapping(value = "chedishanchustudent", name = "��ԭһ��ɾ����ѧ��")
	@ResponseBody
	public Result chedishanchustudent(Integer id){
		int r=studentservice.chedishanchustudent(id);
		if (r > 0) {
			return new Result(true, "��ԭ�ɹ�");

		} else {
			return new Result(false, "��ԭʧ�� ");
		}
	}
	
	
	//����ѧ����ѯѧ��������
	@RequestMapping("selectcountxueli")
	@ResponseBody
	public int selectcountxueli(String state){
		return studentservice.selectcountxueli(state);
	}
	
	//��ѯѧ����������
	@RequestMapping("selectcountstate")
	@ResponseBody
	public int selectcountstate(String studentstate){
		return studentservice.selectcountstate(studentstate);	
	}
	
	//��ѯѧ����������
	@RequestMapping("Studentcount")
	@ResponseBody
	public int Studentcount(){
		return studentservice.Studentcount();
	}
	
	//ҳ����ص�ʱ���һ����ʼ��״̬
	@RequestMapping("init")
	@ResponseBody
	public Object init(){
		return Result.kaiguan;	
	}
	
	
	//�����ʱ��ı�״̬��ֵ
	@RequestMapping("initbaocun")
	@ResponseBody
	public Object initbaocun(boolean kaiguanstate){
		System.out.println(kaiguanstate);
		Result.kaiguan=kaiguanstate;
		return Result.kaiguan;	
	}
	
	
	

}
