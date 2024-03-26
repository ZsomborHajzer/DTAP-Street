package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlackSubtextStyle extends Style
{

    public BlackSubtextStyle()
    {
        super("Helvetica", 70, Color.black, 30, 10);
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