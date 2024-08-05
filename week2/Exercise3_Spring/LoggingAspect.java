package com.Library;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.Library.LIbrary.demo2())")
    public void ExecutionMethod(){
        System.out.println("method is in execution");
    }
}
