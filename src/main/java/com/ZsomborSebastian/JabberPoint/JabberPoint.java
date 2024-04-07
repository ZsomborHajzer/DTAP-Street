package com.ZsomborSebastian.JabberPoint;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;
import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideBuilder;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.*;

import java.io.IOException;


public class JabberPoint
{
    private static StylesFactory factory = new StylesFactory();
    private static Presentation presentation = new Presentation();
    private static XMLAccessorAdapter xmlAccessor;

    static
    {
        try
        {
            xmlAccessor = new XMLAccessorAdapter();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        testDemoPresentation();
        testSlideViewerFrame();
        testXmlAccessor();
    }

    private static void testDemoPresentation()
    {
        DemoPresentation demoPresentation = new DemoPresentation(xmlAccessor);
        SlideBuilder builder = new SlideBuilder(demoPresentation);
        Slide slide = buildSlide(builder, "Builder Slide", "image2.png", "This was built using a builder...");
        Slide slide2 = buildSlide(builder, "Second Slide", null, "This is the second slide");
        Slide slide3 = buildSlide(builder, "See If I broke anything...", "image2.png", "Yeet");
        System.out.println("The slide is here and is not null" + slide);
    }

    private static void testSlideViewerFrame()
    {
        new SlideViewerFrame("test", new DemoPresentation(xmlAccessor));
    }

    private static void testXmlAccessor()
    {
        String filename = "default.xml";
        try
        {
            presentation = xmlAccessor.loadFile(filename);
            System.out.println("Presentation loaded successfully from file: " + filename);
            xmlAccessor.saveFile(filename);
            System.out.println("Presentation saved back successfully to file: " + filename);
        }
        catch (Exception e)
        {
            System.out.println("Error while loading/saving the presentation: " + e.getMessage());
        }
    }

    private static Slide buildSlide(SlideBuilder builder, String title, String imageName, String text)
    {
        Style black = factory.createStyle(StyleTypes.BLACK_SUBTEXT);
        Style red = factory.createStyle(StyleTypes.RED_TITLE);
        Style blue = factory.createStyle(StyleTypes.BLUE_HEADING);
        builder.setSlideTitle(title);
        if(imageName != null)
        {
            builder.addBitMapItem(black, imageName);
        }
        builder.addTextItem(text, blue);
        builder.addTextItem("another Text item", red);
        return builder.build();
    }
}


