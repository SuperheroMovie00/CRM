package com.ysd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ysd.util.ValidateCode;

public class ValidateCodeController {
	
	/** 
	 * ��Ӧ��֤��ҳ�� 
	 * @return 
	 */  
	@RequestMapping(value="/validateCode")  
	public String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{  
	    // ������Ӧ�����͸�ʽΪͼƬ��ʽ  
	    response.setContentType("image/jpeg");  
	    //��ֹͼ�񻺴档  
	    response.setHeader("Pragma", "no-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);  

	    HttpSession session = request.getSession();  

	    ValidateCode vCode = new ValidateCode(120,40,5,100);  
	    session.setAttribute("code", vCode.getCode());  
	    vCode.write(response.getOutputStream());  
	    return null;  
	}
	

}
