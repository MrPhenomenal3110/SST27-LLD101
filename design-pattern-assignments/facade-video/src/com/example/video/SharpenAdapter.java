package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;
    
    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }
    
    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        
        if (frames.length == 0) {
            return frames;
        }
        
        // Convert frames to a handle string (simulate frame handles)
        String framesHandle = "FRAMES:" + frames.length + ":" + frames[0].w + "x" + frames[0].h;
        
        // Apply legacy sharpen
        String newHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        // Return the same frames (in a real implementation, this would process the frames)
        // For this simulation, we just return the original frames
        return frames;
    }
}
