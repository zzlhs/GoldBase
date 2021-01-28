package com.zzl.net;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		List list = new ArrayList();
		list.add(2);
		System.out.println(list);
		test.test(list);
		System.out.println(list);
		System.out.println(System.currentTimeMillis());
		
		String timeStamp = "160938x007216";
		timeStamp = "0000000000000";
//			         0000000000000
		System.out.println(isTimeStamp(timeStamp) + "");
		
	}
	
	
	void test(List arrayList){
		arrayList.add(1);
	}
	
	public static boolean isTimeStamp(String timeStamp) {
		if(timeStamp == null) {
			return false;
		}
		// 该正则表达式可以匹配所有的数字 包括负数
		Pattern pattern = Pattern.compile("[0-9]{13}");
		Matcher isNum = pattern.matcher(timeStamp); // matcher是全匹配
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
}
