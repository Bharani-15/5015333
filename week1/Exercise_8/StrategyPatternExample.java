package com.Bharani.week1.Ex8;

public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create payment context
        PaymentContext paymentContext = new PaymentContext();

        // Set credit card payment strategy and execute payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/24");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(250.75);

        // Set PayPal payment strategy and execute payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(89.50);
    }
}

