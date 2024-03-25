package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerComponent;

import java.util.ArrayList;

public class Presentation {
    private String title;
    private ArrayList<Slide> slides = null;

    private int currentSlideNumber = 0;

    private SlideViewerComponent slideViewComponent = null;

    public Presentation() {
        slideViewComponent = null;
        clearPresentation();
    }

    public void appendSlide(Slide slide) {
        slides.add(slide);
    }

    void clearPresentation() {
        slides = new ArrayList<Slide>();
        setSlideNumber(-1); //why is it -1 and not 0
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSize() {
        return slides.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String nt) {
        title = nt;
    }

    // give the number of the current slide
    public int getSlideNumber() {
        return currentSlideNumber;
    }

    // change the current slide number and signal it to the window
    public void setSlideNumber(int number) {
        currentSlideNumber = number;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    // go to the previous slide unless your at the beginning of the presentation
    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    // go to the next slide unless your at the end of the presentation.
    public void nextSlide() {
        if (currentSlideNumber < (slides.size()-1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    // Delete the presentation to be ready for the next one.


    // Get a slide with a certain slidenumber
    public Slide getSlide(int number) {
        if (number < 0 || number >= getSize()){
            return null;
        }
        return (Slide) slides.get(number);
    }

    // Give the current slide
    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    public void exit(int n) {
        System.exit(n);
    }
}
