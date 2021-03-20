package com.zzl.leetcode.sort;

import java.util.Arrays;

/**
 * 
 * @author:zyf
 * @Date:2021-3-20 10:11:27 开始
 */
public class LeetCode252 {
	
	
	public static void main(String[] args) {
		int[][] intervals = {{7, 10}, {6,9}};
		
		System.out.println(merge(intervals));
	}
	
	public static boolean merge(int[][] intervals) {
		
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		
		for(int i = 1 ; i < intervals.length ;i++) {
			if(intervals[i][0] < intervals[i-1][1]) {
				return false;
			}
		}
		return true;
	}
}
