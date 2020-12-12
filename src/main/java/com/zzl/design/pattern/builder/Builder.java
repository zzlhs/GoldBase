package com.zzl.design.pattern.builder;

public interface Builder {
	
	public void setName();
	
	public void setPrize();
	
	public void setWeight();
	
	public Car get();
	
}
