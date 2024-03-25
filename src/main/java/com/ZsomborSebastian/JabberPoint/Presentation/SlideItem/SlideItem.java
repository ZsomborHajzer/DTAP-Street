package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class SlideItem
{
    private int itemLevel;
public SlideItem(){
    this.itemLevel = 0;
}
public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);

}
