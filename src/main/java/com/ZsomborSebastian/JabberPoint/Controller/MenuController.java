package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.awt.*;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuController extends MenuBar
{

    private Frame parent;
    private Presentation presentation;
    private XMLAccessor xmlAccessor;
    private final SaveCommand SaveFileCommand;
    private final LoadCommand LoadFileCommand;
    private final ClearCommand ClearFileCommand;
    private final GoToCommand GoToSlideCommand;
    private final ExitCommand ExitProgramCommand;

    private static final long serialVersionUID = 227L;
    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";
    private final String fileName = "myFile.xml";

    public MenuController(
            Frame frame,
            Presentation pres,
            ClearCommand clearFileCommand,
            GoToCommand goToSlideCommand,
            ExitCommand exitProgramCommand,
            SaveCommand saveFileCommand,
            LoadCommand loadFileCommand)
    {
        parent = frame;
        presentation = pres;
        int slideToGo = 0;
        ExitProgramCommand = exitProgramCommand;
        GoToSlideCommand = goToSlideCommand;
        ClearFileCommand = clearFileCommand;
        SaveFileCommand = saveFileCommand;
        LoadFileCommand = loadFileCommand;
        initMenu();
    }

    public void initMenu()
    {
        addFileMenu();
        addViewMenu();
        addHelpMenu();
    }

    public void addFileMenu()
    {
        Menu fileMenu = new Menu(FILE);
        fileMenu.add(
                createMenuItem(
                        OPEN,
                        e ->
                        {
                            try
                            {
                                openFile();
                            } catch (IOException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }));
        fileMenu.add(createMenuItem(NEW, e -> clearPresentation()));
        fileMenu.add(createMenuItem(SAVE, e -> saveFile()));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(EXIT, e -> exit()));
        add(fileMenu);
    }

    public void addViewMenu()
    {
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(createMenuItem(NEXT, e -> presentation.nextSlide()));
        viewMenu.add(createMenuItem(PREV, e -> presentation.previousSlide()));
        viewMenu.add(createMenuItem(GOTO, e -> goToPage()));
        add(viewMenu);
    }

    public void addHelpMenu()
    {
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(createMenuItem(ABOUT, e -> AboutBox.show(parent)));
        setHelpMenu(helpMenu);
    }

    public void openFile() throws IOException
    {
        LoadFileCommand.execute();
    }

    public void clearPresentation()
    {
        ClearFileCommand.execute();
    }

    public void saveFile()
    {
        SaveFileCommand.execute();
    }

    public void goToPage()
    {
        GoToSlideCommand.execute();
    }

    public void exit()
    {
    }

    public MenuItem createMenuItem(String name, ActionListener listener)
    {
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(listener);
        return menuItem;
    }
}
