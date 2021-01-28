package com.zzl.leetcode.q1662;

public class q1689 {
	
	/**
	 * 82734
	 * 
	 * 11111 1
	 * 11111 2
	 * 10111 3
	 * 10101 4
	 * 10100 5
	 * 10100 6
	 * 10100 7
	 * 10000 8
	 */
	
	
	public static void main(String[] args) {
		char a = 48;
//		System.out.println(a);
		System.out.println(new Solution().minPartitions("27346209830709182346"));
														 
	}
}

class Solution {
    public int minPartitions(String n) {
    	char temp = 48;
    	for(int i = 0;i<n.length();i++) {
    		temp = temp < n.charAt(i) ? n.charAt(i) : temp;
    	}
    	return temp - 48;
    }
}
