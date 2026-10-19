package com.patron.decorator.after;

/**
 * Component interface for the notification system.
 */
public interface Notifier {
    /**
     * Sends a notification using the concrete implementation.
     *
     * @param message the message to be sent
     */
    void send(String message);
}
