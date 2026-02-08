package org.example.libraryapi.patterns;

public final class DatabaseConfigManager {

    private static final DatabaseConfigManager INSTANCE = new DatabaseConfigManager();

    private String url;
    private String username;

    private DatabaseConfigManager() {}

    public static DatabaseConfigManager getInstance() {
        return INSTANCE;
    }

    // Инициализируем один раз
    public void init(String url, String username) {
        if (this.url == null && this.username == null) {
            this.url = url;
            this.username = username;
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
}

