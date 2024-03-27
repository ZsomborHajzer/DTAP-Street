package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class JumpToSlideCommand extends PresentationCommand{
    private int slideNumber;

    public JumpToSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.jumpToSlide(slideNumber);
    }
}
