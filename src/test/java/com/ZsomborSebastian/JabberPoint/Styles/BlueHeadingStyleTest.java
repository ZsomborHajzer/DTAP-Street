package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.*;

public class BlueHeadingStyleTest {

    private BlueHeadingStyle blueHeadingStyle;

    @BeforeEach
    public void setUp() {
        blueHeadingStyle = new BlueHeadingStyle();
    }

    @Test
    void getFontName() {
        assertEquals("Helvetica", blueHeadingStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent() {
        assertEquals(20, blueHeadingStyle.getIndent(), "Indent should be 20.");
    }

    @Test
    void getColor() {
        assertEquals(Color.blue, blueHeadingStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize() {
        assertEquals(40, blueHeadingStyle.getFontSize(), "Font size should be 40.");
    }

    @Test
    void getVerticalMargin() {
        assertEquals(10, blueHeadingStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }

    @Test
    void getFont_ScaleEqualsOne_BaseFontValues()
    {
        Font font = blueHeadingStyle.getFont(1);
        assertEquals(40, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsTwo_DoubleFontSize()
    {
        Font font = blueHeadingStyle.getFont(2);
        assertEquals(80, font.getSize());
    }

    @Test
    void getFont_ScaleEqualsZero_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blueHeadingStyle.getFont(0));
    }

    @Test
    void getFont_NegativeNumberScale_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blueHeadingStyle.getFont(-4));
    }

    @Test
    void generateFont_FontSizeIsPositive_CorrectOutput()
    {
        Font font = blueHeadingStyle.generateFont(10);
        assertEquals(10, font.getSize());
    }

    @Test
    void generateFont_FontSizeIs0_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blueHeadingStyle.generateFont(0));
    }

    @Test
    void generateFont_FontSizeIsNegative_ShouldThrowIllegalArgumentExc()
    {
        assertThrows(IllegalArgumentException.class, () -> blueHeadingStyle.generateFont(-5));
    }
}