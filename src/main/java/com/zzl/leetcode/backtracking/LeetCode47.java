package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode47 {
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(permute(nums));
//		Collections.swap(list, i, j);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		back(nums, 0,res, new ArrayList<Integer>(), new boolean[nums.length]);
		return res;
	}
	
	public static void back(int[] nums,int cur, List<List<Integer>> res, List<Integer> curRes, boolean[] flag) {
		
		if(curRes.size() == nums.length) {
			res.add(new ArrayList<Integer>(curRes));
			return; // 注意这个和113的区别
		}
		
		for(int i = 0;i<nums.length; i++) {
			
			if(flag[i] || (i>0 && nums[i] == nums[i-1] && !flag[i-1])) { // 注意 i>0 i-1的顺序
				continue;
			}
			curRes.add(nums[i]);
			flag[i] = true;
			back(nums, i,res, curRes, flag);
			flag[i] = false;
			curRes.remove(curRes.size() - 1);
		}
	}
}
