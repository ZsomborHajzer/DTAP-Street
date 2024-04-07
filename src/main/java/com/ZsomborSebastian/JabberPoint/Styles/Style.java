package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public abstract class Style
{
    protected String fontName;
    protected int indent;
    protected Color color;
    protected int fontSize;
    protected int verticalMargin;

    protected Font font;

    // Constructor
    public Style(String fontName, int indent, Color color, int fontSize, int verticalMargin)
    {
        this.fontName = fontName;
        this.indent = indent;
        this.color = color;
        this.fontSize = fontSize;
        this.verticalMargin = verticalMargin;
        this.font = generateFont(fontSize);
    }

    // Getter methods

    public String getFontName()
    {
        return this.fontName;
    }


    public int getIndent()
    {
        return this.indent;
    }


    public Color getColor()
    {
        return this.color;
    }


    public int getFontSize()
    {
        return this.fontSize;
    }


    public int getVerticalMargin()
    {
        return this.verticalMargin;
    }

    public abstract Font getFont(float scale);

    public abstract Font generateFont(int fontSize);
}
