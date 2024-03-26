package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlackTextStyle extends Style
{

    public BlackTextStyle()
    {
        super("Helvetica", 90, Color.black, 24, 10);
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
