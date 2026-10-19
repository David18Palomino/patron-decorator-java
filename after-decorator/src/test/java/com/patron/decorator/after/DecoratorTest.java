package com.patron.decorator.after;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DecoratorTest {
    @Test
    public void testDecoratorChain() {
        String message = "Alerta Crítica";
        // Build chain: Email -> SMS -> Facebook
        Notifier notifier = new EmailNotifier();
        notifier = new SMSDecorator(notifier);
        notifier = new FacebookDecorator(notifier);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        notifier.send(message);
        System.setOut(original);

        String expected = "[Email] Enviando: " + message + System.lineSeparator()
                + "[SMS] Enviando: " + message + System.lineSeparator()
                + "[Facebook] Enviando: " + message;
        String actual = out.toString().trim();
        assertEquals(expected.trim(), actual);
    }
}
