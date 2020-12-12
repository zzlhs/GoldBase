package com.zzl.design.pattern.proxy;

public class Proxy {
	
	private Subject realSubject;
	
	public Subject getRealSubject() {
		if(realSubject == null) {
			realSubject = new RealSubject();
		}
		
		pre();
		realSubject.desc();
		next();
		return realSubject;
	}

	private void next() {
		System.out.println("proxy next()...");
	}

	private void pre() {
		System.out.println("proxy pre()...");
	}
}
