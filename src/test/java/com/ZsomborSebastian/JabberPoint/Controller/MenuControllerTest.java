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

//  @Test
//  void testSaveFile() throws IOException {
//    // We need to understand the real world effect of saveCommand's execute method
//    // For the purpose of this demo, let's assume it interacts with Presentation object
//    // So, when saveCommand.execute() is called, this mock will simulate the save operation on Presentation
//    doAnswer((i) -> {
//      System.out.println("Mocking save operation on Presentation object");
//      return null;
//    }).when(saveCommand).execute();
//
//    menuController.saveFile();
//
//    verify(saveCommand, times(1)).execute();
//  }
//
//  @Test
//  void testOpenFile() throws IOException {
//    // We need to understand the real world effect of loadCommand's execute method
//    // For the purpose of this demo, let's assume it interacts with Presentation object
//    // So, when loadCommand.execute() is called, this mock will simulate the load operation on Presentation
//    doAnswer((i) -> {
//      System.out.println("Mocking load operation on Presentation object");
//      return null;
//    }).when(loadCommand).execute();
//
//    menuController.openFile();
//
//    verify(loadCommand, times(1)).execute();
//  }
}
