package com.ZsomborSebastian.JabberPoint;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.*;

import java.io.IOException;

public class JabberPoint
{
    public static void main(String[] args)
    {
        StylesFactory factory = new StylesFactory();
        Style red = factory.createStyle(StyleTypes.RED_TITLE);
        Style black = factory.createStyle(StyleTypes.BLACK_SUBTEXT);
        Slide slide = new Slide();
        Slide slide2 = new Slide();
        slide2.setSlideTitle("Slide title2");
        slide2.appendSlideItem(new TextItem("Hey", black));
        slide.setSlideTitle("Test");
        slide.appendSlideItem(new TextItem("Hey", black));
        try
        {
            slide.appendSlideItem(new BitMapItem(black, "image.png"));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("The slide is here and is not null" + slide);


        Presentation presentation = new Presentation();
        presentation.appendSlide(slide);
        presentation.appendSlide(slide2);
        new SlideViewerFrame("test", presentation);


    }
}


