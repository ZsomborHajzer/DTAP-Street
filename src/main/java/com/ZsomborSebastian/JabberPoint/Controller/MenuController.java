package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuBar;

    public class MenuController extends MenuBar {

        private Frame parent;
        private Presentation presentation;

        protected static final String FILE = "File";
        protected static final String EXIT = "Exit";
        protected static final String OPEN = "Open";
        protected static final String NEW = "New";
        protected static final String SAVE = "Save";

        protected static final String IOEX = "IO Exception: ";
        protected static final String LOADERR = "Load Error";
        protected static final String SAVEERR = "Save Error";

        public MenuController(Frame frame, Presentation pres) {
            parent = frame;
            presentation = pres;
            MenuItem menuItem;
            Menu fileMenu = new Menu(FILE);
            fileMenu.add(menuItem = mkMenuItem(OPEN));
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    presentation.clear();
                    XMLAccessor xmlAccessor = new XMLAccessor();
                    XMLAccessor.loadFile(presentation, "test.xml");
                    presentation.setSlideNumber(0);
                    parent.repaint();
                }
            });
            fileMenu.add(String.valueOf(menuItem = mkMenuItem(NEW)));
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    presentation.clear();
                    parent.repaint();
                }
            });
            fileMenu.add(String.valueOf(menuItem = mkMenuItem(SAVE)));
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    XMLAccessor xmlAccessor = new XMLAccessor();
                    XMLAccessor.saveFile(presentation, "dump.xml");
                }
            });
            fileMenu.addSeparator();
            fileMenu.add(String.valueOf(menuItem = mkMenuItem(EXIT)));
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    presentation.exit(0);
                }
            });
            add(fileMenu);
        }

        public MenuItem mkMenuItem(String name) {
            return new MenuItem(name);
        }
    }

}
