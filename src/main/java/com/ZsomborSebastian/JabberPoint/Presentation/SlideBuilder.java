package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlideBuilder
{
    private String slideTitle;


    private List<SlideItem> items;


    public SlideBuilder()
    {
        this.items = new ArrayList<>();
    }


    public SlideBuilder addBitMapItem(Style style, String imageName)
    {
        try
        {
            BitMapItem bitMapItem = new BitMapItem(style, imageName);
            items.add(bitMapItem);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return this;
    }

    public SlideBuilder addTextItem(String text, Style style)
    {
        if (text.isEmpty())
        {
            throw new IllegalArgumentException("Text can not be empty");
        }
        TextItem textItem = new TextItem(text, style);
        items.add(textItem);

        return this;
    }

    public SlideBuilder setSlideTitle(String slideTitle)
    {
        if (slideTitle.isEmpty())
        {
            throw new IllegalArgumentException("SlideTitle cant be empty");
        }
        this.slideTitle = slideTitle;

        return this;
    }

    private void clearItems()
    {
        this.items = new ArrayList<>();
    }

    public Slide build()
    {
        Slide slide = new Slide();
        slide.setSlideTitle(this.slideTitle);
        for (SlideItem item : items)
        {
            slide.appendSlideItem(item);
        }
        clearItems();
        return slide;
    }
}
