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

//    @Test
//    void getFont_AttributesOfFont_Equals_BaseAttributes()
//    {
//        //java.awt.Font[family=Dialog,name=Helvetica,style=bold,size=60]
//        System.out.println(blackSubheadingStyle.getFont(1));
//        Font font = blackSubheadingStyle.getFont(1);
//        assertEquals(font.getFamily(), "Dialog");
//        assertEquals(font.getName(), "Helvetica");
//        assertEquals(font.getSize(), 30);
//    }
//
//    @Test
//    void getFont_ScaleDoubled_FontSize_Should_Double()
//    {
//        //java.awt.Font[family=Dialog,name=Helvetica,style=bold,size=60]
//        System.out.println(blackSubheadingStyle.getFont(1));
//        Font font = blackSubheadingStyle.getFont(1);
//        assertEquals("Dialog", font.getFamily());
//        assertEquals("Helvetica", font.getName());
//        assertEquals(60, font.getSize());
//    }
}