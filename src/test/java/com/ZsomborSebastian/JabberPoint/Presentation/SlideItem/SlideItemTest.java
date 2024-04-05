package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.BlackSubtextStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideItemTest
{
    private TextItem textItem;
    @BeforeEach
    void setup() {
        this.textItem = new TextItem("test", new BlackSubtextStyle());
    }

    @Test
    void floatToInt_PositiveFloatIn_CorrectMathRoundToNearestInt()
    {
        assertEquals(5, textItem.floatToInt(5.1f));
        assertEquals(5, textItem.floatToInt(5.0f));
        assertEquals(5, textItem.floatToInt(5.4f));
        assertEquals(5, textItem.floatToInt(5.49f));
        assertEquals(5, textItem.floatToInt(4.50f));
        assertEquals(5, textItem.floatToInt(4.51f));
        assertEquals(5, textItem.floatToInt(5.0234f));
        assertEquals(5, textItem.floatToInt(5.234432f));
    }

    @Test
    void floatToInt_NegativeFloatIn_CorrectMathRoundToNearestInt()
    {
        assertEquals(-5, textItem.floatToInt(-5.1f));
        assertEquals(-5, textItem.floatToInt(-5.0f));
        assertEquals(-5, textItem.floatToInt(-5.4f));
        assertEquals(-5, textItem.floatToInt(-5.49f));
        assertEquals(-5, textItem.floatToInt(-4.51f));
        assertEquals(-5, textItem.floatToInt(-4.544f));
        assertEquals(-5, textItem.floatToInt(-5.0234f));
        assertEquals(-5, textItem.floatToInt(-5.234432f));
    }

    @Test
    void doubleToInt_PositiveDoubleIn_CorrectMathRoundToNearestInt()
    {
        assertEquals(5, textItem.doubleToInt(5.1));
        assertEquals(5, textItem.doubleToInt(5.0));
        assertEquals(5, textItem.doubleToInt(5.4));
        assertEquals(5, textItem.doubleToInt(5.49));
        assertEquals(5, textItem.doubleToInt(4.50));
        assertEquals(5, textItem.doubleToInt(4.51));
        assertEquals(5, textItem.doubleToInt(5.0234));
        assertEquals(5, textItem.doubleToInt(5.234432));
    }

    @Test
    void doubleToInt_NegativeDoubleIn_CorrectMathRoundToNearestInt()
    {
        assertEquals(-5, textItem.doubleToInt(-5.1));
        assertEquals(-5, textItem.doubleToInt(-5.0));
        assertEquals(-5, textItem.doubleToInt(-5.4));
        assertEquals(-5, textItem.doubleToInt(-5.49));
        assertEquals(-5, textItem.doubleToInt(-4.53));
        assertEquals(-5, textItem.doubleToInt(-4.51));
        assertEquals(-5, textItem.doubleToInt(-5.0234));
        assertEquals(-5, textItem.doubleToInt(-5.234432));
    }
}