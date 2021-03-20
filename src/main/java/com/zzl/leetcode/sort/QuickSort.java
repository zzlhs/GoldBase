package com.zzl.leetcode.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {9 ,8 ,2 ,7};
		quickSort(array, 0, array.length - 1);
		
		for(int i = 0;i<array.length ;i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void quickSort(int[] array, int start, int end) {
		if(start < end) {
			int key = array[start];
			int i = start;
			for(int j = start + 1 ; j <= end; j++) {
				if(key > array[j]) {
					swap(array, j, ++i); // ==i 的作用
				}
			}
			array[start] = array[i];
			array[i] = key;
			quickSort(array, start, i - 1);
			quickSort(array, i+1, end);
		}
	}
	
	public static void swap(int[] array, int i , int j) {
		if(i != j){
			array[i] ^= array[j];
			array[j] ^= array[i];
			array[i] ^= array[j];
		}
	}
}
