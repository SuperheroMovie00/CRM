package com.ysd.test;

import com.ysd.util.MailOperation;
/**
 * 邮箱测试
 * @author 爱新觉罗
 *
 */
public class mailtest {
	
	
	public static void main(String[] args) {
		 MailOperation operation = new MailOperation();
	        String user = "857417686@qq.com";
	        String password = "你的邮箱授权码";
	        String host = "smtp.163.com";
	        String from = "你的邮箱地址";
	        String to = "目标邮箱地址";// 收件人
	        String subject = "输入邮件主题";
	        //邮箱内容
	        StringBuffer sb = new StringBuffer();
	        /*String yzm = RandomUtil.getRandomString(6);*/
	        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
	                          + "<div style='width:950px;font-family:arial;'>欢迎使用NET微活动，您的注册码为：<br/><h2 style='color:green'></h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>杭州恩意替电子商务有限公司</div>"
	                         +"</div>");
	        try {
	            String res = operation.sendMail(user, password, host, from, to,
	                    subject, sb.toString());
	            System.out.println(res);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

}
