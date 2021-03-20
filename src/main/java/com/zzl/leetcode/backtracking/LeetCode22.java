package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author:zyf
 * @Date:2021-3-19 22:30:55 开始 2刷
 */
public class LeetCode22 {
	
	public static void main(String[] args) {
		
		System.out.println(generateParenthesis(3));
		
		System.out.println(generateParenthesis(3).size());
		
		System.out.println(isIWant("((()))"));
	}
	
	/**
	 * 写的不好
	 * @Date:2021-3-19 22:57:47 结束
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		
		m1(n * 2, res, new StringBuilder(), 0);
		return res;
	}
	
	
	public static void m1(int depth, List<String> res, StringBuilder sb, int cur) {
		if(depth == sb.length() ) {
			if(isIWant(sb.toString())) {
				res.add(sb.toString());
			}
			return;
		}
		
		sb.append("(");
		m1(depth, res, sb, cur + 1);
		sb.deleteCharAt(sb.length() - 1);
		
		sb.append(")");
		m1(depth, res, sb, cur + 1);
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public static boolean isIWant(String temp) {
		int left = 0,right = 0;
		for(int i = 0 ; i < temp.length() ; i++) {
			if(temp.charAt(0) == ')' || temp.charAt(temp.length() - 1) == '(') {
				return false;
			}
			if(temp.charAt(i) == '(') {
				left++;
			}else {
				right++;
			}
			
			if (left > 3 || right > 3) {
				return false;
			}
		}
		if(left == right)
			return true;
		else
			return false;
	}
	
}
