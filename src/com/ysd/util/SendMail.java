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
 * JavaMail�����ʼ�:ǰ����QQ�������ʺ�����Ҫ����POP3/SMTPЭ��
 */
public class SendMail {

	/* public static void main(String[] args) throws Exception { */
	public static void fa(String mima) throws Exception {
		
		Properties prop = new Properties();
		
		// ����debug���ԣ��Ա��ڿ���̨�鿴
		prop.setProperty("mail.debug", "true");
		
		// �����ʼ�������������
		prop.setProperty("mail.host", "smtp.qq.com");
		// ���ͷ�������Ҫ�����֤
		prop.setProperty("mail.smtp.auth", "true");
		// �����ʼ�Э������
		prop.setProperty("mail.transport.protocol", "smtp");
		
		// ����SSL���ܣ������ʧ��
		
		//��controller�з��ʵ�ʱ���ж�������!!!!!!!!<<<<<<
		System.out.println("aaa");
		
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		System.out.println("bbb");
		System.out.println(mima);
		sf.setTrustAllHosts(true);
		System.out.println(mima);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// ����session
		Session session = Session.getInstance(prop);
		// ͨ��session�õ�transport����
		Transport ts = session.getTransport();
		// �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
		ts.connect("smtp.qq.com", "857417686", "xbcykthcitqbbcge");// ������ַ�����Ȩ�룬��qq���뷴������ʧ���ˣ����Լ��ģ������ҵģ����������Ϲ��ģ�Ϊ�ˡ���������
		// �����ʼ�
		/* Message message = createSimpleMail(session); */

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("857417686@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"978508692@qq.com"));
		message.setSubject("�޸�������Ϣ");
		message.setContent("���ĸ�����,���޸ĵ�������" + mima, "text/html;charset=UTF-8");

		// �����ʼ�
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/*
	 * public static MimeMessage createSimpleMail(Session session) throws
	 * Exception { // �����ʼ����� MimeMessage message = new MimeMessage(session); //
	 * ָ���ʼ��ķ����� message.setFrom(new InternetAddress("857417686@qq.com")); //
	 * ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
	 * message.setRecipient(Message.RecipientType.TO, new InternetAddress(
	 * "978508692@qq.com")); // �ʼ��ı��� message.setSubject("�޸�������Ϣ"); // �ʼ����ı�����
	 * message.setContent("���ĸ�����,���޸ĵ�", "text/html;charset=UTF-8"); //
	 * ���ش����õ��ʼ����� return message; }
	 */
}
