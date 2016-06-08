package com.cslg.OfficeControl.Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ����JDK�ṩ��MD5�㷨��һ���ֽ���������ַ�������ϢժҪ������16�����ַ�������ʽ����
 * 
 * @author jimshen
 * 
 */
public class MD5 {
	/**
	 * ��һ���ֽ��������ϢժҪ������16�����ַ�������ʽ����
	 * 
	 * @param input
	 *            Ҫ����ϢժҪ���ֽ�����
	 * @return ��ϢժҪֵ����16�����ַ�������ʽ����
	 * @throws NoSuchAlgorithmException 
	 * @throws Exception
	 */
	public static String md5(byte[] input) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(input);
		return conversion(b);
	}

	/**
	 * ��һ���ַ�������ϢժҪ������16�����ַ�������ʽ����
	 * 
	 * @param input
	 *            Ҫ����ϢժҪ���ַ���
	 * @return ��ϢժҪֵ����16�����ַ�������ʽ����
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws Exception
	 */
	public static String md5(String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return md5(s.getBytes("UTF8"));
	}

	/**
	 * ��һ���ֽ������ֵת����16�����ַ���
	 * 
	 * @param b
	 *            Ҫת�����ֽ�����
	 * @return ת�����16�����ַ���
	 */
	private static String conversion(byte[] b) {
		String s = "";
		String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
				"b", "c", "d", "e", "f" };
		for (int i = 0; i < b.length; i++) {
			int n = b[i];
			if (n < 0)
				n = n + 256;
			int d1 = n / 16;
			int d2 = n % 16;
			s = s + hex[d1] + hex[d2];
		}
		return s;
	}
}
