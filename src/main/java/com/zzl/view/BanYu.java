package com.zzl.view;

/**
 * 
 * @author:zyf
 * @Date:2021-3-18
 * 这题看似太简单了，面试没写出来。。。
 */
public class BanYu {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		
		int s = 7;
		System.out.println(m1(nums, s));
	}
	
	
	public static int m1(int[] nums, int s) {
		for(int step = 1; step < nums.length ; step ++) {
			for(int i = 0 ; i<nums.length - (step -  1) ; i ++) { // 注意 i++和i+=step的区别
				int flag = 0;
				int curSum = 0;
				while(flag < step) {
					curSum += nums[i+flag];
					flag++;
				}
				if(curSum >= s) {
					return step;
				}
			}
		}
		return 0;
	}
	
}
