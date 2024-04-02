package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.util.ArrayList;
import java.util.List;

public class SlideBuilder
{
    private String title;


    private List<SlideItem> items;



    public SlideBuilder()
    {
        this.items = new ArrayList<>();
    }



    public void addBitMapItem(BitMapItem bitMapItem)
    {

    }

    public void addTextItem(String text, Style style)
    {
        TextItem textItem = new TextItem(text, style);
        items.add(textItem);
    }

    public void setSlideTitle(String text)
    {

    }

    public Slide build()
    {
        return new Slide();
    }
}
