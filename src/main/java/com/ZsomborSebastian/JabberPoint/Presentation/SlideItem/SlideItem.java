package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class SlideItem
{
    protected Style style;

    public SlideItem(Style style)
    {
        this.style = style;
    }


    public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale);

    // Draw the item
    public abstract void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer);

    public int floatToInt(float number)
    {
        return Math.round(number);
    }

    public int doubleToInt(double number)
    {
        return (int) Math.round(number);
    }
}
