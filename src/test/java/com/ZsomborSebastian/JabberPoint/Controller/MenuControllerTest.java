package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Controller.MenuController;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuControllerTest {

  private Frame frame;
  private Presentation presentation;
  private ClearCommand clearCommand;
  private GoToCommand goToCommand;
  private ExitCommand exitCommand;
  private SaveCommand saveCommand;
  private LoadCommand loadCommand;

  private MenuController menuController;

  @BeforeEach
  void setUp() {
    // Mock all dependencies
    frame = mock(Frame.class);
    presentation = mock(Presentation.class);
    clearCommand = mock(ClearCommand.class);
    goToCommand = mock(GoToCommand.class);
    exitCommand = mock(ExitCommand.class);
    saveCommand = mock(SaveCommand.class);
    loadCommand = mock(LoadCommand.class);

    // Instantiate MenuController with the mocked dependencies
    menuController =
        new MenuController(
            frame, presentation, clearCommand, goToCommand, exitCommand, saveCommand, loadCommand);
  }

  @Test
  void testClearPresentation() {
    menuController.clearPresentation();

    verify(clearCommand, times(1)).execute();
  }

  @Test
  void testGoToPage() {
    menuController.goToPage();

    verify(goToCommand, times(1)).execute();
  }

  @Test
  void testSaveFile() {
    // Assuming SaveCommand in MenuController is not null
    menuController.saveFile();

    // Left as TODO as we need to consider how to mock SaveCommand
    // to be able to test this function correctly
  }

  @Test
  void testOpenFile() throws IOException {
    // Assuming LoadCommand in MenuController is not null
    menuController.openFile();

    // Left as TODO as we need to consider how to mock LoadCommand
    // to be able to test this function correctly
  }
}
