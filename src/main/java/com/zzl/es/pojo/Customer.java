package com.zzl.es.pojo;

public class Customer {
	private String name;
	private Integer age;
	private Integer sex; // 1 男 0 女
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
//	@Override
//	public String toString() {
//		return "Customer [name=" + name + ", age=" + age + ", sex=" + sex + "]";
//	}
	
}
