package com.Bharani.week1.Ex5;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSmsAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);
        slackSmsAndEmailNotifier.send("This is a test message.");
    }
}

