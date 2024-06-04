package com.ZsomborSebastian.JabberPoint;
import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;
import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Slide;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideBuilder;
import com.ZsomborSebastian.JabberPoint.SlideViewer.SlideViewerFrame;
import com.ZsomborSebastian.JabberPoint.Styles.StylesFactory;
import com.ZsomborSebastian.JabberPoint.Styles.StyleTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JabberPointTest {

    private XMLAccessorAdapter xmlAccessorAdapter;
    private DemoPresentation demoPresentation;
    private StylesFactory stylesFactory;

    @BeforeEach
    void setUp() {
        xmlAccessorAdapter = mock(XMLAccessorAdapter.class);
        demoPresentation = new DemoPresentation(xmlAccessorAdapter);
        stylesFactory = new StylesFactory();
    }

    @Test
    void testDemoPresentation() {
        SlideBuilder builder = new SlideBuilder(demoPresentation);
        Slide slide = buildSlide(builder, "Builder Slide", "image2.png", "This was built using a builder...");
        Slide slide2 = buildSlide(builder, "Second Slide", null, "This is the second slide");
        Slide slide3 = buildSlide(builder, "See If I broke anything...", "image2.png", "Yeet");

        assertNotNull(slide, "Slide should not be null");
        assertNotNull(slide2, "Slide2 should not be null");
        assertNotNull(slide3, "Slide3 should not be null");
    }

    @Test
    void testSlideViewerFrame() {
        SlideViewerFrame frame = new SlideViewerFrame("test", demoPresentation);
        assertNotNull(frame, "SlideViewerFrame should not be null");
    }

    @Test
    void testXmlAccessor() throws Exception {
        String filename = "default.xml";
        Presentation presentation = new Presentation();

        when(xmlAccessorAdapter.loadFile(filename)).thenReturn(presentation);

        Presentation loadedPresentation = xmlAccessorAdapter.loadFile(filename);
        assertNotNull(loadedPresentation, "Loaded presentation should not be null");
        assertEquals(presentation, loadedPresentation, "Loaded presentation should match the expected presentation");

        xmlAccessorAdapter.saveFile(filename);
        verify(xmlAccessorAdapter, times(1)).saveFile(filename);
    }

    private Slide buildSlide(SlideBuilder builder, String title, String imageName, String text) {
        builder.setSlideTitle(title);
        if (imageName != null) {
            builder.addBitMapItem(stylesFactory.createStyle(StyleTypes.BLACK_SUBTEXT), imageName);
        }
        builder.addTextItem(text, stylesFactory.createStyle(StyleTypes.BLUE_HEADING));
        builder.addTextItem("another Text item", stylesFactory.createStyle(StyleTypes.RED_TITLE));
        return builder.build();
    }
}