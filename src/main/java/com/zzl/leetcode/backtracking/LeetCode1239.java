package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 难
 * @author zyf
 *
 */
public class LeetCode1239 {
	
	public static void main(String[] args) {
		String[] arr = {"un","iq","ue"};
		
		int max = 0;
		m1(new ArrayList(Arrays.asList(arr)), new StringBuilder(), max);
		System.out.println(max);
		
	}
	
	public int maxLength(List<String> arr) {
		
		
		
		return 0;
	}
	
	public static void m1(List<String> arr, StringBuilder sb, int max) {
		if(max < sb.length()) {
			max = sb.length();
		}
		for(String item: arr) {
			if(isHaveSubStr(item, sb)) {
				continue;
			}else {
				sb.append(item);
				m1(arr, sb, max);
				sb.deleteCharAt(sb.length() -1);
			}
			
		}
	}
	
	public static boolean isHaveSubStr(String str, StringBuilder sb) {
		for(char c: str.toCharArray()) {
			if(sb.indexOf(c + "") != -1) {
				return true;
			}
		}
		return false;
	}
	
	
}
