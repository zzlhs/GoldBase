package com.zzl.view;

/**
 * 
 * @author:zyf
 * @Date:2021-3-19 1:40:12 开始时间
 */
public class Zingfront2 {
	
	
	public static void main(String[] args) {
		int[] nums = {15, 2, 8, 13};
		
		int[] res = solution(nums);
	}
	
	/**
	  * 思路：
	 * 1 倒序遍历数组可以利用栈减少循环遍历次数
	 * 2 利用栈来存储上一个数的大于本身的第一个数或-1恰好满足第一个大于本身的题目条件
	 * 时间复杂度： 
	 * 
	 * 最坏情况：{15, 2, 13, 8 }  像这种数组排列，一个后面的第一个元素大于前一个，一个后面
	 * 的元素小于前一个，且第一个最大
	 * 
	 * 
	 * @Date:2021-3-19 2:08:29 结束时间
	 * @param nums
	 */
	public static int[] solution(int[] nums) {
		Stack<Integer> myStack = new Stack(nums.length);
		myStack.push(-1);
		int[] res = new int[nums.length]; 
		res[nums.length - 1] = -1;
		Integer resTemp = null;
		
		
		for(int i = nums.length - 2; i >= 0;i--) {
			resTemp = null;
			if(nums[i+1] > nums[i]) {
				resTemp = nums[i+1];
				myStack.push(resTemp);
			}else {
				while(myStack.peek() != null ) {
					int stackValue = myStack.pop();
					if(stackValue > nums[i]) {
						resTemp = stackValue;
						myStack.push(resTemp);
						break;
					}
				}
				if(null == resTemp ) {
					resTemp = -1;
				}
			}
			res[i] = resTemp;
		}
		
		return res;
	}
}

class Stack<E>{
	
	Object[] date = null;
	Integer count = null;
	
	public Stack(int initCapacity) {
		date = new Object[initCapacity];
		count = 0;
	}
	
	public E push(E object) {
		date[count++] = object;
		return object;
	}
	
	public E pop() {
		E temp = (E) date[--count];
		date[count] = null;
		return temp;
	}
	
	public E peek() {
		if(count == 0)
			return null;
		return (E) date[count-1];
	}
}
