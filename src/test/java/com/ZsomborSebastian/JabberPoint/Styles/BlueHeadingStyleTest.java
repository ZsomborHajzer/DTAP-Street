package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Color;

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
}