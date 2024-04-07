package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.*;

public class ExitCommand extends AbstractCommand implements Command
{

    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        System.exit(0);
    }
}
