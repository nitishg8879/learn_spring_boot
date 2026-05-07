package com.AOP.aopTest;

import java.nio.file.DirectoryStream.Filter;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.AOP.aopTest.filters.MyAppFilter;
import com.AOP.aopTest.interceptor.MyCustomInterceptor;

@Configuration
public class MyAppConfiguration implements WebMvcConfigurer {
    @Autowired
    MyCustomInterceptor myCustomInterceptor;

    @Bean("taskPoolExecutor")
    public Executor taskPoolExecutor() {
        int corePoolSize = 2;
        int maxPoolSize = 5;
        int queueCapacity = 10;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("MyThread-");
        executor.initialize();
        return executor;
    }

    // @Bean
    // MyAppFilter myAppFilter() {
    //     FilterRegistrationBean<MyAppFilter> registrationBean = new FilterRegistrationBean<>();
    //     registrationBean.setFilter(new MyAppFilter());
    //     registrationBean.addUrlPatterns("/*");
    //     return registrationBean.getFilter();
    // }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(myCustomInterceptor).addPathPatterns(
    //             "/*").excludePathPatterns("/*");
    // }

}
