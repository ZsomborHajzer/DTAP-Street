// AbstractSlideCommand.java
package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

public abstract class AbstractSlideCommand implements Command {
    protected Presentation presentation;

    public AbstractSlideCommand() {
        this.presentation = presentation;
    }

    public void execute() {
        // Default implementation
    }
}
