package com.zzl.leetcode.q1662;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
	
	int n = 3;
	
	public static void main(String[] args) {
//		generateParent(2);
//		Node node = new Node("");
//		generateTree(node, 3);
//		generateRes();
		
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		System.out.println(list.toArray()[0]);
//		String[] strs = (String[]) list.toArray();
		String[] strs = list.toArray(new String[ list.size()]);
		System.out.println(strs[0]);
	}
	
	public List<String> generateRes(int n) {
		List<String> res = new ArrayList<String>();
		if(n<0) {
			return res;
		}
		dfs("", res);
		return res;
	}
	
	
	public void dfs(String paths, List<String> res) {
		if(paths.length() == n * 2) {
			res.add(paths);
			return;
		}
		dfs(paths + "(", res);
		dfs(paths + ")", res);

	}
	
	/**
	 * 
	 * @param node
	 * @param n
	 */
	public static void generateTree(Node node,int n) {
		if(n < 0){
			return;
		}
		Node leftNode =	new Node("(");
		Node rightNode = new Node(")");
		node.left = leftNode;
		node.right = rightNode;
		n--;
		generateTree(leftNode, n);
		generateTree(rightNode, n);
	}
}

class Node{
	String value;
	Node left;
	Node right;
	
	public Node(String value) {
		this.value = value;
	}
}
