package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.*;

import java.io.IOException;

public class DemoPresentation extends Presentation
{

    private XMLAccessorAdapter xmlAccessorAdapter;

    public DemoPresentation(XMLAccessorAdapter xmlAccessorAdapter)
    {
        this.setPresentationTitle("Demo Presentation");
        this.xmlAccessorAdapter = xmlAccessorAdapter;
        createSlides();
    }

    public void loadFile(String filename) throws Exception
    {
        xmlAccessorAdapter.loadFile(filename);
    }

    public void saveFile(String filename) throws Exception
    {
        xmlAccessorAdapter.saveFile(filename);
    }


    private void createSlides()
    {
        SlideBuilder builder = new SlideBuilder(this);

        builder.setSlideTitle("DemoPresentation JabberPoint")
                .addTextItem("This presentation software was made by Zsombor and Sebastian", new BlueHeadingStyle())
                .addTextItem("Go to the next slide for information about this software.", new BlackSubtextStyle())
                .build();

        builder.setSlideTitle("Controls")
                .addTextItem("Using the left and right arrows you are able to navigate between slides", new BlackSubheadingStyle())
                .addTextItem("But you can also do this with the pg up and pg down buttons", new BlackTextStyle())
                .addTextItem("You can also use different menu functionalities by their keyboard short cuts", new BlueHeadingStyle())
                .addTextItem("Ctrl + O -> Open | Ctrl + N -> New | Ctrl + S -> Save | Ctrl + E -> Exit | Ctrl + G -> Goto | Ctrl + P -> Previous | Ctrl + F -> Forward | Ctrl + A -> About", new BlackTextStyle())
                .build();

        builder.setSlideTitle("Capabilities")
                .addTextItem("Our software", new RedTitleStyle())
                .addTextItem("Can Add", new BlueHeadingStyle())
                .addTextItem("5 different", new BlackSubheadingStyle())
                .addTextItem("Text types", new BlackSubtextStyle())
                .addTextItem("To the presentation", new BlackTextStyle())
                .build();

        builder.setSlideTitle("Images")
                .addTextItem("And pictures of ducks at different indents", new BlueHeadingStyle())
                .addBitMapItem(new RedTitleStyle(), "image2.png")
                .addBitMapItem(new BlackSubtextStyle(), "image2.png")
                .build();

        builder.setSlideTitle("Final")
                .addTextItem("Thank you for trying out our cutting edge software", new BlueHeadingStyle())
                .build();

    }
}