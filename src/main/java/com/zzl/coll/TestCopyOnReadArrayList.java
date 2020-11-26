package com.zzl.coll;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnReadArrayList {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		
		copyOnWriteArrayList.add("123");
		copyOnWriteArrayList.add("456");

		System.out.println(copyOnWriteArrayList);
	}
}
