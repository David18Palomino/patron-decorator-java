package com.patron.decorator.before;

/**
 * Notificador que combina Email, SMS y Facebook.
 */
public class EmailSMSAndFacebookNotifier extends EmailNotifier {
    private final SMSNotifier smsNotifier = new SMSNotifier();
    private final FacebookNotifier facebookNotifier = new FacebookNotifier();

    @Override
    public void send(String message) {
        super.send(message); // enviar Email
        smsNotifier.send(message); // enviar SMS
        facebookNotifier.send(message); // enviar Facebook
    }
}
