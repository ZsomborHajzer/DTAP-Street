package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlackSubheadingStyleTest
{
    private BlackSubheadingStyle blackSubheadingStyle;

    @BeforeEach
    public void setUp()
    {
        blackSubheadingStyle = new BlackSubheadingStyle();
    }

    @Test
    void getFontName()
    {
        assertEquals("Helvetica", blackSubheadingStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent()
    {
        assertEquals(50, blackSubheadingStyle.getIndent(), "Indent should be 50.");
    }

    @Test
    void getColor()
    {
        assertEquals(Color.black, blackSubheadingStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize()
    {
        assertEquals(30, blackSubheadingStyle.getFontSize(), "Font size should be 30.");
    }

    @Test
    void getVerticalMargin()
    {
        assertEquals(10, blackSubheadingStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }

    @Test
    void getFont_ScaleEqualsOne_BaseFontValues()
    {
        Font font = blackSubheadingStyle.getFont(1);
        assertEquals(30, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_DoubleFontSize()
    {
        Font font = blackSubheadingStyle.getFont(2);
        assertEquals(60, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsZero_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubheadingStyle.getFont(0));
    }

    @Test
    void getFont_NegativeNumberScale_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubheadingStyle.getFont(-4));
    }
}