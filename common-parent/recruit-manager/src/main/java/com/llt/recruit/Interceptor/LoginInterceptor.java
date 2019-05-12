package com.llt.recruit.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        //如果是登录页面则放行
        String URI = request.getRequestURI();
        if(URI.contains("login.do") || URI.contains("register.do") || URI.contains("/js") || URI.contains("/css")
                || URI.contains("/layui") || URI.contains("404") || URI.contains("index.do") || URI.contains("toRegister.do")
        ||URI.contains("checkCode.do") || URI.contains("find.do") || URI.contains("sendFindPasswordEmail.do")
        ||URI.contains("findPassword.do")  ||URI.contains("toFindPassword.do") || URI.contains("toActive.do") || URI.contains("active")){
            return true;
        }
        HttpSession session = request.getSession();
        //如果用户已登录也放行
        if(session.getAttribute("user")!=null){
            return true;
        }
        //用户没有登录挑战到登录页面
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

        return false;
    }
}
