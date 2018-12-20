package cn.api.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5帮助类
 * 
 * @author wang zhaohui
 * @version 1.0
 */
public class MD5Helper {

	/**
	 * 转换到md5
	 * 
	 * @param str
	 *            待转换的字符串
	 * @return MD5字符
	 */
	public static String toMD5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}