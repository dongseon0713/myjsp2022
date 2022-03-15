/*    */ package com.project.util;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*    */ 
/*    */ public class LoginInterceptor extends HandlerInterceptorAdapter
/*    */ {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 15 */     HttpSession session = request.getSession();
/*    */ 
/* 17 */     String user_id = (String)session.getAttribute("user_id");
/* 18 */     if (user_id == null) {
/* 19 */       response.sendRedirect("/member/login");
/* 20 */       return false;
/*    */     }
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ 
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {
/* 32 */     super.postHandle(request, response, handler, modelAndView);
/*    */   }
/*    */ 
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*    */     throws Exception
/*    */   {
/* 39 */     super.afterCompletion(request, response, handler, ex);
/*    */   }
/*    */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.project.util.LoginInterceptor
 * JD-Core Version:    0.6.2
 */