package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoadCommandTest {

    private LoadCommand loadCommand;
    private Presentation mockPresentation;
    private XMLAccessor mockXMLAccessor;

    @BeforeEach
    void setUp() {
        mockPresentation = mock(Presentation.class);
        mockXMLAccessor = mock(XMLAccessor.class);
        loadCommand = new LoadCommand(mockPresentation, mockXMLAccessor);
    }

    @Test
    void execute_WithValidFile_ShouldLoadFile(@TempDir Path tempDir) throws Exception {
        File tempFile = tempDir.resolve("tempFile.xml").toFile();
        loadCommand.setFile(tempFile);

        loadCommand.execute();

        verify(mockXMLAccessor).loadFile(tempFile.getAbsolutePath());
    }

    @Test
    void execute_WithNoFile_ShouldThrowException() {
        assertThrows(IOException.class, () -> loadCommand.execute());
    }
}