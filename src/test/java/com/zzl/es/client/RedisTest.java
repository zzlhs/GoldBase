package com.zzl.es.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import net.sf.json.JSONArray;



@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
//	private RedisTemplate< , V>
	
	private static String key = "zyf";
	
	private static String keyType = "zyf_type";
	
	private static String keyType2 = "zyf_type_2";


	
	@Test
	public void m1() {
		
		Object object =stringRedisTemplate.opsForHash()
				.get("medai_web_code_img", "targets");
		System.out.println(object);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imgUrl", "https://medai.oss-cn-qingdao.aliyuncs.com/imgFolder/imgverification/17921cc5-48ba-4a6b-8cee-b5cb57eff291.png");
		map.put("type", "");
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		System.out.println(map);
		System.out.println(list.toString());
		try {
			stringRedisTemplate.opsForHash().put(key, keyType, list.toString());
		
		
		Object value = stringRedisTemplate.opsForHash().get(key, keyType);
		System.out.println(value);
		
		System.out.println(new JSONObject(map));
		System.out.println("------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		stringRedisTemplate.setHashKeySerializer(new Jackson2JsonRedisSerializer<Map>(Map.class));
//		stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Map>(Map.class));
//
//		List<Map<String, Object>> jsonArray = new ArrayList<Map<String,Object>>();
//		jsonObject.put("imgUrl", "https://medai.oss-cn-qingdao.aliyuncs.com/imgFolder/imgverification/17921cc5-48ba-4a6b-8cee-b5cb57eff291.png");
//		jsonObject.put("type", "");
//		jsonArray.add(map);
//		System.out.println(jsonArray.toString());
//		try {
//			stringRedisTemplate.opsForHash().put(key, keyType2, jsonArray.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
