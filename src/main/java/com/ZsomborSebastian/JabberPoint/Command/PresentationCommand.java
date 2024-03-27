// PresentationCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public abstract class PresentationCommand {
    protected Presentation presentation;

    public PresentationCommand(Presentation presentation) {
        this.presentation = presentation;
    }

    public void execute() {
        // Default implementation
    }
}
