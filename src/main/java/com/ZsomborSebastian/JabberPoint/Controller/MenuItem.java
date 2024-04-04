package com.ZsomborSebastian.JabberPoint.Controller;

import java.awt.event.ActionListener;

public class MenuItem {

    private String label;

    public MenuItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addActionListener(ActionListener actionListener) {
    }
}
