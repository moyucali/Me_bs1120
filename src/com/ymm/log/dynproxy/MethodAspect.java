package com.ymm.log.dynproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//��methodInterceptor��ʵ�ַ������ʵ�AOP
public class MethodAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		 System.out.println("--------------���뷽������1----------------");
		 Object rs= mi.proceed();//ִ�б�����ķ���
		 System.out.println("--------------�뿪��������1----------------");
		return rs;
	}

}
