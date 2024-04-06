// PreviousCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.*;

public class PreviousCommand extends AbstractCommand {

    public PreviousCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.previousSlide();
    }


}
