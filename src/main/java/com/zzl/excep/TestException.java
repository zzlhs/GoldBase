package com.zzl.excep;

public class TestException {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			int i = 9/0;
//			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			long end = System.currentTimeMillis();
			System.out.println("---> " + (end - start));
		}
		

	}
}
