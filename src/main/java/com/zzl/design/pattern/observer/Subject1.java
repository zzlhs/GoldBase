package com.zzl.design.pattern.observer;

public class Subject1 extends Subject{

	@Override
	public void notifyObserver() {
		
		for(int i= 0;i<observers.size();i++) {
			observers.get(i).response();
		}
	}

}
