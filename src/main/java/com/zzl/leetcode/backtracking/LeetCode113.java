package com.zzl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;


public class LeetCode113 {
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		
		
		TreeNode one = new TreeNode(5);
		TreeNode two1 = new TreeNode(4);
		TreeNode two2 = new TreeNode(8);
		TreeNode three1 = new TreeNode(11);
		TreeNode three2 = new TreeNode(13);
		TreeNode three3 = new TreeNode(4);
		TreeNode four1 = new TreeNode(7);
		TreeNode four2 = new TreeNode(2);
		TreeNode four3 = new TreeNode(1);
		one.left =two1;one.right = two2;
		two1.left = three1;	two2.left = three2; two2.right = three3;
		three1.left = four1; three1.right = four2; three3.right = four3;
		
		
		System.out.println(pathSum(one, 22));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backTree(root, targetSum, res, new ArrayList<Integer>());
		return res;
    }
	
	public static void backTree(TreeNode root, Integer target, List<List<Integer>> res, List<Integer> curRes) {
		if(root == null) {
			return;
		}
		curRes.add(root.val);
		if(target - root.val ==0 && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(curRes));
		}
		
		backTree(root.left, target - root.val, res, curRes);
		backTree(root.right, target - root.val, res, curRes);
		curRes.remove(curRes.size() - 1);
	}
}
