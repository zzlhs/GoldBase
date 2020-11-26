package com.zzl.spi;

import java.util.HashMap;
import java.util.Map;

public class ServiceProviderInterface {
	
	public static void main(String[] args) {
//		ServiceLoader<Add>
		/*
		 * BootStrap ClassLoader 顶级层次的类加载器
		 */
		System.out.println(System.getProperty("sun.boot.class.path"));
		
		/*
		 * ExtClassLoader 负责加载java的扩展类库
		 */
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "one");
        System.out.println(map.get("1"));
        String str = map.getOrDefault("", map.getOrDefault("2", "two"));
        System.out.println(str);
	}
}
