package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.*;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

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
        String tempFilePath;
        try {
            // Create a temporary XML file
            File tempFile = File.createTempFile("tempFile", ".xml");
            try (Writer writer = new FileWriter(tempFile)) {
                // Write XML contents to the file
                writer.write("<presentation><presentationTitle>Test Presentation</presentationTitle><slides></slides><currentSlideNumber>0</currentSlideNumber></presentation>");
            }

            // Get the system-dependent file path
            tempFilePath = tempFile.getAbsolutePath();

            String finalTempFilePath = tempFilePath;
            Executable executable = () -> xmlAccessor.loadFile(finalTempFilePath);
            assertDoesNotThrow(executable, "Loading a valid XML file should not throw an exception");

            // Let's validate the content...
            Presentation loadedPresentation = xmlAccessor.loadFile(finalTempFilePath);
            assertNotNull(loadedPresentation, "Loaded file should not be null");
            assertEquals("Test Presentation", loadedPresentation.getPresentationTitle(), "Loaded presentation should have correct title");
            assertEquals(0, loadedPresentation.getSlideNumber(), "Loaded presentation should have 0 as the current slide number");
            assertTrue(loadedPresentation.getSlides().isEmpty(), "Loaded presentation should not contain slides");
            // Add more assertions as needed...

            // Delete the temporary file when done
            tempFile.delete();
        } catch (IOException e) {
            fail("Failed to create a temporary file");
        }
    }

    @Test
    void testSaveFile() {
        Executable executable = () -> xmlAccessor.saveFile(testPresentation, "testFile.xml");
        assertDoesNotThrow(executable, "Saving a valid Presentation should not throw an exception");

        // Let's validate the saved file...
        File savedFile = new File("testFile.xml");
        assertTrue(savedFile.exists(), "Saved file should exist");
        // Add more assertions to validate the content of the saved file...
    }
}