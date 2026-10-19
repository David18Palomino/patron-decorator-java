package com.patron.decorator.before;

/**
 * Notificador que combina Email y Facebook.
 */
public class EmailAndFacebookNotifier extends EmailNotifier {
    private final FacebookNotifier facebookNotifier = new FacebookNotifier();

    @Override
    public void send(String message) {
        super.send(message); // enviar email
        facebookNotifier.send(message); // enviar por Facebook
    }
}
