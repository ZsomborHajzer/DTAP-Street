package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.IOException;

public abstract class Accessor {

  // Load a presentation file
  public abstract void loadFile(Presentation p, String fn) throws IOException;

  // Save a presentation file
  public abstract void saveFile(Presentation p, String fn) throws IOException;
}
