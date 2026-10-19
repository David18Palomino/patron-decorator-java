package com.patron.decorator.after;

/**
 * Demo program that composes notifiers using the Decorator pattern.
 */
public class Main {
    public static void main(String[] args) {
        // Stack decorators: Email -> SMS -> Facebook
        Notifier notifier = new FacebookDecorator(
                new SMSDecorator(
                        new EmailNotifier()
                )
        );
        notifier.send("Alerta Crítica");
    }
}
