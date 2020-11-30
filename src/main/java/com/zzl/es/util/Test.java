package com.zzl.es.util;

import org.springframework.util.DigestUtils;

public class Test {
	
	public static void main(String[] args) {
		
		String strMd5 = DigestUtils.md5DigestAsHex("zyf".getBytes());
		System.out.println(strMd5);
	}
}
