package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
	
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		int[] nums = new int[n];
		for(int i = 0;i < n;i++) {
			nums[i] = i+1;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		back(nums, 0,0, res, new ArrayList<Integer>(), k);
		return res;
	}
		
	public static void back(int[] nums,int cur, int start, List<List<Integer>> res, List<Integer> curRes, int k) {
		if(curRes.size() == k) {
			res.add(new ArrayList<Integer>(curRes));
			return; 
		}
		for(int i = start;i<nums.length; i++) {
			curRes.add(nums[i]);
			back(nums, i, ++start,res, curRes, k);
			curRes.remove(curRes.size() - 1);
		}
	}
}
