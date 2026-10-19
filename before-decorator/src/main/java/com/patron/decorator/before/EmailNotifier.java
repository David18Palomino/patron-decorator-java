package com.patron.decorator.before;

/**
 * Notificador base que envía correo electrónico.
 */
public class EmailNotifier {
    public void send(String message) {
        System.out.println("[Email] Enviando: " + message);
    }
}
