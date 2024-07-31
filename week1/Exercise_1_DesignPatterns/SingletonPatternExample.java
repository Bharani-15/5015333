package com.Bharani.week1;

public class SingletonPatternExample {
    public static void main(String[] args) {
        logger logger1=logger.getInstance();
        logger logger2=logger.getInstance();
        if(logger1==logger2){
            System.out.println("same instance");
        }else{
            System.out.println("different instances");
        }

    }
}
