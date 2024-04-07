package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

// Add these additional imports for your File instance
import java.io.File;
import java.io.IOException;
import static org.mockito.ArgumentMatchers.any;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCommandClasses
{
    private Presentation mockPresentation;
    private XMLAccessor mockXMLAccessor;
    private File mockFile;

    @BeforeEach
    public void setup() throws IOException {
        mockPresentation = mock(Presentation.class);
        mockXMLAccessor = mock(XMLAccessor.class);

        when(mockXMLAccessor.loadFile(any(String.class))).thenReturn(mockPresentation);
        doNothing().when(mockXMLAccessor).saveFile(any(Presentation.class), any(String.class));
    }
    @AfterEach
    public void teardown()
    {
        mockPresentation = null;
    }

//    @Test
//    public void testSaveCommand() {
//        try {
//            SaveCommand saveCmd = new SaveCommand(mockPresentation, mockXMLAccessor);
//            // Create temporary file
//            File tempFile = Files.createTempFile("temp",".xml").toFile();
//            // This should prevent JAXB exceptions
//            doNothing().when(mockXMLAccessor).saveFile(any(Presentation.class), any(String.class));
//            // Set file to the command
//            saveCmd.setFile(tempFile);
//            saveCmd.execute();
//            verify(mockXMLAccessor).saveFile(any(Presentation.class),any(String.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testLoadCommand() throws IOException {
//        LoadCommand loadCmd = new LoadCommand(mockPresentation, mockXMLAccessor);
//        // Create temporary file
//        File tempFile = Files.createTempFile("temp",".xml").toFile();
//        // Set file to the command
//        loadCmd.setFile(tempFile);
//        loadCmd.execute();
//        verify(mockXMLAccessor).loadFile(any(String.class));
//    }

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

    @Test
    public void testClearCommandPresentationNull()
    {
        // Arrange
        ClearCommand cmd = new ClearCommand(null);

        // Act & Assert: IllegalArgumentException is thrown
        assertThrows(
                IllegalArgumentException.class,
                new Executable()
                {
                    public void execute()
                    {
                        cmd.execute();
                    }
                });
    }

    @Test
    public void testGoToCommand() {
        // Arrange
        int slideToGo = 2;
        GoToCommand cmd = new GoToCommand(mockPresentation, slideToGo);

        // Control the behavior of the mock object
        when(mockPresentation.getSlideNumber()).thenReturn(1);
        doNothing().when(mockPresentation).changeSlide(anyInt());

        // Act
        cmd.execute();

        // Assert
        verify(mockPresentation).changeSlide(slideToGo);
    }

}


//}