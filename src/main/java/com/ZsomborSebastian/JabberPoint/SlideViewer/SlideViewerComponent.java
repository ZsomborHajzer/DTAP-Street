package com.ZsomborSebastian.JabberPoint.SlideViewer;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.PresentationObserver;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideViewerComponent extends JComponent implements PresentationObserver
{
    private Slide slide; // current slide
    private Font labelFont = null; // font for labels
    private Presentation presentation = null; // the presentation
    private JFrame frame = null;

    // UI related constants
    private static final Color BGCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;

    // Positioning constants
    private static final int XPOS = 1100;
    private static final int YPOS = 20;

    public SlideViewerComponent(Presentation presentation, JFrame frame)
    {

        this.presentation = presentation;
        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.frame = frame;
        setBackground(BGCOLOR);
        presentation.addObserver(this);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }


    // draw the slide
    public void paintComponent(Graphics graphics)
    {
        graphics.setColor(BGCOLOR);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setFont(labelFont);
        graphics.setColor(COLOR);
        graphics.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
                presentation.getNumberOfSlides(), XPOS, YPOS);
        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        slide.draw(graphics, area, this);
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

    public void update(Presentation presentation, Slide slide)
    {
        if (slide == null)
        {
            repaint();
            return;
        }
        this.presentation = presentation;
        this.slide = slide;
        repaint();
        frame.setTitle(presentation.getPresentationTitle());
    }

}

