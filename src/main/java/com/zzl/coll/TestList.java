package com.zzl.coll;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	
	public List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		List<Integer> list = new TestList().list;
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
		
		list.add(5);
		System.out.println(list);
	}
}
