package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;

public abstract class AbstractFileCommand extends AbstractSlideCommand implements Command
{
    private XMLAccessor xmlAccessor;

    public AbstractFileCommand(XMLAccessor xmlAccessor) {
        super();
    }
}
