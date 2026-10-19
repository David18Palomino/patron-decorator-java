package com.patron.decorator.after;

/**
 * Concrete component that sends notifications via Email.
 */
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[Email] Enviando: " + message);
    }
}
