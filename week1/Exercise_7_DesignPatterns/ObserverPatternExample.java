package com.Bharani.week1.Ex7;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL");
        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp = new WebApp("WebApp");
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp);
        stockMarket.setStockPrice(150.00);
        stockMarket.deregisterObserver(mobileApp2);
        stockMarket.setStockPrice(155.00);
    }
}

