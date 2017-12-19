package com.ymm.log.dynproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//用methodInterceptor来实现方法访问的AOP
public class MethodAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		 System.out.println("--------------进入方法切面1----------------");
		 Object rs= mi.proceed();//执行被代理的方法
		 System.out.println("--------------离开方法切面1----------------");
		return rs;
	}

}
