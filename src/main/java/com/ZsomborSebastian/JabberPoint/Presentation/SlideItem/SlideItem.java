package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class SlideItem
{
    protected Style style;

    public SlideItem (Style style) {
        this.style = style;
    }


    public abstract Rectangle getBoundingBox(Graphics g,
                                             ImageObserver observer, float scale);

    // Draw the item
    public abstract void draw(int x, int y, float scale,
                              Graphics g, Style style, ImageObserver observer);
}
