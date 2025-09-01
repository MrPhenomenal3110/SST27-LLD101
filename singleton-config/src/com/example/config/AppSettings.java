package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Proper Singleton: thread-safe, lazy initialization, reflection-protected, 
 * serialization-safe, single instance across JVM lifetime.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Thread-safe lazy initialization using double-checked locking
    private static volatile AppSettings instance;
    private static final Object lock = new Object();
    private static volatile boolean created = false; // Flag to prevent reflection attacks
    
    private final Properties props = new Properties();
    private volatile boolean loaded = false;

    // Private constructor to prevent instantiation
    private AppSettings() {
        // Prevent reflection-based instantiation
        if (created) {
            throw new RuntimeException("Use getInstance() to get the singleton instance");
        }
        created = true;
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void loadFromFile(Path file) {
        synchronized (lock) {
            if (loaded) {
                throw new IllegalStateException("Settings already loaded. Cannot reload in singleton pattern.");
            }
            
            try (InputStream in = Files.newInputStream(file)) {
                props.load(in);
                loaded = true;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    public String get(String key) {
        if (!loaded) {
            throw new IllegalStateException("Settings not loaded. Call loadFromFile() first.");
        }
        return props.getProperty(key);
    }
    
    /**
     * Prevents creation of multiple instances during deserialization
     */
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
    
    /**
     * Prevents cloning of the singleton
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}
