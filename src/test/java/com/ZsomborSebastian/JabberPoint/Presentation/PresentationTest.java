package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PresentationTest
{
    private Presentation presentation;

    @BeforeEach
    void setup()
    {
        this.presentation = new Presentation();
        presentation.setPresentationTitle("test");
        for (int i = 0; i < 5; i++)
        {
            Slide slide = new Slide();
            presentation.appendSlide(slide);
        }
    }

    @Test
    void getPresentationTitle_CallMethod_ShouldReturnBaseSetTitle()
    {
        assertEquals("test", this.presentation.getPresentationTitle());
    }

    @Test
    void setPresentationTitle_SetTitleNewTitle_ShouldAssertEqual()
    {
        this.presentation.setPresentationTitle("newTitle");
        assertEquals("newTitle", this.presentation.getPresentationTitle());
    }

    @Test
    void getSlideViewerComponent_WithoutViewerComponentSet_ShouldReturnZero()
    {
        assertEquals(null, this.presentation.getSlideViewerComponent());
    }

    @Test
    void getSlides_CountNumberOfSlides_ShouldBeFive()
    {
        assertEquals(5, this.presentation.getSlides().size());
    }

    @Test
    void setSlides_SetThreeNewSlides_SizeShouldEqualThree()
    {
        ArrayList<Slide> slide = new ArrayList<>();
        slide.add(new Slide());
        slide.add(new Slide());
        slide.add(new Slide());
        this.presentation.setSlides(slide);
        assertEquals(3, this.presentation.getSlides().size());
    }

    @Test
    void setSlides_NullSet_NullReturn()
    {
        this.presentation.setSlides(null);
        assertEquals(null, this.presentation.getSlides());
    }


    @Test
    void getSlideNumber_CallMethodShouldBeFirstSlide_ShouldReturnZero()
    {
        assertEquals(0, this.presentation.getSlideNumber());
    }

    @Test
    void getSlideNumber_IncreaseSlide_ShouldReturnCorrectIndex()
    {
        this.presentation.nextSlide();
        this.presentation.nextSlide();
        assertEquals(2, this.presentation.getSlideNumber());
    }

    @Test
    void getSlideNumber_NegativeSlideNumber_ShouldReturnZeroIndex()
    {
        this.presentation.previousSlide();
        assertEquals(0, this.presentation.getSlideNumber());
    }


    @Test
    void setSlideNumber_SetToTwo_ShouldReturnIndexTwo()
    {
        this.presentation.setSlideNumber(2);
        assertEquals(2, this.presentation.getSlideNumber());
    }

    @Test
    void setSlideNumber_SetToLessThanZero_ShouldThrowError()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.setSlideNumber(-5);
        });
    }


    @Test
    void setSlideNumber_SetToMoreThanMaxSlides_ShouldThrowError()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.setSlideNumber(9);
        });
    }


    @Test
    void changeSlide_SlideNumberMinus_ShouldThrowIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.changeSlide(-5);
        });
    }

    @Test
    void changeSlide_SlideNumberMOreThanNumberOfSlides_ShouldThrowIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.changeSlide(9);
        });
    }

    @Test
    void changeSlide_CorrectNumber_ShouldChangeSlideNumber()
    {
        this.presentation.changeSlide(3);
        assertEquals(3, this.presentation.getSlideNumber());
    }

    @Test
    void previousSlide_CallMethod_DecreaseSlideIndexByOne()
    {
        this.presentation.setSlideNumber(3);
        assertEquals(3, this.presentation.getSlideNumber());
        this.presentation.previousSlide();
        assertEquals(2, this.presentation.getSlideNumber());
    }

    @Test
    void previousSlide_IndexAtZero_ShouldDoNothing()
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.presentation.previousSlide();
        assertEquals(0, this.presentation.getSlideNumber());
    }

    @Test
    void nextSlide_CallMethod_ShouldIncreaseSlideIndex()
    {
        this.presentation.setSlideNumber(3);
        assertEquals(3, this.presentation.getSlideNumber());
        this.presentation.nextSlide();
        assertEquals(4, this.presentation.getSlideNumber());
    }

    @Test
    void nextSlide_CallMethodAtMaxIndex_ShouldDoNothing()
    {
        this.presentation.setSlideNumber(5);
        assertEquals(5, this.presentation.getSlideNumber());
        this.presentation.nextSlide();
        assertEquals(5, this.presentation.getSlideNumber());
    }

    @Test
    void resetPresentation_CallMethod_SlideArrayShouldBeEmptyNumberIndexShouldBeZero()
    {
        this.presentation.setSlideNumber(3);
        assertEquals(3, this.presentation.getSlideNumber());
        assertEquals(5, this.presentation.getNumberOfSlides());
        this.presentation.resetPresentation();
        assertEquals(0, this.presentation.getSlideNumber());
        assertEquals(0, this.presentation.getNumberOfSlides());
    }

    @Test
    void appendSlide_CallMethod_ShouldIncreaseNumberOfSlides()
    {
        assertEquals(5, this.presentation.getNumberOfSlides());
        this.presentation.appendSlide(new Slide());
        assertEquals(6, this.presentation.getNumberOfSlides());
    }

    @Test
    void getSlideObject_addNewSlide_ShouldBeSameSlide()
    {
        Slide slide = new Slide();
        this.presentation.appendSlide(slide);
        assertEquals(slide, this.presentation.getSlideObject(5));
    }

    @Test
    void getSlideObject_SlideNumberMoreThanMaxSlides_ShouldThrowIllegalArgumentExceptions()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.getSlideObject(7);
        });
    }

    @Test
    void getSlideObject_SlideNumberNegative_ShouldThrowIllegalArgumentExceptions()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.presentation.getSlideObject(-7);
        });
    }

    @Test
    void getCurrentSlide_BaseCase_ShouldReturnToZero()
    {
        Slide slide = new Slide();
        presentation.appendSlide(slide);
        presentation.setSlideNumber(5);
        assertEquals(slide,this.presentation.getCurrentSlide());
    }

    @Test
    void getNumberOfSlides_BAseCase_ShouldReturnFive()
    {
        assertEquals(5,this.presentation.getNumberOfSlides());
    }
}