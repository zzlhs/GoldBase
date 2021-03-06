package com.zzl.es.dubbo.filter;

import java.util.List;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;

public class Test {
	public static void main(String[] args) {
		ExtensionLoader<Filter> loader = ExtensionLoader.getExtensionLoader(Filter.class);
		  URL url = new URL("", "", 0);
	        // 在url中添加cache参数
	        url = url.addParameter("cache", "cache");
	        List<Filter> filters = loader.getActivateExtension(url, "cache");
	        for(Filter filter: filters) {
		        System.out.println(filter);
	        }
	}
}
