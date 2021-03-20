package com.zzl.leetcode.backtracking;

public class Q24 {
	public static void main(String[] args) {
		// 1 2 3 4
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
//		three.next = four;
		
//		while(one != null) {
//			System.out.println(one.val);
//			one = one.next;
//		}
		
		ListNode head = new Q24().swapPairs(one);
//		System.out.println(head.val);
		System.out.println("----------------------");
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode zero = new ListNode(0);
		zero.next = head;
		ListNode tempNode = zero;
		
		while(tempNode.next != null && tempNode.next.next != null) {
			ListNode node1 = tempNode.next;
			ListNode node2 = tempNode.next.next;
			
			tempNode.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			tempNode = node1;
		}
		return zero.next;
	}
	
//	public ListNode swapPairs(ListNode head) {
//		
//		/**
//		 * 1 2 3 4
//		 * temp
//		 * 
//		 * 1.next = 1.next.next
//		 * 1.next.next = 1
//		 * 
//		 */
//		ListNode zero = new ListNode();
//		
//		if(head == null) return null;
//		
//		ListNode tempNode = head.next;
//		int i = 0;
//		while(tempNode != null ) {
//			head.next = tempNode.next;
//			tempNode.next = head;
//			if(i == 0) {
//				zero.next = tempNode;
//			}
//			if(head.next == null || head.next.next == null) {
//				break;
//			}else {
//				head = head.next;
//				tempNode = head.next;
//			}
//			i++;
//		}
//		return zero.next;
//	}
}
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     
	@Override
	public String toString() {
		return "ListNode [val=" + val+"]";
	}
     
 }