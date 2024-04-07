package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.IOException;

public class XMLAccessorAdapter
{

  private XMLAccessor xmlAccessor;
  private Presentation presentation;

  public XMLAccessorAdapter() throws Exception
  {
    this.xmlAccessor = new XMLAccessor();
    this.presentation = new DemoPresentation(this);
  }

  public Presentation loadFile(String filename) throws Exception
  {
    return xmlAccessor.loadFile(filename);
  }

  public void saveFile(String filename) throws Exception
  {
    xmlAccessor.saveFile(presentation, filename);
  }
}
