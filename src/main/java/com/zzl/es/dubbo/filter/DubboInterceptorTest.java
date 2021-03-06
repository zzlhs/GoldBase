package com.zzl.es.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import lombok.extern.slf4j.Slf4j;

@Activate(group = {Constants.PROVIDER, Constants.CONSUMER })
@Slf4j
public class DubboInterceptorTest implements Filter{

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		log.info("{}...", "服务提供方调用");
		return invoker.invoke(invocation);
	}

}
