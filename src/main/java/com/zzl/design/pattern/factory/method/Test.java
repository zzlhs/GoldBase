package com.zzl.design.pattern.factory.method;

public class Test {
	public static void main(String[] args) {
		new CarFatory().producer().desc();
		
		new BusFatory().producer().desc();
	}
}
