package com.ZsomborSebastian.JabberPoint.Styles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StylesFactoryTest
{
    private StylesFactory myStyleFactory;

    @BeforeEach
    public void setUp()
    {
        myStyleFactory = new StylesFactory();
    }

    @Test
    void createBlackSubheadingStyle()
    {
        Object createdObject = myStyleFactory.createStyle(StyleTypes.BLACK_SUBHEADING);
        assertInstanceOf(BlackSubheadingStyle.class, createdObject, "The created object should be an instance of BlackSubheadingStyle");
    }

    @Test
    void createBlackSubtextStyle()
    {
        Object createdObject = myStyleFactory.createStyle(StyleTypes.BLACK_SUBTEXT);
        assertInstanceOf(BlackSubtextStyle.class, createdObject, "The created object should be an instance of BlackSubtextStyle");
    }

    @Test
    void createBlackTextStyle()
    {
        Object createdObject = myStyleFactory.createStyle(StyleTypes.BLACK_TEXT);
        assertInstanceOf(BlackTextStyle.class, createdObject, "The created object should be an instance of BlackTextStyle");
    }

    @Test
    void createBlueHeadingStyle()
    {
        Object createdObject = myStyleFactory.createStyle(StyleTypes.BLUE_HEADING);
        assertInstanceOf(BlueHeadingStyle.class, createdObject, "The created object should be an instance of BlueHeadingStyle");
    }

    @Test
    void createRedTitleStyle()
    {
        Object createdObject = myStyleFactory.createStyle(StyleTypes.RED_TITLE);
        assertInstanceOf(RedTitleStyle.class, createdObject, "The created object should be an instance of RedTitleStyle");
    }

    @Test
    void createStyleWithNullTypeShouldThrowException()
    {
        assertThrows(IllegalArgumentException.class, () -> myStyleFactory.createStyle(null),
                "An IllegalArgumentException should be thrown for unsupported style types.");
    }
}


