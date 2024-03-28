package com.ZsomborSebastian.JabberPoint;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.BlackTextStyle;
import com.ZsomborSebastian.JabberPoint.Styles.BlueHeadingStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;
import com.ZsomborSebastian.JabberPoint.Styles.StylesFactory;

import javax.swing.*;

public class JabberPoint
{
    public static void main(String[] args)
    {
        StylesFactory factory = new StylesFactory();
        Style blackText = new BlackTextStyle();
        Style blueText = new BlueHeadingStyle();
        System.out.println(blackText.getFontName() + blackText.getColor());
        System.out.println(blueText.getFontName() + blueText.getColor());


        Presentation presentation = new Presentation();
        new SlideViewerFrame("test", presentation);

    }
}


