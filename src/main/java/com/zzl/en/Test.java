package com.zzl.en;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Test {
	public static void main(String[] args) {
		System.out.println(TestEnum.values()[0]);
		long l1 = 0;
		System.out.println( l1 == 0);
		
		
	    LocalDate localDate = LocalDate.now();// LocalDate.of(2019, 1, 1);
	    LocalDate yesterday = localDate.plusDays(-1);
	    System.out.println(yesterday.getDayOfMonth());
	    System.out.println(yesterday.getMonthValue());
	    System.out.println(yesterday.getYear());
	    
	    System.out.println("---------------------------");
		StringJoiner joiner = new StringJoiner(", ", "(", ")");
		
		joiner.add("123");
		joiner.add("456");
		joiner.add("789");
		System.out.println(joiner);
		String str = joiner.toString();
		System.out.println(str);

	}
}
