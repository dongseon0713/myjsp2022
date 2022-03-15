package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//1. 스프링에서 제공하는 HandlerInterceptorAdaptor 클레스를 상속
	//2. alt + shift + s => overriding method를 통해서 3가지 메서드 오버라이딩 처리
	
	//preHandle 메서드는 컨트롤러를 실행하기 전 요청을 가로채서 처리함.
	//일반적으로 , 세션 처리에 사용된다.
	//preHandle에서 세션 처리를 했다면, 스프링 설정 파일에 <Interceptors> 태그를 사용하여 맵핑 설정을 합니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			response.sendRedirect("/session/loginPage");
			return false;
			//return false의 의미는 핸들러 메서드를 실행한 후 Controller를 수행하지 않음.
		}else {
			return true;
			//return true의 의미는 핸들러 메서드를 실행한 후 Controller를 수행
		}
	}

	//preHandle에서 true를 리턴하여 컨트롤러를 실행할 때만 동작합니다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("동작했어요?");
		//super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
}