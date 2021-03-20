package com.zzl.leetcode.backtracking;

import com.vividsolutions.jts.operation.buffer.RightmostEdgeFinder;

public class LeetCode112 {

	public static void main(String[] args) {
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
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		
		System.out.println(hasPathSum(one, 22));

	}
	
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		return backTree(root, targetSum);
    }
	
	public static boolean backTree(TreeNode root, Integer target) {
		if(root == null) {
			return false;
		}
		if(target - root.val ==0 && root.left == null && root.right == null) {
			return true;
		}
		
//		if(root.left != null) {
//			boolean leftRes =	backTree(root.left, target - root.val);
//			if(leftRes) {
//				return leftRes;
//			}
//		}
//		
//		if(root.right != null) {
//			boolean rightRes = backTree(root.right, target - root.val);
//			if(rightRes) {
//				return rightRes;
//			}
//		}
//		return false;
		
		return backTree(root.left, target - root.val) || backTree(root.right, target - root.val);
	}
}


 