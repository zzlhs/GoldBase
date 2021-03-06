package com.zzl.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@EnableDubboConfiguration
@SpringBootApplication
public class GoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldApplication.class, args);
	}
}
