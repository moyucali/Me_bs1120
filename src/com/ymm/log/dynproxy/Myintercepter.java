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
	// 声明一个切入点
	private void anyMethod() {
	}

	@Before("anyMethod() && args(obj)") // 定义前置通知,拦截的方法不但要满足声明的切入点的条件,而且要有一个Object类型的输入参数,否则不会拦截
	public void doAccessCheck(Object obj) {
		System.out.println("=====前置通知开始=====:" + obj.toString());
	}

	@AfterReturning(pointcut = "anyMethod()", returning = "result") // 定义后置通知,拦截的方法的返回值必须是int类型的才能拦截
	public void doAfterReturning(int result) {
		System.out.println("=====后置通知开始=====:" + result);
	}

	@AfterThrowing(pointcut = "anyMethod()", throwing = "e") // 定义例外通知
	public void doAfterThrowing(Exception e) {
		System.out.println("=====异常通知开始=====");
		System.out.println("异常代码:" + e.getClass().getName());
		System.out.println("异常信息:" + e.getMessage());
		System.out.println("例外通知:" + e);
		System.out.println("=====异常通知结束=====");
	}

	@After("anyMethod()") // 定义最终通知
	public void doAfter() {
		// System.out.println("=====最终通知=====");
	}

	@Around("anyMethod()") // 定义环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		//System.out.println("输出session:" + session.getId());
		// if(){//判断用户是否在权限
		System.out.println("进入方法：" + pjp.getSignature().getName());
		//日志存储
		String uname=(String) session.getAttribute("uname");
		if(uname==null) {
			uname="SYSTEM："+session.getId();}
		log.in(uname,pjp.getSignature().getName());
		//结束
		Object result = pjp.proceed();// 当使用环绕通知时，这个方法必须调用，否则拦截到的方法就不会再执行了
		System.out.println("退出方法：");
		// }
		return result;
	}

}