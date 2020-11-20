package com.zzl.stream8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFun {
	
	public static void main(String[] args) {
		System.out.println("start...");
		
		TestFun.testConsumer("我是 testConsumer() 传来的", param -> System.out.println("---> " + param));
		
		List<Integer> list = TestFun.supply(10, () -> (int)(Math.random() * 100));
		System.out.println(list);
		
		System.out.println("end...");
	}
	
	public static void testConsumer(String param, Consumer<String> consumer) {
		consumer.accept(param);
	}
	
	public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
	       List<Integer> resultList = new ArrayList<Integer>();
	       for(int x=0;x<num;x++)  
	           resultList.add(supplier.get());
	       return resultList ;
	}
	
	public static Integer convert(String str, Function<String, Integer> function) {
	    return function.apply(str);
	}
	
	public static List<String> filter(List<String> fruit, Predicate<String> predicate){
	    List<String> f = new ArrayList<>();
	    for (String s : fruit) {
	        if(predicate.test(s)){
	            f.add(s);
	        }
	    }
	    return f;
	}
}
