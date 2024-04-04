package com.ZsomborSebastian.JabberPoint.Presentation;

import java.util.ArrayList;

public class Presentation {

    private int currentSlideIndex;

    private ArrayList<Slide> slides;

    public Presentation() {
    }

    public ArrayList<Slide> getSlides() {
        return slides;
    }

    public void setSlides(ArrayList<Slide> slides) {
        this.slides = slides;
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

    public void setSlideNumber(int i) {
    }

    public void exit(int i) {
    }
}
