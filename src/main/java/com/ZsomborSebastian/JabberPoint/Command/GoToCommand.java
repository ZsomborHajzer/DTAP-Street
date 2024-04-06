package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class GoToCommand extends AbstractCommand
{

    private int slideToGo;

    public GoToCommand(Presentation presentation, int slideToGo)
    {
        super(presentation);
        this.slideToGo = slideToGo;
    }

    @Override
    public void execute()
    {
        if (slideToGo > 0)
        {
            presentation.setSlideNumber(slideToGo - 1);
        } else
        {
            throw new IllegalArgumentException("Invalid slide number");
        }
    }
}
