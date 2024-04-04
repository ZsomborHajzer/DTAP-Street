// PreviousSlideSlideCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class PreviousSlideSlideCommand extends AbstractSlideCommand {

    public PreviousSlideSlideCommand(Presentation presentation) {
        super();
    }

    @Override
    public void execute() {
        presentation.showPreviousSlide();
    }
}
