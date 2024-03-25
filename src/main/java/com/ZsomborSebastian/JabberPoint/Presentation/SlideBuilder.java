package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;

public class SlideBuilder
{
    private Slide slide;

    public SlideBuilder()
    {
        this.slide = new Slide();
    }

    public void addTextItem(TextItem textItem) {
        slide.addTextItem();
    }

    public void addBitMapItem(BitMapItem bitMapItem) {
        slide.addBitMapItem();
    }

    public Slide build() {
        return this.slide;
    }
}
