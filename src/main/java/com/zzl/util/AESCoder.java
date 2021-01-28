package com.zzl.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESCoder {
	
	public static final String encodeRules = "MIIBIjANBgkqhkiG";
	
	public static void main(String[] args) {
		try {
			System.out.println(AESCoder.Encrypt("18231664995", encodeRules));
			
			String name = "z8888pk6666";
			byte[] endocded = Base64.getEncoder().encode(name.getBytes("utf-8"));
			System.out.println("----------------------------------------------");
			System.out.println(new String(endocded));
			
			byte[] decoded = Base64.getDecoder().decode(endocded);
			System.out.println(new String(decoded));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 加密
	 * 
	 * @param sSrc
	 * @param sKey
	 * @return
	 */
	public static String Encrypt(String sSrc, String sKey) throws Exception {
		if (sKey == null || "".equals(sKey)) {
			throw new NullPointerException("密钥为空！");
		}
		if (sKey.length() != 16 && sKey.length() != 32) {
			throw new IllegalStateException("密钥长度不正确！");
		}
		if (sSrc == null || "".equals(sSrc)) {
			throw new NullPointerException("待加密内容为空！");
		}
		byte[] raw = sKey.getBytes("utf-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		return new String(Base64.getEncoder().encode(encrypted));// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}

	/**
	 * 解密
	 * 
	 * @param sSrc
	 * @param sKey
	 * @return
	 */
	public static String Decrypt(String sSrc, String sKey) throws Exception {
		if (sKey == null || "".equals(sKey)) {
			throw new NullPointerException("密钥为空！");
		}
		if (sKey.length() != 16 && sKey.length() != 32) {
			throw new IllegalStateException("密钥长度不正确！");
		}
		if (sSrc == null || "".equals(sSrc)) {
			throw new NullPointerException("待解密内容为空！");
		}
		byte[] raw = sKey.getBytes("utf-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] encrypted1 = Base64.getDecoder().decode(sSrc);// 先用base64解密
		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original, "utf-8");
		return originalString;
	}

}
