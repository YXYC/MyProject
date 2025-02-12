package com.example.patientmange.interceptor;


import com.example.patientmange.utils.JwtCreate;
import com.example.patientmange.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    //创建登录身份校验拦截器
    @Override  //请求开始前触发的拦截方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行CORS预检请求（OPTIONS请求）
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //令牌验证
        String token = request.getHeader("Authorization");
        System.out.println(request.getDateHeader("data"));
        try {
            Map<String, Object> claims = JwtCreate.getClaimsByToken(token);
            //把用户信息存储到ThreadLocal中,tomcat会在每次接口请求时创建一个线程
            //而ThreadLocal中存储的数据是线程安全的
            ThreadLocalUtil.set(claims);
            //放行
            return true;

        } catch (Exception e) {
            System.out.println(request.getHeader("Authorization"));
            //设置响应状态码
            response.setStatus(401);
            //设置响应字符集和响应内容
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            String errorMessage = "未登录";
            response.getWriter().write("{\"error\": \"" + errorMessage + "\"}");
            //不放行
            return false;
        }
    }

    @Override  //请求完成后触发的拦截方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据防止内存泄漏
        ThreadLocalUtil.remove();
    }
}
