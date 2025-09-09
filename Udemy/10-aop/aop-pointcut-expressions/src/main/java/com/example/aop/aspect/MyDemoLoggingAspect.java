package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with a @Before advice

    // Run this code BEFORE - target object method: "public void addAccount()"
    // @Before("execution(public void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* add*(com.example.aop.Account, ..))")
    @Before("execution(* com.example.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");
    }
}
