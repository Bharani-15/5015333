package com.Bharani.week1;

public class logger {
    private static volatile logger instance;

    private logger(){}
    public static logger getInstance(){
        logger result=instance;
        if(result==instance){
            synchronized (logger.class){
                result=instance;
                if(result==null){
                    instance=new logger();
                }
            }
        }
        return instance;
    }

    public void log(String msg){
        System.out.println("message : "+msg);
    }
}
