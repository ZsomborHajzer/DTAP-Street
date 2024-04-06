package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class XMLAccessorTest {

    private XMLAccessor xmlAccessor;
    private Presentation testPresentation;

    @BeforeEach
    void setUp() {
        xmlAccessor = new XMLAccessor();
        testPresentation = new Presentation(); // assuming a parameterless constructor
        // Add setup logic for the testPresentation if needed
    }

    @Test
    void testLoadFile() {
        Executable executable = () -> xmlAccessor.loadFile(testPresentation, "testFile.xml");
        assertDoesNotThrow(executable, "Loading a valid XML file should not throw an exception");
    }

    @Test
    void testSaveFile() {
        Executable executable = () -> xmlAccessor.saveFile(testPresentation, "testFile.xml");
        assertDoesNotThrow(executable, "Saving a valid Presentation should not throw an exception");
    }
}