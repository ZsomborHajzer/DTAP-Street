package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.AbstractSlideCommand;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter {
    private Presentation presentation;
    private Map<Integer, AbstractSlideCommand> commandMappings;

    public KeyController(Presentation presentation) {
        this.presentation = presentation;
        this.commandMappings = new HashMap<>();
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Map<Integer, AbstractSlideCommand> getCommandMappings() {
        return commandMappings;
    }

    public void setCommandMappings(Map<Integer, AbstractSlideCommand> commandMappings) {
        this.commandMappings = commandMappings;
    }

    public void registerSlideCommand(int keyCode, AbstractSlideCommand command) {
        commandMappings.put(keyCode, command);
    }

    public AbstractSlideCommand getCommandForKey(int keyCode)
    {
        return commandMappings.get(keyCode);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractSlideCommand command = commandMappings.get(keyCode);
        if (command != null) {
            command.execute();
        }
    }

}
