package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.*;

public class BlackTextStyleTest {

    private BlackTextStyle blackTextStyle;

    @BeforeEach
    public void setUp() {
        blackTextStyle = new BlackTextStyle();
    }

    @Test
    void getFontName() {
        assertEquals("Helvetica", blackTextStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent() {
        assertEquals(90, blackTextStyle.getIndent(), "Indent should be 90.");
    }

    @Test
    void getColor() {
        assertEquals(Color.black, blackTextStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize() {
        assertEquals(24, blackTextStyle.getFontSize(), "Font size should be 24.");
    }

    @Test
    void getVerticalMargin() {
        assertEquals(10, blackTextStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }

    @Test
    void getFont_ScaleEqualsOne_BaseFontValues()
    {
        Font font = blackTextStyle.getFont(1);
        assertEquals(24, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_DoubleFontSize()
    {
        Font font = blackTextStyle.getFont(2);
        assertEquals(48, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsZero_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackTextStyle.getFont(0));
    }

    @Test
    void getFont_NegativeNumberScale_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackTextStyle.getFont(-4));
    }

    @Test
    void generateFont_FontSizeIsPositive_CorrectOutput()
    {
        Font font = blackTextStyle.generateFont(10);
        assertEquals(10, font.getSize());
    }

    @Test
    void generateFont_FontSizeIs0_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackTextStyle.generateFont(0));
    }

    @Test
    void generateFont_FontSizeIsNegative_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blackTextStyle.generateFont(-5));
    }
}