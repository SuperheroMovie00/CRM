package com.ysd.util;

import java.security.MessageDigest;
/**
 * 使用MD5算法加密,支持加盐
 * 
 * @Description:
 * @author Mashuai
 * @Date 2018-5-10 下午2:16:55
 * @Email 1119616605@qq.com
 */
public class PasswordEncoder {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private Object salt;
	private String algorithm;
	/**
	 * 构造一个加密器
	 * @param salt 盐值
	 * @param algorithm 加密算法
	 */
	public PasswordEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}
	
	
	/**
	 * 哈希加密
	 * @param rawPass  普通文本密码
	 * @param hashCount  哈希次数
	 * @return 加密后的密码字符
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
	 * 加密
	 * @param rawPass 普通文本密码
	 * @return 加密后的密码字符
	 */
	public String encode(String rawPass) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 加密后的字符串
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
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
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
		System.out.println("带盐值的MD5哈希五次加密 长度"+encode.length()+"=>" + encode);
		System.out.println("空盐值的MD5加密"
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