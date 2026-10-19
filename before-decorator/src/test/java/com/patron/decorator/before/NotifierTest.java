package com.patron.decorator.before;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotifierTest {
    @Test
    public void testAllNotifiers() {
        String message = "Alerta Crítica";
        String[][] cases = {
            {"EmailNotifier", "[Email] Enviando: " + message},
            {"SMSNotifier", "[SMS] Enviando: " + message},
            {"FacebookNotifier", "[Facebook] Enviando: " + message},
            {"EmailAndSMSNotifier", "[Email] Enviando: " + message + System.lineSeparator() + "[SMS] Enviando: " + message},
            {"EmailAndFacebookNotifier", "[Email] Enviando: " + message + System.lineSeparator() + "[Facebook] Enviando: " + message},
            {"SMSAndFacebookNotifier", "[SMS] Enviando: " + message + System.lineSeparator() + "[Facebook] Enviando: " + message},
            {"EmailSMSAndFacebookNotifier", "[Email] Enviando: " + message + System.lineSeparator() + "[SMS] Enviando: " + message + System.lineSeparator() + "[Facebook] Enviando: " + message}
        };
        for (String[] c : cases) {
            String className = "com.patron.decorator.before." + c[0];
            try {
                Class<?> clazz = Class.forName(className);
                Object instance = clazz.getDeclaredConstructor().newInstance();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                System.setOut(new PrintStream(out));
                clazz.getMethod("send", String.class).invoke(instance, message);
                System.setOut(originalOut);
                String output = out.toString().trim();
                assertEquals(c[1].trim(), output);
            } catch (Exception e) {
                fail("Exception for " + className + ": " + e);
            }
        }
    }
}
