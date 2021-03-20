package com.zzl.leetcode.backtracking;

/**
 * 
 * @author:zyf
 * @Date:2021-3-19 23:02:56 开始
 */
public class LeetCode37 {
	
	public static void main(String[] args) {
		
	}
	
	public static void solveSudoku(char[][] board) {
		board[0][0] = '5';
		board[1][0] = '3';
		board[4][0] = '7';
		
		board[0][1] = '6';
		board[3][1] = '1';
		board[4][1] = '9';
		board[5][1] = '5';
		
		board[1][2] = '9';
		board[2][2] = '8';
		board[7][2] = '6';
		
    }
	
}
