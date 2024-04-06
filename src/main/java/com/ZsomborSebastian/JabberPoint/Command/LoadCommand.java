package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class LoadCommand extends AbstractCommand {

  private String fileName;

  public LoadCommand(Presentation presentation, String fileName) {
    super(presentation);
    this.presentation = presentation;
    this.fileName = fileName;
  }

  @Override
  public void execute() {
    // Just create it when you need it.
    XMLAccessor xmlAccessor = new XMLAccessor();
    xmlAccessor.loadFile(presentation, fileName);
  }
}
