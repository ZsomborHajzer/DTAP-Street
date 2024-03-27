package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;

public abstract class XMLAcccessorCommand implements Command
{
    protected XMLAccessor xmlAccessor;

    public XMLAcccessorCommand(XMLAccessor xmlAccessor) {
        this.xmlAccessor = xmlAccessor;
    }
}
