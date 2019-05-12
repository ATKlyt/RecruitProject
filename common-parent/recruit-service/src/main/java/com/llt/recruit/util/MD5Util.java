package com.llt.recruit.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String MD5(String password) {
		byte[] secretBytes = null;
		try {
			// MessageDigest.getInstance("MD5") 生成一个MD5加密计算摘要
			// password.getBytes()将password转换成字节序列
			// digest()完成对password.getBytes()的摘要更新
			// secretBytes为更新完得到的128位整数记16个字节
			secretBytes = MessageDigest.getInstance("MD5").digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//将128位整数以16进制表示，不够32位时前面补零
		String MD5Code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - MD5Code.length(); i++) {
			MD5Code = "0" + MD5Code;
		}
		return MD5Code;
	}
}
