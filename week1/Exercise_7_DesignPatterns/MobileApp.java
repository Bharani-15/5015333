package com.Bharani.week1.Ex7;

public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App " + name + ": Stock " + stockName + " is now " + stockPrice);
    }
}

