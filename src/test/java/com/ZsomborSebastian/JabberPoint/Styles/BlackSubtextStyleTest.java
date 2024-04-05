package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;

public class BlackSubtextStyleTest
{

    private BlackSubtextStyle blackSubtextStyle;

    @BeforeEach
    public void setUp()
    {
        blackSubtextStyle = new BlackSubtextStyle();
    }

    @Test
    void getFontName_CallMethod_ExpectHelvetica()
    {
        assertEquals("Helvetica", blackSubtextStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent_CallMethod_ExpectFontSize()
    {
        assertEquals(70, blackSubtextStyle.getIndent(), "Indent should be 70."); // Corrected based on the initial values
    }

    @Test
    void getColor_CallMethod_ExpectCorrectColor()
    {
        assertEquals(Color.black, blackSubtextStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize_CallMethod_ExpectCorrectFontSize()
    {
        assertEquals(30, blackSubtextStyle.getFontSize(), "Font size should be 30."); // Corrected based on the initial values
    }

    @Test
    void getVerticalMargin_CallMethod_ExpectCorrectVerticalMargin()
    {
        assertEquals(10, blackSubtextStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }

    @Test
    void getFont_ScaleEqualsOne_BaseFontValues()
    {
        Font font = blackSubtextStyle.getFont(1);
        assertEquals(30, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_DoubleFontSize()
    {
        Font font = blackSubtextStyle.getFont(2);
        assertEquals(60, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsZero_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubtextStyle.getFont(0));
    }

    @Test
    void getFont_NegativeNumberScale_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubtextStyle.getFont(-4));
    }

    @Test
    void generateFont_FontSizeIsPositive_CorrectOutput()
    {
        Font font = blackSubtextStyle.generateFont(10);
        assertEquals(10, font.getSize());
    }

    @Test
    void generateFont_FontSizeIs0_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubtextStyle.generateFont(0));
    }

    @Test
    void generateFont_FontSizeIsNegative_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackSubtextStyle.generateFont(-5));
    }
}
