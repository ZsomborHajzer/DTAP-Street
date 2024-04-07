package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Controller.MenuController;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
    try(MockedStatic<JOptionPane> mockedStatic = mockStatic(JOptionPane.class)) {
      // suggest the mock to return an option OK
      mockedStatic.when(() -> JOptionPane.showConfirmDialog(any(), any(), any(), anyInt())).thenReturn(JOptionPane.OK_OPTION);

      menuController.goToPage();
      verify(goToCommand, times(1)).execute();
    }
  }

  @Test
   void testSaveFile() throws IOException {
      File tempFile = File.createTempFile("temp", ".xml");
      tempFile.deleteOnExit();

      MenuController spyController = Mockito.spy(menuController);
      doReturn(tempFile).when(spyController).getSaveFile();

      spyController.saveFile();
      verify(saveCommand, times(1)).execute();
   }
}
