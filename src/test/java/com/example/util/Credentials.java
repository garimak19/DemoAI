package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Credentials {
    private final Map<String, String> credentials = new HashMap<>();

    public Credentials(String propertiesFile) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new RuntimeException(propertiesFile + " not found");
            }
            Properties props = new Properties();
            props.load(input);
            for (String key : props.stringPropertyNames()) {
                credentials.put(key, props.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + propertiesFile, e);
        }
    }

    public String getPassword(String username) {
        return credentials.get(username);
    }

    public boolean isValid(String username, String password) {
        return password != null && password.equals(credentials.get(username));
    }

    public Map<String, String> getAll() {
        return new HashMap<>(credentials);
    }
}