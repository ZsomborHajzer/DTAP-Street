package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class RedTitleStyle extends Style
{

    public RedTitleStyle()
    {
        super("Helvetica", 0, Color.red, 48, 20);
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
