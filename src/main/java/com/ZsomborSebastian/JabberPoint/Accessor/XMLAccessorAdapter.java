package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;

import java.io.IOException;

public class XMLAccessorAdapter {

  private XMLAccessor xmlAccessor;

  public XMLAccessorAdapter() {
    this.xmlAccessor = new XMLAccessor();
  }

  public void loadFile(DemoPresentation p, String fn) throws IOException {
    xmlAccessor.loadFile(p, fn);
  }

  public void saveFile(DemoPresentation p, String fn) throws IOException {
    xmlAccessor.saveFile(p, fn);
  }
}
