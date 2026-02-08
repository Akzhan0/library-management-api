package org.example.libraryapi.patterns;

import java.time.LocalDateTime;

public final class LoggingService {

    private static final LoggingService INSTANCE = new LoggingService();

    private LoggingService() {}

    public static LoggingService getInstance() {
        return INSTANCE;
    }

    public void info(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " - " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + LocalDateTime.now() + " - " + message);
    }
}


