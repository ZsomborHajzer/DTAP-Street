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
