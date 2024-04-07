package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLAccessor extends Accessor
{

  public XMLAccessor()
  {

  }

  @Override
  public Presentation loadFile(String filename) throws FileNotFoundException
  {
    File file = new File(filename);
    if (!file.exists())
    {
      throw new FileNotFoundException("The specified file does not exist: " + filename);
    }

    Serializer serializer = new Persister();
    try
    {
      return serializer.read(Presentation.class, file);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void saveFile(Presentation p, String filename) throws IOException
  {
    File file = new File(filename);

    // Check for existing file, and create it if it does not exist
    if (!file.exists() && !file.createNewFile())
    {
      throw new FileNotFoundException("The specified file could not be created: " + filename);
    }

    Serializer serializer = new Persister();
    try
    {
      serializer.write(p, file);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
