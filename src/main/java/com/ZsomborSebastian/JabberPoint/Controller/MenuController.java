package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.XMLAcccessorCommand;

import java.util.ArrayList;

public class MenuController {
    private ArrayList<XMLAcccessorCommand> menuCommands;

    public MenuController() {
        menuCommands = new ArrayList<>();
    }

    public ArrayList<XMLAcccessorCommand> getMenuCommands() {
        return menuCommands;
    }

    public void setMenuCommands(ArrayList<XMLAcccessorCommand> menuCommands) {
        this.menuCommands = menuCommands;
    }

    public void registerMenuCommand(XMLAcccessorCommand command){
        menuCommands.add(command);
    }
}
