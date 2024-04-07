package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.AbstractCommand;
import com.ZsomborSebastian.JabberPoint.Command.NextCommand;
import com.ZsomborSebastian.JabberPoint.Command.PreviousCommand;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter
{
    private Presentation presentation;
    private Map<Integer, AbstractCommand> commandMappings;

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
        this.commandMappings = new HashMap<>();
        this.registerSlideCommand(KeyEvent.VK_RIGHT, new NextCommand(this.presentation));
        this.registerSlideCommand(KeyEvent.VK_PAGE_DOWN, new NextCommand(this.presentation));
        this.registerSlideCommand(KeyEvent.VK_SPACE, new NextCommand(this.presentation));
        this.registerSlideCommand(KeyEvent.VK_LEFT, new PreviousCommand(this.presentation));
        this.registerSlideCommand(KeyEvent.VK_PAGE_UP, new PreviousCommand(this.presentation));
    }

    public Presentation getPresentation()
    {
        return presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public Map<Integer, AbstractCommand> getCommandMappings()
    {
        return commandMappings;
    }

    public void setCommandMappings(Map<Integer, AbstractCommand> commandMappings)
    {
        this.commandMappings = commandMappings;
    }

    public void registerSlideCommand(int keyCode, AbstractCommand command)
    {
        commandMappings.put(keyCode, command);
    }

    public AbstractCommand getCommandForKey(int keyCode)
    {
        return commandMappings.get(keyCode);
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        int keyCode = keyEvent.getKeyCode();
        AbstractCommand command = commandMappings.get(keyCode);
        if (command != null)
        {
            try
            {
                command.execute();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
