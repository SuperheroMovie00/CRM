package com.ysd.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ysd.entity.Askers;
import com.ysd.entity.Result;
import com.ysd.entity.Rolemoban;
import com.ysd.entity.Roles;
import com.ysd.entity.StudentMoban;
import com.ysd.entity.Students;
import com.ysd.entity.User;
import com.ysd.entity.Usermoban;
import com.ysd.service.AskersService;
import com.ysd.service.RolesService;
import com.ysd.service.StudentService;
import com.ysd.service.UserService;
import com.ysd.util.PasswordEncoder;
import com.ysd.util.PoiUtils;

/**
 * 
 * @Description:
 * @author 爱新觉罗
 * @Date 2018-5-29 下午01:31:08
 * @Email 1119616605@qq.com
 */
@RestController
@RequestMapping(value = "/excel", name = "Excel操作演示")
public class ExcelController {
	PasswordEncoder encoder = null;
	@Autowired
	StudentService studentservice;
	@Autowired
	AskersService askersservice;
	@Autowired
	RolesService rolesService;
	@Autowired
	UserService userService;

	/**
	 * Excel导出数据 http://localhost:8080/CRM/excel/download
	 * 
	 * @param response
	 * @return
	 */
	// 导出所有的学生
	@RequestMapping(value = "/download", name = "导出选中的学生", produces = "text/html;charset=UTF-8")
	public String download(HttpServletResponse response, String id) {
		

		String downloadName = "学生表格.xls";
		List<Students> list = studentservice.checkStudent(id);

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流
			poiUtils.createExcel(list, Students.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/downloader", name = "导出所有的学生", produces = "text/html;charset=UTF-8")
	public String downloader(HttpServletResponse response) {

		String downloadName = "学生表格.xls";
		List<Students> list = studentservice.selectStudentaller();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流
			poiUtils.createExcel(list, Students.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 导出所有的用户
	@RequestMapping(value = "/downloaduser", name = "导出所有的用户", produces = "text/html;charset=UTF-8")
	public String downloaduser(HttpServletResponse response) {

		String downloadName = "用户表格.xls";
		/* List<User> list = userService.selectuserer(id); */

		List<User> list = userService.selectuserall();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流

			poiUtils.createExcel(list, User.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 导出所有的用户模板
	@RequestMapping(value = "/downloadusermoban", name = "导出所有的用户", produces = "text/html;charset=UTF-8")
	public String downloadusermoban(HttpServletResponse response) {

		String downloadName = "用户表格.xls";
		/* List<User> list = userService.selectuserer(id); */

		List<Usermoban> list = userService.usermoban();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流

			poiUtils.createExcel(list, Usermoban.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 导出所有的角色
	@RequestMapping(value = "/downloadrole", name = "导出所有的角色", produces = "text/html;charset=UTF-8")
	public String downloadrole(HttpServletResponse response) {

		String downloadName = "角色表格.xls";
		List<Roles> list = rolesService.selectrolesall();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流

			poiUtils.createExcel(list, Roles.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 导出所有的角色
	@RequestMapping(value = "/downloadrolemoban", name = "导出角色模板", produces = "text/html;charset=UTF-8")
	public String downloadrolemoban(HttpServletResponse response) {

		String downloadName = "角色模板表格.xls";
		List<Rolemoban> list = rolesService.rolemoban();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流

			poiUtils.createExcel(list, Rolemoban.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/downloadmoban", name = "导出学生的模板", produces = "text/html;charset=UTF-8")
	public String downloadmoban(HttpServletResponse response) {

		String downloadName = "学生模板表格.xls";
		List<StudentMoban> list = studentservice.selectStudentall();

		try {
			PoiUtils poiUtils = new PoiUtils();// Excel工具类
			response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));// 文件名编码处理，防止浏览器下载文件名乱码
			ServletOutputStream outputStream = response.getOutputStream();// 获取响应的字节输出流
			poiUtils.createExcel(list, StudentMoban.class, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Excel导入数据 http://localhost:8080/CRM/excel/upload SpringMVC处理文件上传 单文件上传
	 * 
	 * @param myfile
	 * @return
	 */

	/* 导入学生 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/upload", name = "导入学生")
	public Object upload(
			@RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile,
			@RequestParam(value = "desc", required = false) String desc) {
		String name = myfile.getName();// form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();// 得到上传文件的名称
		System.out.println("表单中文件参数名称 name=>" + name);
		System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
		System.out.println("文件描述信息 desc=>" + desc);

		PoiUtils poiUtils = new PoiUtils();// Excel工具类

		List<StudentMoban> list = null;
		
		
		try {
			list = (List<StudentMoban>) poiUtils.parseExcel(StudentMoban.class,
					myfile.getInputStream(), originalFilename);
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		Result r=null;
		for (StudentMoban students : list) {
			List<Askers> ask = askersservice.zidongfenpeizixunshi2();
			//list集合只能用size判断为空
			
			
			if(Result.kaiguan){
				if(ask.size()==0){
					return new Result(false, "没有签到的咨询师");
				}
				r = studentservice.insertStudenter2(students);
			}else{
				r = studentservice.insertStudenter(students);
			}

		}
		if (r.success) {
			return new Result(true, "导入成功");
		} else {
			return new Result(false, "导入失败");
		}
		
		
		

	}

	/* 导入角色 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadrole", name = "导入角色")
	public Object uploadrole(
			@RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile,
			@RequestParam(value = "desc", required = false) String desc) {
		String name = myfile.getName();// form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();// 得到上传文件的名称	
		System.out.println("表单中文件参数名称 name=>" + name);
		System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
		System.out.println("文件描述信息 desc=>" + desc);

		PoiUtils poiUtils = new PoiUtils();// Excel工具类

		List<Rolemoban> list = null;
		try {
			list = (List<Rolemoban>) poiUtils.parseExcel(Rolemoban.class,
					myfile.getInputStream(), originalFilename);
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(list);
		int r = 0;
		String Id = null;
		for (Rolemoban role : list) {
			Id = UUID.randomUUID().toString();
			role.setId(Id);
			r = rolesService.insertrolemoban(role);
		}
		if (r > 0) {
			return new Result(true, "导入成功");
		} else {
			return new Result(false, "导入失败");
		}

	}

	/* 导入用户 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadroleuser", name = "导入用户")
	public Object uploadroleuser(
			@RequestParam(value = "myfile", required = false) CommonsMultipartFile myfile,
			@RequestParam(value = "desc", required = false) String desc) {
		String name = myfile.getName();// form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();// 得到上传文件的名称
		System.out.println("表单中文件参数名称 name=>" + name);
		System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
		System.out.println("文件描述信息 desc=>" + desc);

		PoiUtils poiUtils = new PoiUtils();// Excel工具类

		List<Usermoban> list = null;
		try {
			list = (List<Usermoban>) poiUtils.parseExcel(Usermoban.class,
					myfile.getInputStream(), originalFilename);
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(list);
		int r = 0;
		String Id = null;
		for (Usermoban user : list) {
			
			Id = UUID.randomUUID().toString();
			user.setId(Id);

			// 将新密码加密并存入数据库中
			encoder = new PasswordEncoder(user.getLoginName(), "Md5");
			String passss = encoder.encode("ysd123");

			user.setPassword(passss);
			r = userService.insertusermoban(user);
		}
		if (r > 0) {
			return new Result(true, "导入成功");
		} else {
			return new Result(false, "导入失败");
		}

	}

}
