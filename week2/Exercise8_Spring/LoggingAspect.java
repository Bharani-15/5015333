package com.Library;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.Library.LIbrary.demo2())")
    public void ExecutionMethod(){
        System.out.println(" Before: method is in execution");
    }
    @After("execution(* com.Library.LIbrary.demo2())")
    public void ExecutionMethod1(){
        System.out.println("After : method is in execution");
    }
}
