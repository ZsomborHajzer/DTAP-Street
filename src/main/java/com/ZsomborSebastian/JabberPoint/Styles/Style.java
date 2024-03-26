package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public abstract class Style
{
    protected String fontName;
    protected int indent;
    protected Color color;
    protected int fontSize;
    protected int verticalMargin;

    // Constructor
    public Style(String fontName, int indent, Color color, int fontSize, int verticalMargin) {
        this.fontName = fontName;
        this.indent = indent;
        this.color = color;
        this.fontSize = fontSize;
        this.verticalMargin = verticalMargin;
    }

    // Getter methods
    public abstract String getFontName();

    public abstract int getIndent();

    public abstract Color getColor();

    public abstract int getFontSize();

    public abstract int getVerticalMargin();

}
