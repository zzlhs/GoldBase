package com.zzl.myself;

public class Test {
	
	public static void main(String[] args) {
		User user = User.builder().build();
		Class clazz = user.getClass();
		if(clazz.isAnnotationPresent(Zzl.class)) {
			Zzl zzl = (Zzl) clazz.getAnnotation(Zzl.class);
			System.out.println(zzl.value() + " " + zzl.isDelete());
		}else {
			System.out.println("没有注解");
		}
		
	}
}
