package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorAdapterTest {

    private XMLAccessorAdapter xmlAccessor;
    private Presentation testPresentation;

    @BeforeEach
    void setUp() throws Exception {
        this.xmlAccessor = new XMLAccessorAdapter();

    }

    @Test
    void testLoadFile() {
        Executable executable = () -> xmlAccessor.loadFile("testfile.xml");

        try {
            assertDoesNotThrow(executable, "Load file should not throw an exception for valid file");
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            throw t;
        }
    }

    @Test
    void testSaveFile() {
        Executable executable = () -> xmlAccessor.saveFile("testfile.xml");

        try {
            assertDoesNotThrow(executable, "Save file should not throw an exception");
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            throw t;
        }
    }
}
