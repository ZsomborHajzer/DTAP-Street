package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class RedTitleStyle extends Style
{

    public RedTitleStyle()
    {
        super("Helvetica", 0, Color.red, 48, 20);
    }

    @Override
    public String getFontName()
    {
        return this.fontName;
    }

    @Override
    public int getIndent()
    {
        return this.indent;
    }

    @Override
    public Color getColor()
    {
        return this.color;
    }

    @Override
    public int getFontSize()
    {
        return this.fontSize;
    }

    @Override
    public int getVerticalMargin()
    {
        return this.verticalMargin;
    }
}
