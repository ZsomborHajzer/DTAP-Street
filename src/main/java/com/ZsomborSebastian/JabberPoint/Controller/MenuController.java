package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuController extends MenuBar
{

    private Frame parent;
    private Presentation presentation;
    private XMLAccessor xmlAccessor;
    private final SaveCommand saveFileCommand;
    private final LoadCommand loadFileCommand;
    private final ClearCommand clearFileCommand;
    private final GoToCommand goToSlideCommand;
    private final ExitCommand exitProgramCommand;

    private static final long serialVersionUID = 227L;
    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String FORWARD = "Forward";
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
//        int slideToGo = 0;
        this.exitProgramCommand = exitProgramCommand;
        this.goToSlideCommand = goToSlideCommand;
        this.clearFileCommand = clearFileCommand;
        this.saveFileCommand = saveFileCommand;
        this.loadFileCommand = loadFileCommand;
        this.xmlAccessor = new XMLAccessor();
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
        fileMenu.add(createMenuItem(OPEN, e ->
        {
            try
            {
                openFile();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        ));
        fileMenu.add(createMenuItem(NEW, e -> clearPresentation()));
        fileMenu.add(createMenuItem(SAVE, e ->
        {
            try
            {
                saveFile();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        ));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(EXIT, e -> exit())); add(fileMenu);
    }

    public void addViewMenu()
    {
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(createMenuItem(FORWARD, e -> presentation.nextSlide()));
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

    public void clearPresentation()
    {
        clearFileCommand.execute();
    }

    protected File getSaveFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    protected File getOpenFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void saveFile() throws IOException
    {
        File file = getSaveFile();
        if (file != null)
        {
            saveFileCommand.setFile(file);
            saveFileCommand.execute();
        }
    }

    public void openFile() throws IOException
    {
        File file = getOpenFile();
        if (file != null)
        {
            loadFileCommand.setFile(file);
            loadFileCommand.execute();
        }
    }

    public void goToPage()
    {
        JTextField slideNumberInput = new JTextField();
        final JComponent[] inputs = new JComponent[]
        {
            new JLabel("Enter slide number:"),
            slideNumberInput
        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "Go to a specific slide", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION && !slideNumberInput.getText().trim().isEmpty())
        {
            int slideNumber = Integer.parseInt(slideNumberInput.getText());
            goToSlideCommand.setSlideToGo(slideNumber - 1);  // decrement slideNumber, slides are 0-indexed
            goToSlideCommand.execute();
        }
        else
        {
            goToSlideCommand.setSlideToGo(1);  // Set the default slide number to 1
            goToSlideCommand.execute();  // Execute the command
        }
    }

    public void exit()
    {
        exitProgramCommand.execute();
    }

    public MenuItem createMenuItem(String name, ActionListener listener)
    {
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(listener);
        return menuItem;
    }
}
