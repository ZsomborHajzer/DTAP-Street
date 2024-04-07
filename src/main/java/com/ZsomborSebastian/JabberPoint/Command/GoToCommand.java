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

    public void setSlideToGo(int slideToGo)
    {
        this.slideToGo = slideToGo;
    }

    @Override
    public void execute()
    {
        presentation.changeSlide(slideToGo);
    }
}
