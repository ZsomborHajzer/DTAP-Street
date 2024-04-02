package com.ZsomborSebastian.JabberPoint.Presentation.SlideItem;

import com.ZsomborSebastian.JabberPoint.Styles.Style;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BitMapItem extends SlideItem
{

    private BufferedImage bufferedImage;
    private String imageName;

    public BitMapItem(Style style, String imageName) throws IOException //Q try catch block or IOException signature
    {
        super(style);
        this.imageName = imageName;
        // change image import method to work with packaged jar files
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream(imageName); //FIX create image folder in resources and add it to the path here
        if (imageStream == null)
        {
            throw new IOException("Image file not found in resources: " + imageName);
        }
        this.bufferedImage = ImageIO.read(imageStream);
    }

    public BufferedImage getBufferedImage()
    {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage)
    {
        this.bufferedImage = bufferedImage;
    }

    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        if (imageName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid input");
        }
        this.imageName = imageName;
    }

    //FIX graphics argument not needed here
    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        return new Rectangle((int) (style.getIndent() * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (style.getFontSize() * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getFontSize() * scale);
        graphics.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }


}
