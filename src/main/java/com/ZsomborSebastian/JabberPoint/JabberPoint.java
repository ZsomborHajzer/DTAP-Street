package com.ZsomborSebastian.JabberPoint;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;
import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideBuilder;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.*;

import java.io.IOException;

public class JabberPoint
{
    public static void main(String[] args) throws IOException
    {
        StylesFactory factory = new StylesFactory();
        Style Red = factory.createStyle(StyleTypes.RED_TITLE);
        Style Black = factory.createStyle(StyleTypes.BLACK_SUBTEXT);
        Style Black2 = factory.createStyle(StyleTypes.BLACK_SUBHEADING);
        Style Blue = factory.createStyle(StyleTypes.BLUE_HEADING);
        SlideBuilder builder = new SlideBuilder();


       Slide slide = builder.addBitMapItem(Black, "image2.png")
                .setSlideTitle("Builder Slide")
                .addTextItem("This was built using a builder", Black)
                .addTextItem("another Text item", Red)
                        .build();

       Slide slide2 = builder.setSlideTitle("Second Slide")
                .addTextItem("this is the second slide",Black)
                .addTextItem("Some blue as well", Blue)
                        .build();


        System.out.println("The slide is here and is not null" + slide);


        Presentation presentation = new Presentation();
        presentation.appendSlide(slide);
        presentation.appendSlide(slide2);
        new SlideViewerFrame("test", presentation);




        XMLAccessor xmlAccessor = new XMLAccessor();

        XMLAccessorAdapter adapter = new XMLAccessorAdapter();

        DemoPresentation demoPresentation = new DemoPresentation(adapter);
    }
}


