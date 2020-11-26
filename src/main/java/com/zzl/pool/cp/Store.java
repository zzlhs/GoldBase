package com.zzl.pool.cp;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<Integer> list = new ArrayList<Integer>(10);
	public static final int SIZE = 10;

	public ArrayList<Integer> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "Store [list=" + list + "]";
	} 
}