package com.zzl.leetcode.recursion;

/**
 * 递归练习
 * @author zyf
 *
 */
public class LeetCode101 {
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two1 = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		TreeNode three1 = new TreeNode(3);
		TreeNode three2 = new TreeNode(3);
		one.left = two1;
		one.right = two2;
		two1.left = three1;
		two2.right = three2;
		System.out.println(new LeetCode101().is(one));
	}
	
	public boolean is(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if(leftNode == null && rightNode ==null) { // 为对称二叉树的情况，这里为了避免不为二叉树的或关系需先判断
			return true;
		}
		if((leftNode == null || rightNode == null) ||  // 不为二叉树的情况
				(leftNode.val != rightNode.val)) {
			return false;
		}
		boolean return1 = isSymmetric(leftNode.left, rightNode.right);
		boolean return2 = isSymmetric(leftNode.right, rightNode.left);
		if(return1 == false || return2 == false) { //如果左右子树有一个不是对称，那么就不是对称二叉树
			return false;
		}
		return true;
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
