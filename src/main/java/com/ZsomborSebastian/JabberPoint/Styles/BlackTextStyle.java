package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlackTextStyle extends Style
{

    public BlackTextStyle()
    {
        super("Helvetica", 90, Color.black, 24, 10);
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
