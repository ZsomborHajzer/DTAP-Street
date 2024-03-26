package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

public class BlackSubtextStyleTest
{

    private BlackSubtextStyle blackSubtextStyle;

    @BeforeEach
    public void setUp()
    {
        blackSubtextStyle = new BlackSubtextStyle();
    }

    @Test
    void getFontName()
    {
        assertEquals("Helvetica", blackSubtextStyle.getFontName(), "Font name should be Helvetica.");
    }

    @Test
    void getIndent()
    {
        assertEquals(70, blackSubtextStyle.getIndent(), "Indent should be 70."); // Corrected based on the initial values
    }

    @Test
    void getColor()
    {
        assertEquals(Color.black, blackSubtextStyle.getColor(), "Color should be black.");
    }

    @Test
    void getFontSize()
    {
        assertEquals(30, blackSubtextStyle.getFontSize(), "Font size should be 30."); // Corrected based on the initial values
    }

    @Test
    void getVerticalMargin()
    {
        assertEquals(10, blackSubtextStyle.getVerticalMargin(), "Vertical margin should be 10.");
    }
}
