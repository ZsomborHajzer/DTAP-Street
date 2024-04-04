package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;

public class SaveFileCommand extends AbstractFileCommand {

    public SaveFileCommand(XMLAccessor xmlAccessor) {
        super(xmlAccessor);
    }

    @Override
    public void execute() {
        String filename = null;
        XMLAccessor.saveFile(presentation, filename);
    }
}
