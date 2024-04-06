package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.RedTitleStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String slideTitle; // title is saved separately
    private Vector<SlideItem> items; // slide items are saved in a Vector


    public Slide()
    {
        items = new Vector<SlideItem>();
    }

    public Vector<SlideItem> getItems()
    {
        return items;
    }

    public void setItems(Vector<SlideItem> items)
    {
        this.items = items;
    }

    public String getSlideTitle()
    {
        return this.slideTitle;
    }

    public void setSlideTitle(String slideTitle)
    {

        if (slideTitle.isEmpty())
        {
            throw new IllegalArgumentException("SlideTitle should not be empty");
        }

        this.slideTitle = slideTitle;
    }

    // Add a slide item
    public void appendSlideItem(SlideItem item)
    {
        items.addElement(item);
    }


    // give the  SlideItem
    public SlideItem getSpecificSlideItem(int slideIndex)
    {
        return items.elementAt(slideIndex);
    }


    // give all SlideItems in a Vector
    public Vector<SlideItem> getAllSlideItems()
    {
        return items;
    }


    // give the size of the Slide
    public int getNumberOfItems()
    {
        return items.size();
    }


    // draw the slide
    public void drawSlide(Graphics graphics, Rectangle area, ImageObserver observer)
    {
        float scale = getScale(area);
        int y = area.y;
        SlideItem slideItem = new TextItem(getSlideTitle(), new RedTitleStyle());  //rename this to presentation title
        slideItem.draw(area.x, y, scale, graphics, observer);
        y += slideItem.getBoundingBox(graphics, observer, scale).height;
        for (int i = 0; i < getNumberOfItems(); i++)
        {
            slideItem = getAllSlideItems().elementAt(i);
            slideItem.draw(area.x, y, scale, graphics, observer);
            y += slideItem.getBoundingBox(graphics, observer, scale).height;
        }
    }


    // Give the scale for drawing
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
