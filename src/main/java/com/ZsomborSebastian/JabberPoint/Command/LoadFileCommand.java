package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;

public class LoadFileCommand extends AbstractFileCommand {

    public LoadFileCommand(XMLAccessor xmlAccessor) {
        super(xmlAccessor);
    }

    @Override
    public void execute() {
        String filename = null;
        XMLAccessor.loadFile(presentation, filename);
    }
}
