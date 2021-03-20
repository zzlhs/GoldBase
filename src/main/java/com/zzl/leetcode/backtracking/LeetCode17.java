package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author:zyf
 * @Date:2021-3-19 21:49:56 开始
 */
public class LeetCode17 {
	
	
	public static void main(String[] args) {
		letterCombinations("23");
	}
	
	/**
	 * 
	 * @Date:2021-3-19 22:26:02 看答案结束 2刷该是
	 * 时间复杂度 3^m * 4^n 
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		Map<Integer, String> number = new HashMap<Integer, String>();
		number.put(2, "abc");
		number.put(3, "def");
		number.put(4, "ghi");
		number.put(5, "jki");
		number.put(6, "mno");
		number.put(7, "pqrs");
		number.put(8, "tuv");
		number.put(9, "wxyz");
		
		List<String> res = new ArrayList<String>();
		List<String> data = new ArrayList<String>();
		
		for(int i = 0;i<digits.length();i++) {
//			System.out.println(digits.charAt(i));
			data.add(number.get((int)digits.charAt(i) - 48));
		}
		m1(res, data, 0, new StringBuilder());
		System.out.println(data);
		System.out.println(res);
		return null;
    }
	
	public static void m1(List<String> res, List<String> data, Integer cur, StringBuilder sb) {
		if(sb.length() == data.size()) {
			res.add(sb.toString());
			return; // 注意return 好思考
		}else {
			for(int i = 0 ; i < data.get(cur).length() ; i++) {
				sb.append(data.get(cur).charAt(i));
				m1(res, data, ++cur, sb);
				cur--;
				sb.deleteCharAt(sb.length() -1);
			}
		}
		
	}
}
