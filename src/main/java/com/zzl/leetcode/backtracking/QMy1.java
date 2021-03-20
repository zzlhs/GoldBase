package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class QMy1 {
	
	
	public static void main(String[] args) {
		int[] candidates = {2, 3, 5};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		m1(res, new ArrayList<Integer>(), candidates, 8, 0);
		System.out.println(res);
		
	}
	
	
	
	public static void m1(List<List<Integer>> res, List<Integer> cur,int[] candidates, int target, int start) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = start;i<candidates.length;i++) {
			if(target < candidates[i]) {
				continue;
			}
//			List<Integer> list = new ArrayList<Integer>(cur);
			cur.add(candidates[i]);
			m1(res, cur, candidates, target - candidates[i], i);
			cur.remove(cur.size() - 1);
		}
	}
}
