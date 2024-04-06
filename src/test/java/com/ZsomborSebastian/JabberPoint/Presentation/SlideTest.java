package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.RedTitleStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.security.PrivateKey;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlideTest
{
    private Slide slide;
    private Presentation presentation;
    private Style style;

    @BeforeEach
    void setup()
    {
        this.slide = new Slide();
        this.presentation = new Presentation();
        this.style = new RedTitleStyle();


        this.slide.setSlideTitle("test");
    }

    @Test
    void getItems_ItemsExist_ShouldReturnTwoItems()
    {
        TextItem textItem = new TextItem("test", style);
        TextItem textItem1 = new TextItem("test", style);
        this.slide.appendSlideItem(textItem);
        this.slide.appendSlideItem(textItem1);
        assertEquals(2, this.slide.getItems().size());
    }

    @Test
    void getItems_NoItemsInList_ShouldReturnZero()
    {
        assertEquals(0, this.slide.getItems().size());
    }

    @Test
    void setItems_AddThreeItemsAsArray_SizeShouldEqualThree()
    {
        Vector<SlideItem> vector = new Vector<>();
        for (int i = 0; i < 3; i++)
        {
            TextItem textItem = new TextItem("test", style);
            vector.add(textItem);
        }
        this.slide.setItems(vector);
        assertEquals(3, this.slide.getItems().size());
    }

    @Test
    void getSlideTitle_CallMethod_ShouldReturnTestTitle()
    {
        assertEquals("test", this.slide.getSlideTitle());
    }

    @Test
    void setSlideTitle_OverwriteCurrentTitle_ReturnsNewTitle()
    {
        this.slide.setSlideTitle("newTitle");
        assertEquals("newTitle", this.slide.getSlideTitle());
    }

    @Test
    void setSlideTitle_NoInputTitle_ShouldThrowIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
          this.slide.setSlideTitle("");
        });
    }

    @Test
    void appendSlideItem_AddingThreeItems_SizeShouldEqualThree()
    {
        for (int i = 0; i < 3; i++)
        {
            TextItem textItem = new TextItem("test", style);
            this.slide.appendSlideItem(textItem);
        }
        assertEquals(3, this.slide.getItems().size());
    }

    @Test
    void getSpecificSlideItem_SetSLideItemInOrder_ShouldMatchTheirIndex()
    {
        TextItem textItem = new TextItem("test", style);
        TextItem textItem2 = new TextItem("test", style);
        TextItem textItem3 = new TextItem("test", style);
        this.slide.appendSlideItem(textItem);
        this.slide.appendSlideItem(textItem2);
        this.slide.appendSlideItem(textItem3);
        assertEquals(textItem, this.slide.getSpecificSlideItem(0));
        assertEquals(textItem2, this.slide.getSpecificSlideItem(1));
        assertEquals(textItem3, this.slide.getSpecificSlideItem(2));

    }

    @Test
    void getAllSlideItems_AssignAllItemsToNewVector_NumberOfItemsShouldBeEqual()
    {
        for (int i = 0; i < 15; i++)
        {
            TextItem textItem = new TextItem("test", style);
            this.slide.appendSlideItem(textItem);
        }
        Vector<SlideItem> vector = this.slide.getAllSlideItems();
        assertEquals(15,vector.size());
    }

    @Test
    void getNumberOfItems_AppendFifteenSlideItems_GetNumShouldEqual15()
    {
        for (int i = 0; i < 15; i++)
        {
            TextItem textItem = new TextItem("test", style);
            this.slide.appendSlideItem(textItem);
        }
        assertEquals(15,this.slide.getNumberOfItems());
    }

    @Test
    void drawSlide_VerifyDrawingBehavior()
    {
        Slide slide = new Slide();
        slide.setSlideTitle("test");
        BufferedImage image = new BufferedImage(Slide.WIDTH, Slide.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        ImageObserver observerMock = mock(ImageObserver.class);
        Rectangle area = new Rectangle(0, 0, Slide.WIDTH, Slide.HEIGHT);
        Style style = new RedTitleStyle();
        SlideItem textItem = new TextItem("testItem", style);
        slide.appendSlideItem(textItem);
        slide.drawSlide(graphics, area, observerMock);
    }

}