package com.zzl.offer;

public class PrintMatrix {

	/**
	 * 1 2
	 * 3 4 -> 1 2 4 3
	 * 
	 *  1  2  3  4  
		5  6  7  8  
		9  10 11 12 
		13 14 15 16 
	 * 
	 *  for1 k = 0 k < 4-0; k ++;
	 *  
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("字符的格式化输出---------------------------------");
		String name = "123";
        name = String.format("%-16s", name);
        System.out.println(name);
		System.out.println("字符的格式化输出---------------------------------");

		for(int i = 1; i<= 16;i++) {
			System.out.print(String.format("%-3s", i));
			if(i % 4 == 0) {
				System.out.println();
			}
		}
	}

}
