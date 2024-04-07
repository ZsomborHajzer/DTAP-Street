package com.ZsomborSebastian.JabberPoint;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideBuilder;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.*;


public class JabberPoint
{
    public static void main(String[] args)
    {
        StylesFactory factory = new StylesFactory();
        Style red = factory.createStyle(StyleTypes.RED_TITLE);
        Style black = factory.createStyle(StyleTypes.BLACK_SUBTEXT);
        Style black2 = factory.createStyle(StyleTypes.BLACK_SUBHEADING);
        Style blue = factory.createStyle(StyleTypes.BLUE_HEADING);
        Presentation presentation = new Presentation();

        SlideBuilder builder = new SlideBuilder(presentation);

        Slide slide = builder.addBitMapItem(black, "image2.png")
                .setSlideTitle("Builder Slide")
                .addTextItem("This was built using a builder. Now I am just typing for no reason to see if the LineBreaker works or to see how it works if it works, this is kinda craycray to see a text input this long and long and long and long and long and long and long and long", black)
                .addTextItem("another Text item", red)
                .build();

        Slide slide2 = builder.setSlideTitle("Second Slide")
                .addTextItem("this is the second slide", black)
                .addTextItem("Some blue as well", blue)
                .build();

        Slide slide3 = builder.setSlideTitle("See If I broke anything and also see if the line breaker works on titles as well as subtextx")
                .addTextItem("Yeet", blue)
                .addBitMapItem(red, "image2.png")
                .addBitMapItem(black2, "image2.png")
                .build();

        new SlideViewerFrame("test", presentation);

        System.out.println("The slide is here and is not null" + slide);
    }
}


