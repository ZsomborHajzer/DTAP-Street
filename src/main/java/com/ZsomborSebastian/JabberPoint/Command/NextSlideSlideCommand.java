// NextSlideSlideCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class NextSlideSlideCommand extends AbstractSlideCommand {

    public NextSlideSlideCommand(Presentation presentation) {
        super();
    }

    @Override
    public void execute() {
        presentation.showNextSlide();
    }
}
