// NextCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class NextCommand extends AbstractCommand
{

    public NextCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        if (presentation.getSlideNumber() + 1 < presentation.getNumberOfSlides())
        {
            System.out.println(presentation.getSlideNumber());
            presentation.nextSlide();
        }
    }
}
