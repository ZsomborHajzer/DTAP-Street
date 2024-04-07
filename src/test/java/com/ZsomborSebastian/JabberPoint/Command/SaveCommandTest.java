package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Command.SaveCommand;
import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SaveCommandTest {

    private SaveCommand saveCommand;
    private Presentation mockPresentation;
    private XMLAccessor mockXMLAccessor;

    @BeforeEach
    void setUp() {
        mockPresentation = mock(Presentation.class);
        mockXMLAccessor = mock(XMLAccessor.class);
        saveCommand = new SaveCommand(mockPresentation, mockXMLAccessor); // notice change here
    }

    @Test
    void execute_WithAValidFile_WillCallSaveFile(@TempDir Path tempDir) throws IOException {
        File tempFile = tempDir.resolve("tempFile.xml").toFile();
        saveCommand.setXmlAccessor(mockXMLAccessor);  // Injecting the mock, this method must be public
        saveCommand.setFile(tempFile);

        saveCommand.execute();

        verify(mockXMLAccessor).saveFile(mockPresentation, tempFile.getAbsolutePath());
    }

    @Test
    void execute_WithNoFile_WillThrowIOException() {
        assertThrows(IOException.class, () -> saveCommand.execute());
    }
}