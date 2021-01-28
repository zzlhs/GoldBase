package com.zzl.refl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

@Controller
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
	
	public Map<String, String> toMap() throws IllegalArgumentException, IllegalAccessException {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object value = field.get(this);
			map.put(field.getName(), value.toString());
		}
		return map;
	}
	
}
