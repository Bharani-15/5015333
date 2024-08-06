package com.Library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        LIbrary lib=context.getBean(LIbrary.class);
        lib.demo2();
    }
}