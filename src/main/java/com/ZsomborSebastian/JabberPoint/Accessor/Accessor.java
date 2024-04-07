package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Accessor
{

  // Load a presentation file

  public abstract Presentation loadFile(String filename) throws FileNotFoundException;

  // Save a presentation file
  public abstract void saveFile(Presentation presentation, String fileName) throws IOException;
}
