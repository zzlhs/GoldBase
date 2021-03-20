package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * 
 * @author:zyf
 * @Date:2021-3-19 0:35:42
 */
public class LeetCode39 {
	
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		
		System.out.println(combinationSum(candidates, target));
	}
	
	/**
	 * 
	 * @Date:2021-3-19 23:49:10 结束 列出所有情况但是没有结束
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		
		m1(candidates, target, 0, resList, new ArrayList<Integer>());
		return resList;
    }
	
	/**
	 * 
	 * @param candidates
	 * @param target
	 * @param depth
	 * @param resList
	 * @param res
	 */
	public static void m1(int[] candidates, int target, int depth, List<List<Integer>> resList, List<Integer> res) {
		if(res.stream().mapToInt(Integer::intValue).sum() == target) {
			resList.add(new ArrayList<Integer>(res));
			return;
		}
		if(depth == candidates.length) {
			return;
		}
		
		for(int i = 0;i<candidates.length;i++) {
			res.add(candidates[i]);
			m1(candidates, target, depth + 1, resList, res);
			res.remove(res.size() - 1);
		}
	}

	
}
