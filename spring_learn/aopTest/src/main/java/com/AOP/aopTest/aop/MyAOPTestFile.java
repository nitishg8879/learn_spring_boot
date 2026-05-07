package com.AOP.aopTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOPTestFile {

    @Before("execution(* com.AOP.aopTest.controllers.AopTestController.beforeTest(..))")
    public void beforeAdvice() {
        System.out.println("Before advice executed");
    }

    @After("execution(* com.AOP.aopTest.controllers.AopTestController.afterTest(..))")
    public void afterAdvice() {
        System.out.println("After advice executed");
    }

    @Around("execution(* com.AOP.aopTest.controllers.AopTestController.aroundTest(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice - before method execution");
        Object result = joinPoint.proceed(); // Proceed with the original method execution
        System.out.println("Around advice - after method execution");
        return result;
    }

}
