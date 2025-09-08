package com.example.render;

public class Glyph {
    private final char ch;  // extrinsic state
    private final TextStyle style;  // intrinsic state (shared)

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public int drawCost() { return style.getSize() + (style.isBold() ? 10 : 0); }
    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
}
