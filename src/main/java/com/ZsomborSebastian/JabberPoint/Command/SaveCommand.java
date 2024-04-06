package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.IOException;

public class SaveCommand extends AbstractCommand {

  private String fileName;

  public SaveCommand(Presentation presentation, String fileName) {
    super(presentation);
    this.presentation = presentation;
    this.fileName = fileName;
  }

  @Override
  public void execute() throws IOException {
    // Just create an XMLAccessor when you need it.
    XMLAccessor xmlAccessor = new XMLAccessor();
    xmlAccessor.saveFile(presentation, fileName);
  }
}
