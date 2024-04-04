package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerComponent;

import java.util.ArrayList;
import java.util.List;

public class Presentation
{

    private final List<PresentationObserver> presentationObservers;
    private String presentationTitle;
    private ArrayList<Slide> slides = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent;
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

    public ArrayList<Slide> getSlides()
    {
        return slides;
    }

    public void setSlides(ArrayList<Slide> slides)
    {
        this.slides = slides;
    }

    public SlideViewerComponent getSlideViewerComponent()
    {
        return this.slideViewComponent;
    }

    public void setSlideViewerComponent(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
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

    public void showNextSlide() {
        if (canMoveToNextSlide()) {
            currentSlideIndex++;
            displayCurrentSlide();
        }
    }

    public void showPreviousSlide() {
        if (canMoveToPreviousSlide()) {
            currentSlideIndex--;
            displayCurrentSlide();
        }
    }

    public void jumpToSlide(int slideNumber) {
        if (isValidSlideNumber(slideNumber)) {
            currentSlideIndex = slideNumber;
            displayCurrentSlide();
        }
    }

    private boolean canMoveToNextSlide() {
        return currentSlideIndex < slides.size() - 1;
    }

    private boolean canMoveToPreviousSlide() {
        return currentSlideIndex > 0;
    }

    private boolean isValidSlideNumber(int slideNumber) {
        return slideNumber >= 0 && slideNumber < slides.size();
    }

    private void displayCurrentSlide() {
        Slide currentSlide = slides.get(currentSlideIndex);
        // Logic to display the current slide goes here
    }

    public void clear() {
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
            changeSlide(currentSlideNumber - 1);
        }
    }

    // go to the next slide unless your at the end of the presentation.
    public void nextSlide()
    {
        if (currentSlideNumber < getNumberOfSlides())
        {
            changeSlide(currentSlideNumber + 1);
        }
    }

    // Delete the presentation to be ready for the next one.
    void resetPresentation()
    {
        slides = new ArrayList<Slide>();
        changeSlide(0);
    }

    // Add a slide to the presentation
    public void appendSlide(Slide slide)
    {
        this.slides.add(slide);
    }


    // Get a slide with a certain slidenumber
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

    // Give the current slide


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

