package com.ZsomborSebastian.JabberPoint.SlideViewer;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.PresentationObserver;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideViewerComponent extends JComponent implements PresentationObserver
{
    private Slide slide; // current slide
    private final Font labelFont; // font for labels
    private final Presentation presentation; // the presentation
    private final JFrame frame;

    // UI related constants
    private static final Color BACKGROUNDCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;

    private static final int XPOS = 1100;
    private static final int YPOS = 20;

    public SlideViewerComponent(Presentation presentation, JFrame frame)
    {
        this.presentation = presentation;
        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.frame = frame;
        setBackground(BACKGROUNDCOLOR);
        presentation.addObserver(this);
        presentation.changeSlide(2);
    }

    public Slide getSlide()
    {
        return slide;
    }

    public void setSlide(Slide slide)
    {
        this.slide = slide;
    }

    public Font getLabelFont()
    {
        return labelFont;
    }

    public Presentation getPresentation()
    {
        return presentation;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }


    // draw the slide
    public void paintComponent(Graphics graphics)
    {
        graphics.setColor(BACKGROUNDCOLOR);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setFont(labelFont);
        graphics.setColor(COLOR);
        graphics.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
                presentation.getNumberOfSlides(), XPOS, YPOS);
        if (this.slide != null)
        {
            Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
            slide.drawSlide(graphics, area, this);
        }
    }

    @Override
    public void update()
    {
        this.slide = presentation.getCurrentSlide();
        repaint();
        if (frame != null)
        {
            frame.setTitle(presentation.getPresentationTitle());
        }
    }
}

