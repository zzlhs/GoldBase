package com.zzl.offer;

public class NumberLine {
	
	/**
	 * 0 1 1 2 3 5 8 13
	 * 1 2 3 4 5 6 7 8
	 * 
	 * 说那麽多最直接的想法就是第3项以后为f(n) = f(n-1) + f(n-2)
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int res =new NumberLine().Fibonacci(8);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int Fibonacci(int n) throws Exception {
		int num1 = 0;
		int num2 = 1;
		if(n< 1) {
			throw new Exception("不能小于1");
		}
		if (n == 1) {
			return 0;
		}
		
		if (n == 2) {
			return 1;
		}
		for(int i = 3 ; i<= n; i++) {
			num2 = num2 + num1;
			num1 = num2 - num1;
		}
		return num2;
	}

}
