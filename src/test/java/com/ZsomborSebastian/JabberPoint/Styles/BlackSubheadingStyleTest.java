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
    void getFontName_CallMethod_ExpectHelvetica()
    {
        assertEquals("Helvetica", blackSubheadingStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent_CallMethod_ExpectFontSize()
    {
        assertEquals(50, blackSubheadingStyle.getIndent(), "Indent should be 50.");
    }

    @Test
    void getColor_CallMethod_ExpectCorrectColor()
    {
        assertEquals(Color.black, blackSubheadingStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize_CallMethod_ExpectCorrectFontSize()
    {
        assertEquals(30, blackSubheadingStyle.getFontSize(), "Font size should be 30.");
    }

    @Test
    void getVerticalMargin_CallMethod_ExpectCorrectVerticalMargin()
    {
        assertEquals(10, blackSubheadingStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }

    @Test
    void getFont_ScaleEqualsOne_ExpectBaseFontSize()
    {
        Font font = blackSubheadingStyle.getFont(1);
        assertEquals(30, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_ExpectDoubleFontSize()
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

    @Test
    void generateFont_FontSizeIsPositive_ExpectFontSizeInput()
    {
        Font font = blackSubheadingStyle.generateFont(10);
        assertEquals(10, font.getSize());
    }

    @Test
    void generateFont_FontSizeIs0_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubheadingStyle.generateFont(0));
    }

    @Test
    void generateFont_FontSizeIsNegative_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubheadingStyle.generateFont(-5));
    }
}