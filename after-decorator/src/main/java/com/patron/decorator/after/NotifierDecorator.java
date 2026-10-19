package com.patron.decorator.after;

/**
 * Abstract decorator that forwards calls to the wrapped Notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    /** Wrapped notifier (component) */
    protected final Notifier wrappee;

    protected NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        // Base delegation – concrete decorators may add behavior before or after this call.
        if (wrappee != null) {
            wrappee.send(message);
        }
    }
}
