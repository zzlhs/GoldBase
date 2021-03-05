package com.zzl.es.dubbo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = TestDubboService.class, timeout = 100000, delay = -1, retries = -1)
@Component
public class TestDubboServiceImpl implements TestDubboService {

	@Override
	public Map<String, Object> applyDubbo(Integer caseId) throws Exception {
		System.out.println("dubbo服务调用...");
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("code", 200);
		resMap.put("message", "dubbo服务测试成功");
		return resMap;
	}

}
