package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends AbstractCommand
{

    private File file;
    private XMLAccessor xmlAccessor;  // This should be initialized appropriately

    public LoadCommand(Presentation presentation, XMLAccessor xmlAccessor)
    {
        super(presentation);
        this.xmlAccessor = xmlAccessor;
    }

    // Add a setter for file if using one
    public void setFile(File file)
    {
        this.file = file;
    }

    @Override
    public void execute() throws IOException
    {
        if (file != null)
        {
            xmlAccessor.loadFile(file.getAbsolutePath());
        }
        else
        {
            throw new IOException("File is null");
        }
    }
}
