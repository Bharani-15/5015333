package com.Library;

import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    private String a;
    @Override
    public String toString() {
        return " And BookRepository";
    }

    public void demo(){
        System.out.println("BookRepository");
    }
}
