package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemoPresentationTest {

    private DemoPresentation demoPresentation;
    private XMLAccessorAdapter xmlAccessorAdapter;

    @BeforeEach
    void setUp() {
        xmlAccessorAdapter = mock(XMLAccessorAdapter.class);
        demoPresentation = new DemoPresentation(xmlAccessorAdapter);
    }

    @Test
    void testDemoPresentationInitialization() {
        assertEquals("Demo Presentation", demoPresentation.getPresentationTitle());
        assertNotNull(demoPresentation.getSlides());
        assertEquals(5, demoPresentation.getSlides().size());
    }

    @Test
    void testLoadFile() throws Exception {
        demoPresentation.loadFile("testFile.xml");
        verify(xmlAccessorAdapter, times(1)).loadFile("testFile.xml");
    }

    @Test
    void testSaveFile() throws Exception {
        demoPresentation.saveFile("testFile.xml");
        verify(xmlAccessorAdapter, times(1)).saveFile("testFile.xml");
    }
}