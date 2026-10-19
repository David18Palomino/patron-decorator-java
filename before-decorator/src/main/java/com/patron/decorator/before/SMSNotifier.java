package com.patron.decorator.before;

/**
 * Notificador que envía SMS.
 */
public class SMSNotifier {
    public void send(String message) {
        System.out.println("[SMS] Enviando: " + message);
    }
}
