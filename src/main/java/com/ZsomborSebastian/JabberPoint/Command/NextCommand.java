// NextCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public class NextCommand extends AbstractCommand {

    public NextCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.nextSlide();;
    }

}
