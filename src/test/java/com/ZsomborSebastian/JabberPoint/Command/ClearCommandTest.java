package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClearCommandTest
{
    Presentation mockPresentation;

    @BeforeEach
    public void setup()
    {
        mockPresentation = mock(Presentation.class);
    }

    @AfterEach
    public void teardown()
    {
        mockPresentation = null;
    }

    @Test
    public void testClearCommandPresentationNotNull()
    {
        // Arrange
        ClearCommand cmd = new ClearCommand(mockPresentation);

        // Control behavior of mock object
        doNothing().when(mockPresentation).resetPresentation();

        // Act and Assert
        try
        {
            cmd.execute();
        } catch (IllegalArgumentException e)
        {
            fail("Presentation is null");
        }

        // Assert
        verify(mockPresentation).resetPresentation();
    }
}