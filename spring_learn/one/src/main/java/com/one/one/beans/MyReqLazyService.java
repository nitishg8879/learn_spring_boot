package com.one.one.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyReqLazyService {
    MyReqLazyService(){
        System.out.println("MyReqLazyService constructor called");
    }
}
