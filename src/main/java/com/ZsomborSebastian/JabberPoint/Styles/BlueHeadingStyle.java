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
        if (scale <= 0) {
            throw new IllegalArgumentException("Scale can't be less or equal to 0");
        }
        return font.deriveFont(fontSize * scale);
    }

    @Override
    public Font generateFont(int fontSize)
    {
        if (fontSize <= 0) {
            throw new IllegalArgumentException("Font can't be less or equal to 0");
        }
        return new Font(fontName, Font.BOLD, fontSize);
    }
}
