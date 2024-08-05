package com.Library;

import com.Library.repository.BookRepository;
import com.Library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository book=context.getBean(BookRepository.class);
        BookService book1=context.getBean(BookService.class);
        book1.demo1();
        book.demo();
    }
}