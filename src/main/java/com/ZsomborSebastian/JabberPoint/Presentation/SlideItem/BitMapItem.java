package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BitMapItem extends SlideItem
{

    public BitMapItem(Style style)
    {
        super(style);
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style)
    {
        return null;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {

    }
}
