package com.ysd.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * �������˺�����
 * @author ���¾���
 *
 */

public class MailAuthenticator extends  Authenticator {
	

    public static String USERNAME = "";
    public static String PASSWORD = "";

    public MailAuthenticator() {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }


}
