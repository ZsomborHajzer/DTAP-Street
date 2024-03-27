package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.Command;
import com.ZsomborSebastian.JabberPoint.Command.PresentationCommand;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter {
    private Presentation presentation;
    private Map<Integer, PresentationCommand> commandMappings;

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

    public Map<Integer, PresentationCommand> getCommandMappings() {
        return commandMappings;
    }

    public void setCommandMappings(Map<Integer, PresentationCommand> commandMappings) {
        this.commandMappings = commandMappings;
    }

    public void registerCommand(int keyCode, PresentationCommand command) {
        commandMappings.put(keyCode, command);
    }

    public PresentationCommand getCommandForKey(int keyCode)
    {
        return commandMappings.get(keyCode);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        PresentationCommand command = commandMappings.get(keyCode);
        if (command != null) {
            command.execute();
        }
    }

}
