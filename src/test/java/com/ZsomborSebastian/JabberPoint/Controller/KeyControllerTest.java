package com.ZsomborSebastian.JabberPoint.Controller;

import com.ZsomborSebastian.JabberPoint.Command.AbstractSlideCommand;
import com.ZsomborSebastian.JabberPoint.Command.JumpToSlideCommand;
import com.ZsomborSebastian.JabberPoint.Command.NextSlideSlideCommand;
import com.ZsomborSebastian.JabberPoint.Command.PreviousSlideSlideCommand;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest {

    private Presentation testPresentation;
    private NextSlideSlideCommand testNextSlideCommand;
    private PreviousSlideSlideCommand testPreviousSlideCommand;
    private JumpToSlideCommand testJumpToSlideCommand;
    private KeyController testKeyController;

    @BeforeEach
    void setup()
    {
        testPresentation = new Presentation();
        testKeyController = new KeyController(testPresentation);
        testNextSlideCommand = new NextSlideSlideCommand(testPresentation);
        testPreviousSlideCommand = new PreviousSlideSlideCommand(testPresentation);
        testJumpToSlideCommand = new JumpToSlideCommand(testPresentation);

        testKeyController.registerSlideCommand(KeyEvent.VK_RIGHT, testNextSlideCommand);
        testKeyController.registerSlideCommand(KeyEvent.VK_LEFT, testPreviousSlideCommand);
        testKeyController.registerSlideCommand(KeyEvent.VK_UP, testJumpToSlideCommand);
    }

    @Test
    public void getCommandForKey_rightArrowKeyToNextSlideCommand_GetRightArrowKey_expectSuccess()
    {

        AbstractSlideCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_RIGHT);

        assertNotNull(registeredCommand);
        assertEquals(testNextSlideCommand, registeredCommand);
    }

    @Test
    public void getCommandForKey_getUnassignedArrowKey_expectNull() {

        AbstractSlideCommand registeredCommand = testKeyController.getCommandForKey(KeyEvent.VK_DOWN);

        assertNull(registeredCommand);
    }

    @Test
    public void keyPressed_keyPressedRightArrow_commandExecutes() {
        NextSlideSlideCommand mockNextSlideCommand = mock(NextSlideSlideCommand.class);

        testKeyController.registerSlideCommand(KeyEvent.VK_RIGHT, mockNextSlideCommand);

        // Create a KeyEvent object representing a key press event for the right arrow key
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

        testKeyController.keyPressed(mockKeyEvent);

        verify(mockNextSlideCommand).execute();
    }

    @Test
    public void keyPressed_keyPressedUnmappedKey_noCommandExecutes() {
        NextSlideSlideCommand testNextSlideCommand = mock(NextSlideSlideCommand.class);
        PreviousSlideSlideCommand testPreviousSlideCommand = mock(PreviousSlideSlideCommand.class);
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