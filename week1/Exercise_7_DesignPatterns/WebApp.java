package com.Bharani.week1.Ex7;

public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App " + name + ": Stock " + stockName + " is now " + stockPrice);
    }
}

