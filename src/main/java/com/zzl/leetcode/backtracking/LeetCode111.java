package com.zzl.leetcode.backtracking;


public class LeetCode111 {
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two1 = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		TreeNode three1 = new TreeNode(3);
		TreeNode three2 = new TreeNode(3);
		
//		one.left;
		one.right = two2;
		
		two2.left = three1;
		two2.right = three2;
		
		LeetCode111 leetCode111 = new LeetCode111();
		System.out.println(leetCode111.minDepth(one));
	}
	
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return Math.min(left, right)+1;
	}
}


class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

