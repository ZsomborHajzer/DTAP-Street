package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.BlackSubtextStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class TextItemTest
{
    private TextItem textItem;

    @BeforeEach
    void setup()
    {
        this.textItem = new TextItem("test", new BlackSubtextStyle());
    }

    @Test
    void getInputText_CallMethod_ExpectTestItem()
    {
        assertEquals("test", textItem.getInputText());
    }

    @Test
    void setInputText_correctInputValue_ShouldPass()
    {
        textItem.setInputText("test input");
        assertEquals("test input", textItem.getInputText());
    }

    @Test
    void setInputText_EmptyTextField_ShouldThrowIllegalArgument()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            textItem.setInputText("");
        });
    }

    @Test
    void createAttributedString_CallMethod_CreatesAttributed()
    {
        assertInstanceOf(AttributedString.class, textItem.createAttributedString());
    }

    @Test
    void applyAttributes_CallMethod_ExpectScaleToMultiplyFontsize()
    {
        AttributedString attributedString = new AttributedString("String");
        textItem.applyAttributes(attributedString, 6);
        textItem.applyAttributes(attributedString, 3);
        AttributedCharacterIterator iterator = attributedString.getIterator();
        Map<AttributedCharacterIterator.Attribute, Object> attributes = iterator.getAttributes();

        Font font = (Font) attributes.get(TextAttribute.FONT);
        System.out.println(font.getAttributes());
        assertEquals("Helvetica", font.getName());
        assertEquals(90, font.getSize());
    }

    @Test
    void createLineBreakMeasurer_CallMethod_InstanceOfLineBreakMeasurer()
    {
        AttributedString attributedString = new AttributedString(textItem.getInputText());
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        FontRenderContext fontRenderContext = g2d.getFontRenderContext();
        assertInstanceOf(LineBreakMeasurer.class, textItem.createLineBreakMeasurer(attributedString, fontRenderContext));
    }

    @Test
    void wrappingWidthCalculator_CallMethodWithScaleOne_ExpectedOutput()
    {
        assertEquals(1130.0, textItem.wrappingWidthCalculator(1));
    }

    @Test
    void wrappingWidthCalculator_CallMethodWithScaleTwo_ExpectedDoubleOutput()
    {
        assertEquals(2260.0, textItem.wrappingWidthCalculator(2));
    }

    @Test
    void wrappingWidthCalculator_CallMethodWithScaleZero_ExpectedDoubleOutput()
    {
        assertEquals(0.0, textItem.wrappingWidthCalculator(0));
    }

    @Test
    void wrappingWidthCalculator_CallMethodWithNegativeScale_ExpectedErrorThrown()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            textItem.wrappingWidthCalculator(-3);
        });
    }

    @Test
    void calculateMaxWidth_CallMethodWithTestValue_ShouldReturnZero()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout emptyLayout = new TextLayout("test", new Font("Serif", Font.PLAIN, 0), fontRenderContext);
        ArrayList<TextLayout> textLayouts = new ArrayList<>();
        textLayouts.add(emptyLayout);
        int maxWidth = textItem.calculateMaxWidth(textLayouts);
        assertEquals(0, maxWidth);
    }

    @Test
    void calculateTotalHeight_CallMethodWithTestValue_ShouldReturn40()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout emptyLayout = new TextLayout("test", new Font("Serif", Font.PLAIN, 12), fontRenderContext);
        ArrayList<TextLayout> textLayouts = new ArrayList<>();
        textLayouts.add(emptyLayout);
        int totalHeight = textItem.calculateTotalHeight(textLayouts, 1);
        System.out.println(totalHeight);
        assertEquals(40, totalHeight);
    }

    @Test
    void calculateTotalHeight_CallMethodWithTestValueAndDoubleScale_ShouldReturn70()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout emptyLayout = new TextLayout("test", new Font("Serif", Font.PLAIN, 12), fontRenderContext);
        ArrayList<TextLayout> textLayouts = new ArrayList<>();
        textLayouts.add(emptyLayout);
        int totalHeight = textItem.calculateTotalHeight(textLayouts, 2);
        System.out.println(totalHeight);
        assertEquals(70, totalHeight);
    }

    @Test
    void calculateTotalHeight_CallMethodWithTestValueAndZeroScale_ShouldReturnBaseHeight()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout emptyLayout = new TextLayout("test", new Font("Serif", Font.PLAIN, 12), fontRenderContext);
        ArrayList<TextLayout> textLayouts = new ArrayList<>();
        textLayouts.add(emptyLayout);
        int totalHeight = textItem.calculateTotalHeight(textLayouts, 0);
        System.out.println(totalHeight);
        assertEquals(10, totalHeight);
    }


    @Test
    void calculateTotalHeight_CallMethodWithTestValueAndNegativeScale_ShouldThrowIllegalArgumentException()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout emptyLayout = new TextLayout("test", new Font("Serif", Font.PLAIN, 12), fontRenderContext);
        ArrayList<TextLayout> textLayouts = new ArrayList<>();
        textLayouts.add(emptyLayout);
        assertThrows(IllegalArgumentException.class, () ->
        {
            textItem.calculateTotalHeight(textLayouts, -5);
        });
    }

    @Test
    void getBoundingBox_CallMethodWithMockInput_ValidOutput()
    {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.createGraphics();
        ImageObserver mockObserver = mock(ImageObserver.class);
        System.out.println(textItem.getBoundingBox(graphics, mockObserver, 1));
        assertEquals(59.0, textItem.getBoundingBox(graphics, mockObserver, 1).getHeight());
        assertEquals(53, textItem.getBoundingBox(graphics, mockObserver, 1).getWidth());
        assertEquals(70, textItem.getBoundingBox(graphics, mockObserver, 1).getX());
        assertEquals(0, textItem.getBoundingBox(graphics, mockObserver, 1).getY());
    }


    @Test
    void createNewPoint_CallMethodWithBaseValues_ReturnCorrectInstance()
    {
        System.out.println(textItem.createNewPoint(1, 1, 1).getX());
        assertInstanceOf(Point.class, textItem.createNewPoint(1, 1, 1));
    }

    @Test
    void createNewPoint_CallMethodWithBaseValues_ReturnCorrectXYValues()
    {
        assertEquals(71, textItem.createNewPoint(1, 1, 1).getX());
        assertEquals(31, textItem.createNewPoint(1, 1, 1).getY());
    }

    @Test
    void createNewPoint_CallMethodWith0Scale_ReturnXYEquals1()
    {
        assertEquals(1, textItem.createNewPoint(1, 1, 0).getX());
        assertEquals(1, textItem.createNewPoint(1, 1, 0).getY());
    }

}