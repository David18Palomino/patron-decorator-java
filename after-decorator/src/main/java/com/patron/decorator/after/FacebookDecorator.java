package com.patron.decorator.after;

/**
 * Concrete decorator that adds Facebook sending behaviour.
 */
public class FacebookDecorator extends NotifierDecorator {
    public FacebookDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        // delegate first
        super.send(message);
        // then add Facebook behaviour
        sendFacebook(message);
    }

    private void sendFacebook(String message) {
        System.out.println("[Facebook] Enviando: " + message);
    }
}
