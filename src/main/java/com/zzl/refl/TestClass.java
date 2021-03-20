package com.zzl.refl;

import java.lang.reflect.Field;

public class TestClass {
	public static void main(String[] args) {
		Students stu = new Students("123", 2);
		System.out.println(stu);
		Class clazz = stu.getClass();
		
		for( Field field : clazz.getDeclaredFields()) {
//			System.out.println(field);
			field.setAccessible(true);
			if(field.toString().contains("Integer")) {
				System.out.println("数字类型");
				try {
					field.set(stu, 8);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(stu);
	}
}
