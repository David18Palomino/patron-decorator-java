package com.patron.decorator.before;

/**
 * Notificador que combina SMS y Facebook.
 */
public class SMSAndFacebookNotifier extends SMSNotifier {
    private final FacebookNotifier facebookNotifier = new FacebookNotifier();

    @Override
    public void send(String message) {
        super.send(message); // enviar SMS
        facebookNotifier.send(message); // enviar por Facebook
    }
}
