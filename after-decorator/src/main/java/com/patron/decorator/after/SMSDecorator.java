package com.patron.decorator.after;

/**
 * Concrete decorator that adds SMS sending behaviour.
 */
public class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        // first delegate to wrapped notifier (could be Email, another decorator, etc.)
        super.send(message);
        // then add SMS behaviour
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("[SMS] Enviando: " + message);
    }
}
