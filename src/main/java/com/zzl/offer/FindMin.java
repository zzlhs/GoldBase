package com.zzl.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 非递减排序数组的旋转
 * 1 2 5 4 3
 *  
 *
 */
public class FindMin {
	public static void main(String[] args) {
		Integer[] is = {3,4,5,1,2};
		Integer res = is[0];
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(is));
		System.out.println(res);
		for(Integer temp: set) {
//			true ? false : true ;
//			if(res > temp) {
//				res = temp;
//			}
			res = res > temp ? res = temp : res;
		}
		System.out.println(res);
	}

}
