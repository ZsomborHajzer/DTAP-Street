package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextItem extends SlideItem
{
    private String inputText;
    private AttributedString attributedString;

    public TextItem(String inputText, Style style)
    {
        super(style);
        setInputText(inputText);
    }

    public String getInputText()
    {
        return this.inputText;
    }

    public void setInputText(String inputText)
    {
        if (inputText.isEmpty())
        {
            throw new IllegalArgumentException("Invalid text input");
        }
        this.inputText = inputText;
    }

    public AttributedString getAttributedString(float scale)
    {
        AttributedString attributedString = createAttributedString();
        applyAttributes(attributedString, scale);
        return attributedString;
    }

    public AttributedString createAttributedString()
    {
        return new AttributedString(getInputText());
    }

    public void applyAttributes(AttributedString attributedString, float scale)
    {
        attributedString.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, getInputText().length());
    }

    private List<TextLayout> getLayouts(Graphics graphics, float scale)
    {
        List<TextLayout> layouts = new ArrayList<>();
        AttributedString attributedString = getAttributedString(scale);
        Graphics2D g2d = (Graphics2D) graphics;
        FontRenderContext fontRenderContext = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = createLineBreakMeasurer(attributedString, fontRenderContext);
        float wrappingWidth = wrappingWidthCalculator(scale);

        while (measurer.getPosition() < getInputText().length())
        {
            TextLayout layout = getNextLayout(measurer, wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

    public LineBreakMeasurer createLineBreakMeasurer(AttributedString attributedString, FontRenderContext fontRenderContext)
    {
        return new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
    }

    public float wrappingWidthCalculator(float scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("Scale can not be zero");
        }
        return ((Slide.WIDTH - this.style.getIndent()) * scale);
    }

    private TextLayout getNextLayout(LineBreakMeasurer measurer, float wrappingWidth)
    {
        return measurer.nextLayout(wrappingWidth);
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        List<TextLayout> layouts = getLayouts(graphics, scale);
        int xSize = calculateMaxWidth(layouts);
        int ySize = calculateTotalHeight(layouts, scale);
        return new Rectangle(floatToInt(style.getIndent() * scale), 0, xSize, ySize);
    }

    protected int calculateMaxWidth(List<TextLayout> layouts)
    {
        int maxWidth = 0;
        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > maxWidth)
            {
                maxWidth = doubleToInt(bounds.getWidth());
            }
        }
        return maxWidth;
    }

    protected int calculateTotalHeight(List<TextLayout> layouts, float scale)
    {
        if (scale < 0) {
            throw new IllegalArgumentException("Input value should be more or equal to zero");
        }
        int totalHeight = floatToInt(style.getFontSize() * scale);
        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getHeight() > 0)
            {
                totalHeight += doubleToInt(bounds.getHeight());
            }
            totalHeight += floatToInt(layout.getLeading() + layout.getDescent());
        }
        return totalHeight;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {
        List<TextLayout> layouts = getLayouts(graphics, scale);
        Point pen = createNewPoint(x, y, scale);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(style.getColor());
        drawText(pen, g2d, layouts);
    }

    public Point createNewPoint(int x, int y, float scale)
    {
        return new Point(x + floatToInt(style.getIndent() * scale), y + floatToInt(style.getFontSize() * scale));
    }

    public void drawText(Point pen, Graphics2D g2d, List<TextLayout> layouts)
    {
        for (TextLayout layout : layouts)
        {
            pen.y += floatToInt(layout.getAscent());
            layout.draw(g2d, pen.x, pen.y);
            pen.y += floatToInt(layout.getDescent());
        }
    }
}
