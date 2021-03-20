package com.zzl.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author:zyf
 * @Date:2021-3-18
 * 哎，后四会年轻不刷题啊
 */
public class BanYu2 {
	
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		List<Integer> resList = new ArrayList<Integer>();
		m1(nums, 3, resList);
		System.out.println(resList);
	}
	
	
	public static void m1(int[] nums, int k, List<Integer> resList) {
		Integer curMax = null;
		int flag = 0;
		for(int i = 0; i < nums.length - (k - 1) ;i++) {
			curMax = null;
			flag = 0;
			while(flag < k) {
				if(resList.size() > 0) { // 这个if --> 每一次循环增加2次判断但是有可能减少了2次循环，很值的
					if(resList.get(resList.size() - 1) > nums[i+k - 1]) {
						curMax = resList.get(resList.size() - 1);
						break;
					}
				}
				if(null == curMax || curMax < nums[i+flag]) {
					curMax = nums[i+flag];
				}
				flag++;
			}
			resList.add(curMax);
		}
	}
	
}
