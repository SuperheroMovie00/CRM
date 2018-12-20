package com.ysd.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

//com/sun/mail/util/MailSSLSocketFactory

/**
 * JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
 */
public class SendMail {

	/* public static void main(String[] args) throws Exception { */
	public static void fa(String mima) throws Exception {
		
		Properties prop = new Properties();
		
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true");
		
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");
		
		// 开启SSL加密，否则会失败
		
		//再controller中访问的时候中断在这里!!!!!!!!<<<<<<
		System.out.println("aaa");
		
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		System.out.println("bbb");
		System.out.println(mima);
		sf.setTrustAllHosts(true);
		System.out.println(mima);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com", "857417686", "xbcykthcitqbbcge");// 后面的字符是授权码，用qq密码反正我是失败了（用自己的，别用我的，这个号是我瞎编的，为了。。。。）
		// 创建邮件
		/* Message message = createSimpleMail(session); */

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("857417686@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"978508692@qq.com"));
		message.setSubject("修改密码信息");
		message.setContent("悄悄告诉你,你修改的密码是" + mima, "text/html;charset=UTF-8");

		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/*
	 * public static MimeMessage createSimpleMail(Session session) throws
	 * Exception { // 创建邮件对象 MimeMessage message = new MimeMessage(session); //
	 * 指明邮件的发件人 message.setFrom(new InternetAddress("857417686@qq.com")); //
	 * 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	 * message.setRecipient(Message.RecipientType.TO, new InternetAddress(
	 * "978508692@qq.com")); // 邮件的标题 message.setSubject("修改密码信息"); // 邮件的文本内容
	 * message.setContent("悄悄告诉你,你修改的", "text/html;charset=UTF-8"); //
	 * 返回创建好的邮件对象 return message; }
	 */
}
