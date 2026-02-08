package org.example.libraryapi.patterns;

public final class ApplicationConfig {

    private static final ApplicationConfig INSTANCE = new ApplicationConfig();

    private final String appName = "Library Management API";

    private ApplicationConfig() {}

    public static ApplicationConfig getInstance() {
        return INSTANCE;
    }

    public String getAppName() {
        return appName;
    }
}


