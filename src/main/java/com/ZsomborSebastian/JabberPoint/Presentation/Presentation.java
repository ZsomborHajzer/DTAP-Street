package com.ZsomborSebastian.JabberPoint.Presentation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerComponent;

import java.util.ArrayList;
import java.util.List;

@Root(name = "presentation")
public class Presentation
{

    private transient final List<PresentationObserver> presentationObservers;
    @Element(name = "presentationTitle", required = false)
    private String presentationTitle;
    @ElementList(name = "slides", required = false)
    private ArrayList<Slide> slides = null;
    @Element(name = "currentSlideNumber", required = false)
    private int currentSlideNumber = 0;
    private transient SlideViewerComponent slideViewComponent;
    private int currentSlideIndex;

    public Presentation()
    {
        this.presentationObservers = new ArrayList<>();
        slideViewComponent = null;
        resetPresentation();
    }

    public String getPresentationTitle()
    {
        return presentationTitle;
    }

    public void setPresentationTitle(String presentationTitle)
    {
        this.presentationTitle = presentationTitle;
    }


    public SlideViewerComponent getSlideViewerComponent()
    {
        return this.slideViewComponent;
    }

    public void setSlideViewerComponent(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    public ArrayList<Slide> getSlides()
    {
        return slides;
    }

    public void setSlides(ArrayList<Slide> slides)
    {
        this.slides = slides;
    }

    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    public void setSlideNumber(int slideNumber)
    {
        if (slideNumber < 0 || slideNumber > getNumberOfSlides())
        {
            throw new IllegalArgumentException("Slide Number Out of Range");
        }
        this.currentSlideNumber = slideNumber;
    }

    public void changeSlide(int number)
    {
        if (number < 0 || number > getNumberOfSlides())
        {
            throw new IllegalArgumentException("Slide Number Out of Range");
        }
        this.currentSlideNumber = number;
        notifyObservers();
    }

    public void previousSlide()
    {
        if (currentSlideNumber > 0)
        {
            this.currentSlideNumber--;
            changeSlide(currentSlideNumber);
        }
    }

    // go to the next slide unless your at the end of the presentation.
    public void nextSlide()
    {
        if (currentSlideNumber < getNumberOfSlides())
        {
            this.currentSlideNumber++;
            changeSlide(this.currentSlideNumber);
        }
    }

    // Delete the presentation to be ready for the next one.
    public void resetPresentation()
    {
        slides = new ArrayList<>();
        changeSlide(0);
    }

    public void appendSlide(Slide slide)
    {
        this.slides.add(slide);
    }

    public Slide getSlideObject(int number)
    {
        if (number < 0 || number >= getNumberOfSlides())
        {
            throw new IllegalArgumentException("Slide number out of range");
        }
        return slides.get(number);
    }

    public Slide getCurrentSlide()
    {
        return getSlideObject(currentSlideNumber);
    }

    public int getNumberOfSlides()
    {
        return slides.size();
    }


    public void addObserver(PresentationObserver presentationObserver)
    {
        presentationObservers.add(presentationObserver);
    }


    public void removeObserver(PresentationObserver presentationObserver)
    {
        presentationObservers.remove(presentationObserver);
    }


    private void notifyObservers()
    {
        for (PresentationObserver presentationObserver : presentationObservers)
        {
            presentationObserver.update();
        }
    }

    public void exitProgram(int statusCode)
    {
        System.exit(statusCode);
    }
}

