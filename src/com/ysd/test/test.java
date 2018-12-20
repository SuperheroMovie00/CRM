package com.ysd.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ysd.util.JwtToken;
import com.ysd.util.PasswordEncoder;
import com.ysd.util.SendMail;

public class test {

	public static void main(String[] args) throws Exception {
		
		
		SendMail s=new SendMail();
		s.fa("sd");
		
		
		/*List<String> list = Arrays.asList("刘一","陈二","张三","李四","王五");
		String token = null;
		token = JwtToken.sign(list, 3000);
		System.out.println("JWT加密后得到的 token=>"+token);
		System.out.println("JWT加密后得到的 token长度=>"+token.length());
		//模拟权限校验模块
		List<String> result = null;
		 result = JwtToken.unsign(token, List.class);
		 System.out.println("Token过期    JWT解密后result=>"+result);
		 //模拟过期的token
		 List<String> expiredResult = null;
		 try {
			 System.out.println("主线程休眠五秒...");
			Thread.currentThread().sleep(5000);//休眠五秒,token过期
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 expiredResult = JwtToken.unsign(token, List.class);
		}catch (TokenExpiredException e) {
			System.err.println("Token过期");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println("JWT解密后expiredResult=>"+expiredResult);
		 */
		/* PasswordEncoder encoder=null;
		 
		 encoder = new PasswordEncoder("管理员", "Md5");
	  		String passss = encoder.encode("ysd123");
		 System.out.println(passss);
		 */
		
		
		/*ExportExcel.*/
		 
		
	/*	PasswordEncoder encoder = null;*/
		
		/*encoder = new PasswordEncoder(null, "Md5");		
		System.out.println(encoder.encode("1"));*/
		
		/*encoder = new PasswordEncoder("管理员", "Md5");
		System.out.println(encoder.encode("ysd123"));*/
		
		/*encoder = new PasswordEncoder("小张三", "Md5");
		String p1 = encoder.encode("ysd123");
		String p2 = encoder.encode(p1);
		String p3 = encoder.encode(p2);
		System.out.println("p3=>"+p3);*/
		
		/*String id=UUID.randomUUID().toString();
		System.out.println(id);
		*/
		
	
		
		
		
		
		
	}

	
	

}
