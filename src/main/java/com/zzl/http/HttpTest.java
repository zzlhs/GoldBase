package com.zzl.http;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import com.alibaba.fastjson.JSONObject;

public class HttpTest {
	
	ExecutorService cachedPool =  Executors.newFixedThreadPool(20);
	
	public static void main(String[] args) {
//		httpGet("http://localhost:8080/user/get?id=2", null);
		new HttpTest().thread();
		
		
	}
	
	public void thread() {
		
		for(int i = 0; i< 10000;i++) {
			cachedPool.execute(new Runnable() {
				@Override
				public void run() {
					httpGet("http://localhost:8080/user/get?id=2", null, Thread.currentThread().getName());
				}
			});
		}
		
	}
	
	
	public void httpGet(String url, String param, String flag) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpGet httpGet = new HttpGet(url);
		
		RequestConfig requestConfig = RequestConfig.custom()
										.setSocketTimeout(2000)
										.setConnectTimeout(2000)
										.build();
		httpGet.setConfig(requestConfig);
		
//		if(!StringUtils.isEmpty(param)) {
//			StringEntity entity = new StringEntity(param, "utf-8");
//			entity.setContentEncoding("utf-8");
//			entity.setContentType("application/x-www-form-urlencoded");
//			httpGet.setc
//		}
		try {
			CloseableHttpResponse resp = httpClient.execute(httpGet);
			   if (resp.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
	                String str;
	                try {
	                    //读取服务器返回过来的json字符串数据
	                    str = EntityUtils.toString(resp.getEntity(), "utf-8");
	                    if(str.contains("成功"))
	                    	System.out.println(flag +" "+ System.currentTimeMillis() + " ---->>>" + str);
	                } catch (Exception e) {
	 
	                }
			   }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			httpGet.releaseConnection();
		}
		
	}
}
