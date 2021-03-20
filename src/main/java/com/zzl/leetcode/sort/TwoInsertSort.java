package com.zzl.leetcode.sort;

/**
 * 
 * @author:zyf
 * @Date:2021-3-20 16:11:42 开始
 */
public class TwoInsertSort {
	
	
	public static void main(String[] args) {
		int[] array = {2, 1,98,21};
		
		for(int i = 0;i<array.length ;i++) {
			System.out.print (array[i] + " ");
		}
		System.out.println();
		insertSort(array);
		
		for(int i = 0;i<array.length ;i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	/**
	 * 循环
	 * @Date:2021-3-20 16:37:43 结束
	 * @param array
	 */
	public static void insertSort(int[] array) {
		
		for(int i = 1 ; i < array.length ; i++) {
			int key = array[i];
			int low = 0;
			int height = i - 1;
			while(low <= height) {
				int mid = (low + height) >> 1;
				if (array[mid] > key) {
					height = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			for(int j = i ; j > low ; j--) {
				array[j] = array[j - 1];
			}
			array[low] = key;
		}
		
	}
	
	/**
	 * 递归写法
	 * @Date:2021-3-20 16:32:33 结束
	 */
	public static void insertSort2(int[] data, int n) {
		if(n < 2) 
			return;
		insertSort2(data, --n);
		int temp = data[n];
		int index = n - 1;
		while(index >= 0 && data[index] > temp) {
			data[index + 1] = data[index];
			index--;
		}
		data[index + 1] = temp;
	}
}
