package com.zzl.design.pattern.builder;

public class Test {
	public static void main(String[] args) {
		Builder builder = new CarBuilder();
		System.out.println(new Director(builder).producer());
		
		
	}
}
