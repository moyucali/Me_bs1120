package com.ymm.log.dynproxy;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.ymm.log.util.LogUtil;
import com.ymm.user.entity.User;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class Myintercepter {
	@Autowired
	LogUtil log;
	@Pointcut("execution(* com.ymm.*.service.*.*(..))")
	// ����һ�������
	private void anyMethod() {
	}

	@Before("anyMethod() && args(obj)") // ����ǰ��֪ͨ,���صķ�������Ҫ��������������������,����Ҫ��һ��Object���͵��������,���򲻻�����
	public void doAccessCheck(Object obj) {
		System.out.println("=====ǰ��֪ͨ��ʼ=====:" + obj.toString());
	}

	@AfterReturning(pointcut = "anyMethod()", returning = "result") // �������֪ͨ,���صķ����ķ���ֵ������int���͵Ĳ�������
	public void doAfterReturning(int result) {
		System.out.println("=====����֪ͨ��ʼ=====:" + result);
	}

	@AfterThrowing(pointcut = "anyMethod()", throwing = "e") // ��������֪ͨ
	public void doAfterThrowing(Exception e) {
		System.out.println("=====�쳣֪ͨ��ʼ=====");
		System.out.println("�쳣����:" + e.getClass().getName());
		System.out.println("�쳣��Ϣ:" + e.getMessage());
		System.out.println("����֪ͨ:" + e);
		System.out.println("=====�쳣֪ͨ����=====");
	}

	@After("anyMethod()") // ��������֪ͨ
	public void doAfter() {
		// System.out.println("=====����֪ͨ=====");
	}

	@Around("anyMethod()") // ���廷��֪ͨ
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		//System.out.println("���session:" + session.getId());
		// if(){//�ж��û��Ƿ���Ȩ��
		System.out.println("���뷽����" + pjp.getSignature().getName());
		//��־�洢
		String uname=(String) session.getAttribute("uname");
		if(uname==null) {
			uname="SYSTEM��"+session.getId();}
		log.in(uname,pjp.getSignature().getName());
		//����
		Object result = pjp.proceed();// ��ʹ�û���֪ͨʱ���������������ã��������ص��ķ����Ͳ�����ִ����
		System.out.println("�˳�������");
		// }
		return result;
	}

}