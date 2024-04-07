package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.*;

public class ClearCommand extends AbstractCommand implements Command
{

    private Frame parent;

    public ClearCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        if (this.presentation != null)
        {
            this.presentation.resetPresentation();
        }
        else
        {
            throw new IllegalArgumentException("Presentation is null");
        }
    }
}
