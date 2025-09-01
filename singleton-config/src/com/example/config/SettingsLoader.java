package com.example.config;

import java.nio.file.Path;

/** Singleton-aware wrapper that uses the proper singleton instance. */
public class SettingsLoader {
    public AppSettings load(Path file) {
        AppSettings settings = AppSettings.getInstance(); // Use singleton
        settings.loadFromFile(file);
        return settings;
    }
}
