package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.RedTitleStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;

import java.io.IOException;

public class DemoPresentation extends Presentation {

  private XMLAccessorAdapter xmlAccessorAdapter;

  public DemoPresentation(XMLAccessorAdapter xmlAccessorAdapter) {
    this.setPresentationTitle("Demo Presentation");
    this.xmlAccessorAdapter = xmlAccessorAdapter;
    createSlides();
  }

  public void loadFile(Presentation presentation, String unsusedFilename) throws IOException {
    xmlAccessorAdapter.loadFile(this, unsusedFilename);
  }

  public void saveFile(Presentation presentation, String unsusedFilename) throws IOException {
    xmlAccessorAdapter.saveFile(this, unsusedFilename);
  }

  private void createSlides() {
    Slide slide;
    SlideItem slideItem;
    Style style;

    // Create and append first slide
    slide = new Slide();
    slide.setSlideTitle("Slide 1 Title");
    slideItem = new TextItem("Slide 1 Content", new RedTitleStyle());
    slide.appendSlideItem(slideItem);
    this.appendSlide(slide);

    // Create and append second slide
    slide = new Slide();
    slide.setSlideTitle("Slide 2 Title");
    slideItem = new TextItem("Slide 2 Content", new RedTitleStyle());
    slide.appendSlideItem(slideItem);
    this.appendSlide(slide);

    // Create and append third slide
    slide = new Slide();
    slide.setSlideTitle("Slide 3 Title");
    slideItem = new TextItem("Slide 3 Content", new RedTitleStyle());
    slide.appendSlideItem(slideItem);
    this.appendSlide(slide);
  }

  }