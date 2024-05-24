// AbstractCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.*;
import java.io.IOException;

public abstract class AbstractCommand implements Command
{

    protected Presentation presentation;

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    public AbstractCommand(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute() throws IOException;

}
