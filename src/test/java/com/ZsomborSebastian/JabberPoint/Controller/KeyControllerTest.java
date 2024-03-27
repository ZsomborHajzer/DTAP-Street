package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.*;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest {

    private Presentation testPresentation;
    private NextSlideCommand testNextSlideCommand;
    private PreviousSlideCommand testPreviousSlideCommand;
    private JumpToSlideCommand testJumpToSlideCommand;
    private KeyController testKeyController;

    @BeforeEach
    void setup()
    {
        testPresentation = new Presentation();
        testKeyController = new KeyController(testPresentation);
        testNextSlideCommand = new NextSlideCommand(testPresentation);
        testPreviousSlideCommand = new PreviousSlideCommand(testPresentation);
        testJumpToSlideCommand = new JumpToSlideCommand(testPresentation);

        testKeyController.registerCommand(KeyEvent.VK_RIGHT, testNextSlideCommand);
        testKeyController.registerCommand(KeyEvent.VK_LEFT, testPreviousSlideCommand);
        testKeyController.registerCommand(KeyEvent.VK_UP, testJumpToSlideCommand);
    }

    @Test
    public void getCommandForKey_rightArrowKeyToNextSlideCommand_GetRightArrowKey_expectSuccess()
    {

        PresentationCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_RIGHT);

        assertNotNull(registeredCommand);
        assertEquals(testNextSlideCommand, registeredCommand);
    }

    @Test
    public void getCommandForKey_getUnassignedArrowKey_expectNull() {

        PresentationCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_DOWN);

        assertNull(registeredCommand);
    }

    @Test
    public void keyPressed_keyPressedRightArrow_commandExecutes() {
        NextSlideCommand mockNextSlideCommand = mock(NextSlideCommand.class);

        testKeyController.registerCommand(KeyEvent.VK_RIGHT, mockNextSlideCommand);

        // Create a KeyEvent object representing a key press event for the right arrow key
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

        testKeyController.keyPressed(mockKeyEvent);

        verify(mockNextSlideCommand).execute();
    }

    @Test
    public void keyPressed_keyPressedUnmappedKey_noCommandExecutes() {
        NextSlideCommand testNextSlideCommand = mock(NextSlideCommand.class);
        PreviousSlideCommand testPreviousSlideCommand = mock(PreviousSlideCommand.class);
        JumpToSlideCommand testJumpToSlideCommand = mock(JumpToSlideCommand.class);

        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN); // Assuming VK_DOWN is not mapped

        testKeyController.keyPressed(mockKeyEvent);

        verifyNoInteractions(testNextSlideCommand, testPreviousSlideCommand, testJumpToSlideCommand);
    }

    @Test
    public void JumpToSlide_NavigatesToValidSlide() {

    }

    @Test
    public void JumpToSlide_NavigatesToInvalidSlide()
    {

    }
}