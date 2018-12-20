package com.ysd.util;

import java.security.MessageDigest;
/**
 * ʹ��MD5�㷨����,֧�ּ���
 * 
 * @Description:
 * @author Mashuai
 * @Date 2018-5-10 ����2:16:55
 * @Email 1119616605@qq.com
 */
public class PasswordEncoder {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private Object salt;
	private String algorithm;
	/**
	 * ����һ��������
	 * @param salt ��ֵ
	 * @param algorithm �����㷨
	 */
	public PasswordEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}
	
	
	/**
	 * ��ϣ����
	 * @param rawPass  ��ͨ�ı�����
	 * @param hashCount  ��ϣ����
	 * @return ���ܺ�������ַ�
	 */
	public String encode(String rawPass,int hashCount){
		while ( hashCount-- > 0 ) {
			System.out.println("yy rawPass=>"+rawPass);
			rawPass = encode(rawPass);
			System.out.println("tt rawPass=>"+rawPass);
		}
		return rawPass;
	}
	/**
	 * ����
	 * @param rawPass ��ͨ�ı�����
	 * @return ���ܺ�������ַ�
	 */
	public String encode(String rawPass) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// ���ܺ���ַ���
			result = byteArrayToHexString(md.digest(mergePasswordAndSalt(
					rawPass).getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return result;
	}
	
	public boolean isPasswordValid(String encPass, String rawPass) {
		String pass1 = "" + encPass;
		String pass2 = encode(rawPass);

		return pass1.equals(pass2);
	}

	private String mergePasswordAndSalt(String password) {
		if (password == null) {
			password = "";
		}

		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	/**
	 * ת���ֽ�����Ϊ16�����ִ�
	 * 
	 * @param b
	 *            �ֽ�����
	 * @return 16�����ִ�
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) {
		String salt = "tom";
		PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
		String encode = encoderMd5.encode("666",5);
		System.out.println("����ֵ��MD5��ϣ��μ��� ����"+encode.length()+"=>" + encode);
		System.out.println("����ֵ��MD5����"
				+ new PasswordEncoder(null, "MD5").encode("test"));
		boolean passwordValid = encoderMd5.isPasswordValid(
				"1bd98ed329aebc7b2f89424b5a38926e", "test");
		System.out.println(passwordValid);

		PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
		String pass2 = encoderSha.encode("test");
		System.out.println(pass2);
		boolean passwordValid2 = encoderSha.isPasswordValid(
				"1bd98ed329aebc7b2f89424b5a38926e", "test");
		System.out.println(passwordValid2);
	}

}