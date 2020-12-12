package com.zzl.design.pattern.flyweight;

public class Test {
	
	public static void main(String[] args) {
		FlywieghtFacority facority = new FlywieghtFacority();
		Flyweight flyweight = facority.getFlyweight("zyf");
		flyweight.operation(new UnsharedConcreteFlyweight("zyf_info"));
		
		
		Flyweight flyweight1 = facority.getFlyweight("123");
		flyweight1.operation(new UnsharedConcreteFlyweight("123_info"));
		
		Flyweight flyweight3 = facority.getFlyweight("zyf");
		flyweight3.operation(new UnsharedConcreteFlyweight("zyf2_info"));
		System.out.println(flyweight == flyweight3);
		
	}
}
