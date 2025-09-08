package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Objects;

public class TextStyleFactory {
    private static final TextStyleFactory INSTANCE = new TextStyleFactory();
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();
    
    private TextStyleFactory() {}
    
    public static TextStyleFactory getInstance() {
        return INSTANCE;
    }
    
    public TextStyle getTextStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        
        // Create key as suggested in hints: "Inter|14|B"
        String key = font + "|" + size + "|" + (bold ? "B" : "N");
        
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
