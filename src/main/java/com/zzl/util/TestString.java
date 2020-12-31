package com.zzl.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestString {
	public static void main(String[] args) {
//		String.format("", args);
		System.out.println(1);
		
		System.out.println(1);

		System.out.println(~1);
		/**
		 * 1 -> 0000 0001
		 *      1111 1110
		 * 反码  1000 0001
		 * 补码  1000 0010
		 *      
		 *      
		 */
        long machineMaxSize = ~(-1L << (64 - 1 - 12)) - 1;

		System.out.println(machineMaxSize);
		System.out.println("-------------------------------------------");
		String format = String.format("%s_%d_%d", "123", 123, 456);
	    System.out.println(format);
		System.out.println("-------------------------------------------");
		System.out.println(LocalDate.now() + " " +LocalDateTime.now() );
	}
}
