package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class GoToCommandTest {
    Presentation mockPresentation;

    @BeforeEach
    public void setup() {
        mockPresentation = mock(Presentation.class);
    }

    @AfterEach
    public void teardown() {
        mockPresentation = null;
    }

    @Test
    void execute() {
        int slideToGo = 2;
        GoToCommand cmd = new GoToCommand(mockPresentation, slideToGo);

        // Control the behavior of the mock object
        when(mockPresentation.getSlideNumber()).thenReturn(1);
        doNothing().when(mockPresentation).changeSlide(anyInt()); // modify this line

        // Act
        cmd.execute();

        // Assert
        verify(mockPresentation).changeSlide(slideToGo); // and this line
    }
}