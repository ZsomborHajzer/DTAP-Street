package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.BlackSubtextStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BitMapItemTest {
    private BitMapItem bitMapItem;
    private final String imageName = "image2.png"; // Include extension and ensure the image exists in test resources

    @BeforeEach
    void setup() throws IOException
    {
        bitMapItem = new BitMapItem(new BlackSubtextStyle(), imageName); // Placeholder for actual Style object if needed
    }

    @Test
    void GetBufferedImage_CallGetMethod_ShouldPassWithExpectedValues() throws IOException {
        BufferedImage expectedImage = ImageIO.read(new File("src/main/resources/images/" + imageName));
        BufferedImage actualImage = bitMapItem.getBufferedImage();
        assertNotNull(actualImage);
        assertEquals(expectedImage.getWidth(), actualImage.getWidth());
        assertEquals(expectedImage.getHeight(), actualImage.getHeight());
    }

    @Test
    void setBufferedImage()
    {
        BufferedImage bufferedImage2 = new BufferedImage(1,1,1);
        this.bitMapItem.setBufferedImage(new BufferedImage(1,1,1));
        assertEquals(bufferedImage2.getHeight(),bitMapItem.getBufferedImage().getHeight());
        assertEquals(bufferedImage2.getWidth(),bitMapItem.getBufferedImage().getHeight());
        assertEquals(bufferedImage2.getType(),bitMapItem.getBufferedImage().getType());
    }

    @Test
    void getImageName()
    {
        assertEquals("image2.png", bitMapItem.getImageName());
    }

    @Test
    void setImageName()
    {
        this.bitMapItem.setImageName("test");
        assertEquals("test", bitMapItem.getImageName());
    }

    @Test
    void getBoundingBox()
    {
        Graphics graphics = mock(Graphics.class);
        ImageObserver observer = mock(ImageObserver.class);
        System.out.println(bitMapItem.getBoundingBox(graphics,observer,1));
        assertEquals(70, bitMapItem.getBoundingBox(graphics,observer,1).getX());
        assertEquals(0, bitMapItem.getBoundingBox(graphics,observer,1).getY());
        assertEquals(212, bitMapItem.getBoundingBox(graphics,observer,1).getWidth());
        assertEquals(141, bitMapItem.getBoundingBox(graphics,observer,1).getHeight());
    }

    @Test
    void draw()
    {
    }


    @Test
    void fetchImageStream_GivenValidImageName_ShouldReturnNonEmptyStream() throws IOException
    {
        // Arrange
        BitMapItem bitMapItem = new BitMapItem(new BlackSubtextStyle(),"image2.png");
        String validImageName = "image2.png";

        // Act
        InputStream resultStream = bitMapItem.fetchImageStream(validImageName);

        // Assert
        assertNotNull(resultStream, "The result should not be null for a valid image name.");
        assertTrue(resultStream.available() > 0, "The stream should have available bytes to read.");
    }


    @Test
    void readImageIO()
    {

    }
}