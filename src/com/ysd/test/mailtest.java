package com.ysd.test;

import com.ysd.util.MailOperation;
/**
 * �������
 * @author ���¾���
 *
 */
public class mailtest {
	
	
	public static void main(String[] args) {
		 MailOperation operation = new MailOperation();
	        String user = "857417686@qq.com";
	        String password = "���������Ȩ��";
	        String host = "smtp.163.com";
	        String from = "��������ַ";
	        String to = "Ŀ�������ַ";// �ռ���
	        String subject = "�����ʼ�����";
	        //��������
	        StringBuffer sb = new StringBuffer();
	        /*String yzm = RandomUtil.getRandomString(6);*/
	        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>��ܰ��ʾ��</span>"
	                          + "<div style='width:950px;font-family:arial;'>��ӭʹ��NET΢�������ע����Ϊ��<br/><h2 style='color:green'></h2><br/>���ʼ���ϵͳ�Զ�����������ظ���<br/>��л����ʹ�á�<br/>���ݶ���������������޹�˾</div>"
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
