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

    public BitMapItem(Style style, String imageName) throws IOException
    {
        super(style);
        this.imageName = imageName;
        this.bufferedImage = readImageIO(fetchImageStream(imageName));
    }

    public BufferedImage getBufferedImage()
    {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage)
    {
        if (bufferedImage == null)
        {
            throw new NullPointerException("Image can't be null");
        }
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

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        return new Rectangle(floatToInt(style.getIndent() * scale), 0,
                floatToInt(bufferedImage.getWidth(observer) * scale),
                (floatToInt(style.getFontSize() * scale)) +
                        floatToInt(bufferedImage.getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {
        int width = x + floatToInt(style.getIndent() * scale);
        int height = y + floatToInt(style.getFontSize() * scale);
        graphics.drawImage(bufferedImage, width, height, floatToInt(bufferedImage.getWidth(observer) * scale),
                floatToInt(bufferedImage.getHeight(observer) * scale), observer);
    }

    public InputStream fetchImageStream(String imageName)
    {
        return getClass().getClassLoader().getResourceAsStream("images/" + imageName);
    }

    public BufferedImage readImageIO(InputStream imageStream)
    {
        try
        {
            return ImageIO.read(imageStream);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
