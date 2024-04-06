package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Command.AbstractCommand;
import com.ZsomborSebastian.JabberPoint.Command.GoToCommand;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest {

  private Presentation testPresentation;
  private NextCommand testNextSlideCommand;
  private PreviousCommand testPreviousSlideCommand;
  private GoToCommand testGoToSlideCommand;
  private KeyController testKeyController;


  @BeforeEach
  void setup() {
    int slideToGo = 0;
    testPresentation = new Presentation();
    testKeyController = new KeyController(testPresentation);
    testNextSlideCommand = new NextCommand(testPresentation);
    testPreviousSlideCommand = new PreviousCommand(testPresentation);
    testGoToSlideCommand = new GoToCommand(testPresentation, slideToGo);
    testKeyController.registerSlideCommand(KeyEvent.VK_RIGHT, testNextSlideCommand);
    testKeyController.registerSlideCommand(KeyEvent.VK_LEFT, testPreviousSlideCommand);
    testKeyController.registerSlideCommand(KeyEvent.VK_UP, testGoToSlideCommand);
  }

  @Test
  public void getCommandForKey_rightArrowKeyToNextSlideCommand_GetRightArrowKey_expectSuccess() {

    AbstractCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_RIGHT);

    assertNotNull(registeredCommand);
    assertEquals(testNextSlideCommand, registeredCommand);
  }

  @Test
  public void getCommandForKey_getUnassignedArrowKey_expectNull() {

    AbstractCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_DOWN);

    assertNull(registeredCommand);
  }

  @Test
  public void keyPressed_keyPressedRightArrow_commandExecutes() {
    NextCommand mockNextSlideCommand = mock(NextCommand.class);

    testKeyController.registerSlideCommand(KeyEvent.VK_RIGHT, mockNextSlideCommand);

    // Create a KeyEvent object representing a key press event for the right arrow key
    KeyEvent mockKeyEvent = mock(KeyEvent.class);
    when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

    testKeyController.keyPressed(mockKeyEvent);

    verify(mockNextSlideCommand).execute();
  }

  @Test
  public void keyPressed_keyPressedUnmappedKey_noCommandExecutes() {
    NextCommand testNextSlideCommand = mock(NextCommand.class);
    PreviousCommand testPreviousSlideCommand = mock(PreviousCommand.class);
    GoToCommand testGoToSlideCommand = mock(GoToCommand.class);

    KeyEvent mockKeyEvent = mock(KeyEvent.class);
    when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN); // Assuming VK_DOWN is not mapped

    testKeyController.keyPressed(mockKeyEvent);

    verifyNoInteractions(testNextSlideCommand, testPreviousSlideCommand, testGoToSlideCommand);
  }

  @Test
  public void JumpToSlide_NavigatesToValidSlide() {}

  @Test
  public void JumpToSlide_NavigatesToInvalidSlide() {}
}
