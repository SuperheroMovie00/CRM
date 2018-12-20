package com.ysd.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/restful")
public class FilterController {
	
	/**
	 * http://localhost:8080/SpringMVC/fileForm.jsp
	 * http://localhost:8080/SpringMVC/restful/file
	 * SpringMVC处理文件上传
	 * @param myfile
	 * @return
	 */
	@RequestMapping(value="/file",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value="myfile",required=false) CommonsMultipartFile myfile){
		String name = myfile.getName();//form表单中参数名称
		String originalfileName = myfile.getOriginalFilename();//得到上传文件的名称
		System.out.println("name "+name);
		System.out.println("originalfileName"+originalfileName);
		
		String filePath = "D:\\app";
		
		File toFile = new File(filePath, originalfileName);
		if(!toFile.exists()){
			toFile.mkdirs();
		}
		
		try {
			myfile.transferTo(toFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return "上传成功:   "+originalfileName;
	}
	

	
	
}
