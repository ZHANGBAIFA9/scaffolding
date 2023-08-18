package com.afiab.scaffolding.server.config;

import com.afiab.scaffolding.server.handler.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:02
 * @Description:
 */
@Slf4j
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private LoginInterceptor loginInterceptor ;

    public WebMvcConfigurer(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("--WebMvcConfigurer--addInterceptors");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/css/**",
                        "/images/**",
                        "/res/**",
                        "/page/**",
                        "/swagger*/**",
                        "/error/**",
                        "/druid/**");
        super.addInterceptors(registry);
    }
}
