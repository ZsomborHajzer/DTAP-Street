package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Color;

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
}