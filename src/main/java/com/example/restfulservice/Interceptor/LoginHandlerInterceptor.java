package com.example.restfulservice.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author corn
 * @version 1.0.0
 */

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor{
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object user = httpServletRequest.getSession().getAttribute("loginUser");
        if(user == null) {
            // 未登录页面
            httpServletRequest.setAttribute("msg", "没有权限，请先登录");
            httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest, httpServletResponse);
            return false;
        } else {
            // 已登录，放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
