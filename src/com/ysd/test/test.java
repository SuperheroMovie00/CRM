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
		
		
		/*List<String> list = Arrays.asList("��һ","�¶�","����","����","����");
		String token = null;
		token = JwtToken.sign(list, 3000);
		System.out.println("JWT���ܺ�õ��� token=>"+token);
		System.out.println("JWT���ܺ�õ��� token����=>"+token.length());
		//ģ��Ȩ��У��ģ��
		List<String> result = null;
		 result = JwtToken.unsign(token, List.class);
		 System.out.println("Token����    JWT���ܺ�result=>"+result);
		 //ģ����ڵ�token
		 List<String> expiredResult = null;
		 try {
			 System.out.println("���߳���������...");
			Thread.currentThread().sleep(5000);//��������,token����
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 expiredResult = JwtToken.unsign(token, List.class);
		}catch (TokenExpiredException e) {
			System.err.println("Token����");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println("JWT���ܺ�expiredResult=>"+expiredResult);
		 */
		/* PasswordEncoder encoder=null;
		 
		 encoder = new PasswordEncoder("����Ա", "Md5");
	  		String passss = encoder.encode("ysd123");
		 System.out.println(passss);
		 */
		
		
		/*ExportExcel.*/
		 
		
	/*	PasswordEncoder encoder = null;*/
		
		/*encoder = new PasswordEncoder(null, "Md5");		
		System.out.println(encoder.encode("1"));*/
		
		/*encoder = new PasswordEncoder("����Ա", "Md5");
		System.out.println(encoder.encode("ysd123"));*/
		
		/*encoder = new PasswordEncoder("С����", "Md5");
		String p1 = encoder.encode("ysd123");
		String p2 = encoder.encode(p1);
		String p3 = encoder.encode(p2);
		System.out.println("p3=>"+p3);*/
		
		/*String id=UUID.randomUUID().toString();
		System.out.println(id);
		*/
		
	
		
		
		
		
		
	}

	
	

}
