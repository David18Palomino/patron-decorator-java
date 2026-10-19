package com.patron.decorator.before;

/**
 * Notificador que combina Email y SMS.
 */
public class EmailAndSMSNotifier extends EmailNotifier {
    private final SMSNotifier smsNotifier = new SMSNotifier();

    @Override
    public void send(String message) {
        super.send(message); // send email
        smsNotifier.send(message); // send SMS
    }
}
