package com.zzl.offer;

public class CalOneCount {

	public static void main(String[] args) {
		int temp = 10;
		int count = 0;
		while(temp != 0) {
			++count;
			temp = temp & (temp - 1);
		}
		System.out.println(count);
	}
	
	/**  
	 *   1010
	 *   1001
	 * 	 8421
	 *   正数  
	 * 	 3的过程
	 *   11
	 *   10 
	 *   01 -> 00  2个1
	 *   
	 *   4的过程
	 *   100
	 *   011 -> 000 1个1
	 *   
	 *   负数
	 *    
	 */

}
