package com.zzl.pool;

public class ThreadPool {
	public static void main(String[] args) {
		/**
		 *  0011 ^ 0011 ^ 0001 = 0000 ^ 0001 = 0001
		 *  0010 
		 *  0001
		 */
		int i1 = 3 ^ 2;
		
		int i2 = 1 | 2;
		
		int i3 = 1 & 2;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
		System.out.println("-----------------------");
		int[] is = {2, 3, 1, 3, 6};
//			 {2, 3,1, 6, 3};
		
		/**
		 * 1^2^3^···X^X···N-1^N,xor_num2=
		 * 1^2^3^···X^X···N-1^N,将xor_num和xor_num2异或即可得到X
		 */
		int flag = 1;
		for(int i = 0;i<is.length-1 ;i++) {
			flag = is[i] ^ is[++i];
		}
		
		System.out.println("-----------------------");
		

		System.out.println(2 ^ 3 ^ 1 ^ 3 ^ 6);
		System.out.println(2 ^ 3 ^ 1 ^ 3 ^ 6);
		/**
		 * x ^ x ^ y = y
		 * 
		 * 0101
		 * 0011
		 */

	}
}
