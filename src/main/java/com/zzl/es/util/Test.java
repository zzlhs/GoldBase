package com.zzl.es.util;

import org.elasticsearch.action.index.IndexRequest;
import org.springframework.util.DigestUtils;

public class Test {
	
	/*
	 *            a
	 *      b            e
	 *          c              f
	 *        d             g
	 *                    h   k
	 */
	
	/**
	 * 前序 根左右 abcdefghk
	 * 中序 左根右 bdcaehgkf
	 * 后序 左右根 dcbhkgfea
	 */
	
	public static void main(String[] args) {
		
		String strMd5 = DigestUtils.md5DigestAsHex("zyf".getBytes());
		System.out.println(strMd5);
		
//		IndexRequest indexRequest
	}
}
