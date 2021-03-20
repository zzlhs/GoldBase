package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class EightEmpress {

    int[] result ;
    List<List<String>> list = new ArrayList<>();
    
    public static void main(String[] args) {
		EightEmpress eightEmpress =	new EightEmpress();
		eightEmpress.solveNQueens(8);
		System.out.println(eightEmpress.list.size());
	}

    public List<List<String>> solveNQueens(int n) {
        result = new int[n];
        nQueue(0,n);
        return list;
    }

    public void nQueue(int row,int n){

        if (row == n) { // n个棋子都放置好了，打印结果
             printQueens(result,n);
             return; // n行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for(int col = 0; col < n; col++){
            if(isOk(row,col,n)){
                result[row] = col;
                nQueue(row+1,n);
            }
        }
    }

    public boolean isOk(int row,int colnum,int n){
        int left = colnum -1;
        int right = colnum + 1;
        for(int i = row -1; i>=0; i--){
            if(result[i] == colnum) return false;
            if(left>=0 && result[i] == left ) return false;
            if(right<=n && result[i] == right ) return false;
            left--;
            right++;
        }
        return true;
    }

    private void printQueens(int[] result,int n) {
        List<String> arr =  new ArrayList<String>();
        for (int row = 0; row < n; ++row) {
            StringBuffer s = new StringBuffer();
            for (int column = 0; column < n; ++column) {
                if (result[row] == column)
                    s.append("Q");
                else
                    s.append(".");
            }
            arr.add(s.toString());
        }
        list.add(arr);
    }


}

