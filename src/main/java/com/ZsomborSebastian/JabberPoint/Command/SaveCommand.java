package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends AbstractCommand
{

    private File file;
    private XMLAccessor xmlAccessor;  // This should be initialized appropriately

    public SaveCommand(Presentation presentation, XMLAccessor xmlAccessor)
    {
        super(presentation);
        this.xmlAccessor = new XMLAccessor();
    }

    // Add a setter for file
    public void setFile(File file)
    {
        this.file = file;
    }

  @Override
  public void execute() throws IOException
  {
    if (file != null)
    {
      this.xmlAccessor.saveFile(presentation, file.getAbsolutePath());
    }
    else
    {
      throw new IOException("File is null");
    }
  }
}
