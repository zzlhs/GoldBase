package com.zzl.leetcode.backtracking;

public class LeetCode1688 {
	public static void main(String[] args) {
//		new LeetCode1688().numberOfMatches(2, 0);
		System.out.println(2>>1);
	}
	
	public void  numberOfMatches(int n, int matches) {
		if( n == 1) {
			System.out.println(0);
			return;
		}
		
		if(n % 2 == 0) {
			matches += n >> 2;
			n /= 2;
			if(n ==1 ) {
				System.out.println(matches);
				return;
			}
		}else {
			n -=1;
			matches += n>>2;
			n = n >> 2 + 1;
		}
		numberOfMatches(n, matches);
	}
	
}
