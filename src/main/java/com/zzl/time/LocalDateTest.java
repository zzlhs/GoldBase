package com.zzl.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;
/**
 * https://www.cnblogs.com/pinlantu/p/13376077.html
 * LocalDateTime 获取时间戳
 * @author bioknow008
 *
 */

public class LocalDateTest {

	public static void main(String[] args) {
		System.out.println(LocalDate.now().toEpochDay());
		System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
	    System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
	    System.out.println(System.currentTimeMillis());
	    
	    long start = System.currentTimeMillis();
	    
	    System.out.println(LocalDateTime.now());
	    System.out.println(LocalDate.now());
	    
	    System.out.println("start = " + start);
//	    try {
//	    	TimeUnit.SECONDS.sleep(4l);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    long end = System.currentTimeMillis();

	    System.out.println("end   = " + end);
	    System.out.println((end - start));
	    System.out.println((end - start) / 1000 % 60 );

	    //获取秒数
	    Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
	    //获取毫秒数
	    Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
	    
	    System.out.println("----------------------");
	    System.out.println(LocalDate.now());
	    System.out.println(LocalDate.now().plusDays(-1));
	    LocalDateTime today_start = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
	    LocalDateTime today_end = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);

	    System.out.println(today_start.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	    System.out.println(today_end.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	    System.out.println(today_end.toInstant(ZoneOffset.of("+8")).toEpochMilli() - today_start.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	    System.out.println(60* 60 * 24 * 1000 -1);

	    Object o = 1;
//	    System.out.println(Integer.valueOf((String) (o)) );
	    System.out.println("------------------------");
	    System.out.println(LocalDate.now().getDayOfMonth());
	    System.out.println("------------------------");
	    System.out.println(System.currentTimeMillis());
	    System.out.println();
	}

}
