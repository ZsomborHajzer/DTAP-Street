package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class JumpToSlideCommand extends AbstractSlideCommand {
    private int slideNumber;

    public JumpToSlideCommand(Presentation presentation) {
        super();
    }

    @Override
    public void execute() {
        presentation.jumpToSlide(slideNumber);
    }
}
