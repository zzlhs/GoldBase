package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode46 {
	
	public static void main(String[] args) {
		int[] nums = {1,3,2};
		System.out.println(permute(nums));
//		Collections.swap(list, i, j);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		back(nums, 0,res, new ArrayList<Integer>());
		return res;
	}
	
	public static void back(int[] nums,int cur, List<List<Integer>> res, List<Integer> curRes) {
		
		if(curRes.size() == nums.length) {
			res.add(new ArrayList<Integer>(curRes));
			return; // 注意这个和113的区别
		}
		
		for(int i = 0;i<nums.length; i++) {
			if(curRes.contains(nums[i])) {
				continue;
			}
			curRes.add(nums[i]);
			back(nums, i,res, curRes);
			curRes.remove(curRes.size() - 1);
		}
	}
}
