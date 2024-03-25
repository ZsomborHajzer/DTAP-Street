package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.Style;
import com.ZsomborSebastian.JabberPoint.Styles.StyleTypes;

import java.util.Vector;

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;

    protected String title; // title is saved separately
    protected Vector<SlideItem> items; // slide items are saved in a Vector

    public Slide() {
        items = new Vector<SlideItem>();
    }

    public void addTextItem(String content, StyleTypes styleType) {

    }

    public void addBitMapItem()

}
