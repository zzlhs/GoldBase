package com.zzl.refl;

import org.springframework.stereotype.Controller;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Students student = new Students();
		
		student.setAge(1);
		student.setName("zy");
		
		System.out.println(student.toString());
		
		System.out.println(student.toMap());
		System.out.println("----------------------------------");
		Controller controller =	Students.class.getAnnotation(Controller.class);
		if(null == controller) {
			System.out.println("为空...");
		}else {
			System.out.println(controller);
		}
	}
}
