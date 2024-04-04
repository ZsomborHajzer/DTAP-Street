package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlackSubheadingStyle extends Style
{

    public BlackSubheadingStyle()
    {
        super("Helvetica", 50, Color.black, 30, 10);
    }

    @Override
    public Font getFont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }

    @Override
    public Font generateFont(int fontSize)
    {
        return new Font(fontName, Font.BOLD, fontSize);
    }
}
