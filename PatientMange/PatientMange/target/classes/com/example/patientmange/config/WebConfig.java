package com.example.patientmange.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.patientmange.interceptor.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //进入user路径下的所有请求前进入该拦截器
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/findUserByUsernamePass","/registerUser");//排除登录和注册路由
    }

    @Override
//    设置拦截
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081","null")  // 请求来源
                .allowedMethods("GET","POST","DELETE","PUT","OPTIONS")  // 方法
                .allowCredentials(true)  // 允许携带参数
                .maxAge(3600);  // 最大响应时间
    }
}
