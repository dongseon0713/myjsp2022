package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//1. ���������� �����ϴ� HandlerInterceptorAdaptor Ŭ������ ���
	//2. alt + shift + s => overriding method�� ���ؼ� 3���� �޼��� �������̵� ó��
	
	//preHandle �޼���� ��Ʈ�ѷ��� �����ϱ� �� ��û�� ����ä�� ó����.
	//�Ϲ������� , ���� ó���� ���ȴ�.
	//preHandle���� ���� ó���� �ߴٸ�, ������ ���� ���Ͽ� <Interceptors> �±׸� ����Ͽ� ���� ������ �մϴ�.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			response.sendRedirect("/session/loginPage");
			return false;
			//return false�� �ǹ̴� �ڵ鷯 �޼��带 ������ �� Controller�� �������� ����.
		}else {
			return true;
			//return true�� �ǹ̴� �ڵ鷯 �޼��带 ������ �� Controller�� ����
		}
	}

	//preHandle���� true�� �����Ͽ� ��Ʈ�ѷ��� ������ ���� �����մϴ�.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("�����߾��?");
		//super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
}
