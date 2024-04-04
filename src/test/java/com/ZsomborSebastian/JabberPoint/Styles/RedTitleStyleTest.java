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
}