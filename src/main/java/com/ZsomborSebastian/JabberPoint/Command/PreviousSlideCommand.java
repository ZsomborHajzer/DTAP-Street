// PreviousSlideCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class PreviousSlideCommand extends PresentationCommand {

    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.showPreviousSlide();
    }
}