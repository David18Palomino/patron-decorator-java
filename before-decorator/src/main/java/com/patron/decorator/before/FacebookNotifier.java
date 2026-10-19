package com.patron.decorator.before;

/**
 * Notificador que envía notificaciones a Facebook.
 */
public class FacebookNotifier {
    public void send(String message) {
        System.out.println("[Facebook] Enviando: " + message);
    }
}
