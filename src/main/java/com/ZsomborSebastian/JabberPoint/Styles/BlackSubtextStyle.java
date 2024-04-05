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
