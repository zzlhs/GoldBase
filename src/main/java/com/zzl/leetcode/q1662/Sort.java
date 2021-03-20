package com.zzl.leetcode.q1662;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
//		new Sort().bubble();
//		new Sort().insertSort();
		new Sort().selectionSort();
		
//		List<Integer> userTaskListUpdate = new ArrayList<Integer>();
//		userTaskListUpdate.add(123);
//		userTaskListUpdate.add(1234);
//		userTaskListUpdate.add(12345);
//		userTaskListUpdate.add(123456);
//		System.out.println(userTaskListUpdate);
//		userTaskListUpdate.clear();
//		System.out.println(userTaskListUpdate);
	}
	
	public void bubble() {
		int[] a = {10,1, 2, 9, 5 ,7};
		
		for(int num: a) {
			System.out.print(num + " ");
		}
		int temp = -1;
		for(int i = 0 ;i <= a.length - 1;i++) {
			for(int j = 0;j < a.length - i -1 ;j++) {
				if(a[j] > a[j+1] ) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		System.out.println();
		for(int num: a) {
			System.out.print(num + " ");
		}
	}
	
	/**
	 *       8 15 20 45 17
	 * (1)   
	 * 
	 * 
	 * 		适合数据量小，量级小于千
	 */
	
	public void insertSort() {
		int[] a = {10,1, 2, 9, 5 ,7};
		
		for(int num: a) {
			System.out.print(num + " ");
		}
		int temp = -1;
		for(int i = 1 ;i < a.length ;i++) {
			for(int j = i;j > 0 ;j--) {
				if(a[j] < a[j-1] ) {
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}else {
					break;
				}
			}
		}
		System.out.println();
		for(int num: a) {
			System.out.print(num + " ");
		}
	}
	
	
	public void selectionSort() {
		int[] a = {10,1, 2, 9, 5 ,7};
		
		for(int num: a) {
			System.out.print(num + " ");
		}
		
		int temp = -1,minIndex = -1;
		for(int i = 0 ;i < a.length ;i++) {
//			minIndex = i;
			for(int j = i+1;j <a.length ;j++) {
				if(a[j] < a[i] ) {
					minIndex = j;
				}
			}
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		System.out.println();
		for(int num: a) {
			System.out.print(num + " ");
		}
	}
}


