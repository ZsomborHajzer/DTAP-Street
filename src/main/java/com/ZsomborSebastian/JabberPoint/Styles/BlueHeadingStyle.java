package com.ZsomborSebastian.JabberPoint.Styles;

import java.awt.*;

public class BlueHeadingStyle extends Style
{

    public BlueHeadingStyle()
    {
        super("Helvetica", 20, Color.blue, 40, 10);
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
