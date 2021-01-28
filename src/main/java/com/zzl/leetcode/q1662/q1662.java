package com.zzl.leetcode.q1662;

import java.util.LinkedList;
import java.util.ListIterator;

public class q1662 {
	
	/**
	 * 费马小定理
	 * p是一个质数  a是一个整数
	 * 
	 * (a^p - a) % p == 0
	 * 
	 * 
	 * 5 
	 *  
	 *  (2^5 - 2) % 5 == 0
	 */
	
	public static void main(String[] args) {
		Fancy fancy = new Fancy();
		fancy.append(2);   // 奇妙序列：[2]

		fancy.addAll(3);   // 奇妙序列：[2+3] -> [5]
		fancy.append(7);   // 奇妙序列：[5, 7]
		fancy.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
		fancy.getIndex(0); // 返回 10
		fancy.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
		fancy.append(10);  // 奇妙序列：[13, 17, 10]
		fancy.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
		fancy.getIndex(0); // 返回 26
		fancy.getIndex(1); // 返回 34
		fancy.getIndex(2); // 返回 20
		
		System.out.println(fancy);

	}
}

class Fancy {
	
	private LinkedList<Integer> data;
	
    public Fancy() {
    	data = new LinkedList<Integer>();
    }
    
    public void append(int val) {
    	data.addLast(val);
    }
    
    public void addAll(int inc) {
    	ListIterator<Integer> listIterator = data.listIterator();
    	while(listIterator.hasNext()) {
    		listIterator.set(listIterator.next() + inc);
    	}
    }
    
    public void multAll(int m) {
    	ListIterator<Integer> listIterator = data.listIterator();
    	while(listIterator.hasNext()) {
    		listIterator.set(listIterator.next() * m);
    	}
    }
    public int getIndex(int idx) {
    	return (int) (data.get(idx) % (Math.pow(10, 9) + 7));
    }

	@Override
	public String toString() {
		return "[" + data + "]";
	}
    
}
