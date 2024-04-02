package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlackSubtextStyle extends Style
{

    public BlackSubtextStyle()
    {
        super("Helvetica", 70, Color.black, 30, 10);
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
