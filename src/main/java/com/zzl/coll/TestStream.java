package com.zzl.coll;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {
	public static void main(String[] args) {
		//定义一个100元素的集合，包含A-Z
		List<String> list = new LinkedList<>();
		for (int i =0;i<100;i++){
		    list.add(String.valueOf((char)('A'+Math.random()*('Z'-'A'+1))));
		}
		System.out.println(list);
		
		//统计集合重复元素出现次数，并且去重返回hashmap
		Map<String, Long> map = list.stream().
		    collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		System.out.println(map.size());

		
		long count = map.entrySet().stream().filter(item -> {
			if(item.getValue() != 1) {
				return true;
			}else {
				return false;
			}
		}).count();
		System.out.println("数量 --> " + count);

		
		List<Entry<String, Long>> listTemp =	map.entrySet().stream().filter(item -> {
			if(item.getValue() != 1) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		System.out.println(listTemp);
		System.out.println(listTemp.size());
		
//		Map<String, Object> collect = map.entrySet()
//			.stream()
//			.peek(item -> item.setValue(l)))
//			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			
//			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		String str = null;
		System.out.println(str.toString());
		
	}
}
