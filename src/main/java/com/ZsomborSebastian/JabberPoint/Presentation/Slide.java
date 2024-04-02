package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String title; // title is saved separately
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

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
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
    public void drawSlide(Graphics g, Rectangle area, ImageObserver view)
    {
        float scale = getScale(area);
        int y = area.y;
        // Title is handled separately
        SlideItem slideItem = new TextItem(0, getTitle());
        Style style = Style.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number = 0; number < getNumberOfItems(); number++)
        {
            slideItem = (SlideItem) getAllSlideItems().elementAt(number);
            style = Style.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }


    // Give the scale for drawing
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
