package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RedTitleStyleTest
{
    private RedTitleStyle redTitleStyle;

    @BeforeEach
    public void setUp() {
        redTitleStyle = new RedTitleStyle();
    }

    @Test
    void getFontName() {
        assertEquals("Helvetica", redTitleStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent() {
        assertEquals(0, redTitleStyle.getIndent(), "Indent should be 0.");
    }

    @Test
    void getColor() {
        assertEquals(Color.red, redTitleStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize() {
        assertEquals(48, redTitleStyle.getFontSize(), "Font size should be 48.");
    }

    @Test
    void getVerticalMargin() {
        assertEquals(20, redTitleStyle.getVerticalMargin(), "Vertical margin should be 20.");
    }

    @Test
    void getFont_ScaleEqualsOne_BaseFontValues()
    {
        Font font = redTitleStyle.getFont(1);
        assertEquals(48, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_DoubleFontSize()
    {
        Font font = redTitleStyle.getFont(2);
        assertEquals(96, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsZero_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> redTitleStyle.getFont(0));
    }

    @Test
    void getFont_NegativeNumberScale_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> redTitleStyle.getFont(-4));
    }

    @Test
    void generateFont_FontSizeIsPositive_CorrectOutput()
    {
        Font font = redTitleStyle.generateFont(10);
        assertEquals(10, font.getSize());
    }

    @Test
    void generateFont_FontSizeIs0_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> redTitleStyle.generateFont(0));
    }

    @Test
    void generateFont_FontSizeIsNegative_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> redTitleStyle.generateFont(-5));
    }
}