package com.zzl.refl;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("----------------------");
		int[] a = {1,2,3};
		System.out.println(a.length);
		System.out.println(a[a.length - 1]);
		
		System.out.println("-------------------------------");
		String str = "飞机; 电视机分; 厘卡";
		System.out.println(str);
		System.out.println(str.split(";")[0]);
		
		System.out.println("-------------------------------");
		
		
		List<List<String>> conditionSum = new ArrayList<List<String>>();
		List<String> resList = new ArrayList<String>(conditionSum.size() * conditionSum.size() * 2);
		
		List<String> old = new ArrayList<String>();
		old.add("年龄>50");
		old.add("年龄<50");
		
		List<String> sex = new ArrayList<String>();
		sex.add("男");
		sex.add("女");
		conditionSum.add(old);conditionSum.add(sex);
		System.out.println(conditionSum);
		test1(conditionSum, 0, null, resList);
		System.out.println(resList);
		
		System.out.println(172 / 3 * 4);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		List list2 = list.subList(1, 2);
		System.out.println(list);
		System.out.println(list2);
	}
	
	
	  public static void test1(List<List<String>> conditionSum,int n,List<String> re, List<String> res){
	        for(String y : conditionSum.get(n)){
	            List m = re == null?new ArrayList<>():new ArrayList<>(re);
	            m.add(y);
	            if(n+1==conditionSum.size()){
	            	StringBuilder sb = new StringBuilder();
	            	for(Object s: m) {
	            		sb.append(" * " + s);
	            	}
	            	sb.deleteCharAt(0);
	            	sb.deleteCharAt(0);
	            	res.add(sb.toString());
	            }else{
	                test1(conditionSum,n+1,m, res);
	            }
	        }
	   }
 
}
