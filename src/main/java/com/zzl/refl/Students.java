package com.zzl.refl;

public class Students {
	
	private String name;
	
	private Integer age;

	
	
	public Students() {
		super();
	}

	public Students(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}
}
