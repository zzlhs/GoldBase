package com.zzl.design.pattern.observer;

public class Test {
	public static void main(String[] args) {
		Subject subject = new Subject1();
		Observer observer1 = new Observer1();
		Observer observer2 = new Observer2();

		subject.add(observer1);
		subject.add(observer2);
		
		subject.notifyObserver();
	}
}
