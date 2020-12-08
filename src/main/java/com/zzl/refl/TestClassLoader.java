package com.zzl.refl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.util.ClassUtils;

public class TestClassLoader {
	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String name = "com.zzl.refl.Students";
		try {
			Class<?>  clazz = Class.forName(name);
//			Class<?>  clazz = ClassUtils.forName(name, classLoader);
			System.out.println(clazz.toString());
			System.out.println(clazz.getName());
			System.out.println(clazz.getDeclaredConstructors());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LinkageError e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------------");
		try {
			Class<?>  clazz = ClassUtils.forName(name, classLoader);
			System.out.println(clazz.toString());
			System.out.println(clazz.getName());
			System.out.println(clazz.getDeclaredConstructors());

			Class<?>[] paramType = new Class<?>[] {};
			Constructor<?> counConstructor = clazz.getDeclaredConstructor(new Class<?>[] {String.class, Integer.class});
			Object object = counConstructor.newInstance(new Object[] {"zyf", 20});
			System.out.println(object);
//			new Class<?>[] { SpringApplication.class, String[].class };

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LinkageError e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
