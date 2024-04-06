package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorAdapterTest {

    private DemoPresentation presentation;
    private XMLAccessorAdapter xmlAccessor;

    @BeforeEach
    void setUp() {
        this.xmlAccessor = new XMLAccessorAdapter();
        this.presentation = new DemoPresentation(this.xmlAccessor);
    }

    @Test
    void testLoadFile() {
        Executable executable = () -> xmlAccessor.loadFile(presentation, "testfile.xml");
        assertDoesNotThrow(executable, "Load file should not throw an exception for valid file");
    }

    @Test
    void testSaveFile() {
        Executable executable = () -> xmlAccessor.saveFile(presentation, "testfile.xml");
        assertDoesNotThrow(executable, "Save file should not throw an exception");
    }
}
