package com.zzl.leetcode.sort;

import java.util.Arrays;

/**
 * 
 * @author:zyf
 * @Date:2021-3-20 0:34:25 开始
 */
public class LeetCode56 {
	
	public static void main(String[] args) {
		int[][] intervals = {{1, 4}, {4, 5}};
	}
	
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		
		for(int i = 1 ; i < intervals.length ;i++) {
			if(intervals[i][0] < intervals[i-1][1]) {
				
			}else {
				
			}
		}
		return null;
//		return true;
	}
}
