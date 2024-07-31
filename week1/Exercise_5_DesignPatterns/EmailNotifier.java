package com.Bharani.week1.Ex5;

public class EmailNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
