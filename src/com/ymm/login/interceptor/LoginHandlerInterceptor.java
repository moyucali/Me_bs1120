package com.ymm.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Arica
 *
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	private final Logger log = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

	/**
	 * ��ҵ��������������֮ǰ������ �������false �ӵ�ǰ������������ִ��������������afterCompletion(),���˳���������
	 * �������true ִ����һ��������,ֱ�����е���������ִ����� ��ִ�б����ص�Controller Ȼ�������������,
	 * �����һ������������ִ�����е�postHandle() �����ٴ����һ������������ִ�����е�afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// �÷���ͬ��equals���Ǻ��Դ�Сд
		String urlMethod = "POST";
		if (urlMethod.equalsIgnoreCase(request.getMethod())) {
			log.info("type:" + request.getMethod());
			log.info("==============ִ��˳��: 1��preHandle================");
			String requestUri = request.getRequestURI();
			String contextPath = request.getContextPath();
			String url = requestUri.substring(contextPath.length());
			String host = request.getRemoteHost();
			log.info("requestUri:" + requestUri);
			log.info("contextPath:" + contextPath);
			log.info("url:" + url);
			log.info("IPΪ---->>> " + host + " <<<-----������ϵͳ");
			String loginUrl = "login";
			if (requestUri.contains(loginUrl)) {
				log.info("LoginHandlerInterceptor����֤ͨ������ת��login��");
				return true;
			} else {
				log.info("LoginHandlerInterceptor����֤ʧ�ܣ���ת��errorҳ�棡");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ��� ����modelAndView�м������ݣ����統ǰʱ��
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("==============ִ��˳��: 2��postHandle================");
		if (modelAndView != null) {
			// ���뵱ǰʱ��
			modelAndView.addObject("var", "����postHandle");
		}
	}

	/**
	 * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��
	 * 
	 * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("==============ִ��˳��: 3��afterCompletion================");
	}

}
