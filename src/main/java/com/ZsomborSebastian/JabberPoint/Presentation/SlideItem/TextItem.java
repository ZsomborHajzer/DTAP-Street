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

    private static final String EMPTYTEXT = "No Text Given"; //Q IS this needed or what

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


    public AttributedString getAttributedString(float scale) //FIX Why is scale float?
    {
        AttributedString attributedString = new AttributedString(getInputText());
        attributedString.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, inputText.length());
        return attributedString;
    }

    //Q Check with teachers if this needs to be broken apart or if it meets clean code requiremetns
    private List<TextLayout> getLayouts(Graphics graphics, float scale)
    {
        List<TextLayout> layouts = new ArrayList<>();
        AttributedString attributedString = getAttributedString(scale);
        Graphics2D g2d = (Graphics2D) graphics; //FIX Why is graphics being casted to Graphics2d here
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), frc);

        float wrappingWidth = (Slide.WIDTH - this.style.getIndent()) * scale;

        while (measurer.getPosition() < getInputText().length())
        {
            TextLayout layout = measurer.nextLayout(wrappingWidth); //Q float required input for nextLayout
            layouts.add(layout);
        }

        return layouts;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        List<TextLayout> layouts = getLayouts(graphics, scale);
        int xsize = 0;
        int ysize = (int) (style.getFontSize() * scale);  //FIX scale is of type "float" so it typecasts to int

        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize)
            {
                xsize = (int) bounds.getWidth(); //FIX typecast
            }
            if (bounds.getHeight() > 0)
            {
                ysize += (int) bounds.getHeight(); //FIX typecast
            }
            ysize += (int) (layout.getLeading() + layout.getDescent()); //FIX typecast
        }
        return new Rectangle((int) (style.getIndent() * scale), 0, xsize, ysize); //FIX typecast
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {

    }

}
