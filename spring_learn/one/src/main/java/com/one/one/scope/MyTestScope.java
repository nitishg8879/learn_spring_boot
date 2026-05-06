package com.one.one.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyTestScope {

}

@Component
@Scope("singleton") // default
class MyService {
    MyService() {
        System.out.println("MyService constructor called");
    }
}

@Component
@Scope("prototype") // every time create a new instance
class MyService2 {
    MyService2() {
        System.out.println("MyService2 constructor called");
    }
}

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // it will create a proxy of this class and inject
                                                                    // it where ever it is required and when ever we
                                                                    // call any method of this class it will create a
                                                                    // new instance of this class for each request
class MyService3 {
    MyService3() {
        System.out.println("MyService3 constructor called");
    }
}

@Component
@Scope(value = "session")
class MyService4 {
    MyService4() {
        System.out.println("MyService4 constructor called");
    }
}

@Component
@Scope(value = "application") // it will create a single instance of this class for the entire application and
                              // it will be shared across all the
                              // requests and sessions
class MyService5 {
    MyService5() {
        System.out.println("MyService5 constructor called");
    }
}
