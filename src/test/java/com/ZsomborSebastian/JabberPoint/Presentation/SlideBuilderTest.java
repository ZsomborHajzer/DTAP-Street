package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.BitMapItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.SlideItem;
import com.ZsomborSebastian.JabberPoint.Presentation.SlideItem.TextItem;
import com.ZsomborSebastian.JabberPoint.Styles.RedTitleStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SlideBuilderTest
{
    private Presentation presentation;
    private SlideBuilder slideBuilder;

    @BeforeEach
    void setup()
    {
        this.presentation = new Presentation();
        this.slideBuilder = new SlideBuilder(presentation);
    }


    @Test
    void getSlideTitle_AddNewTitle_ShouldReturnAddedTitle()
    {
        this.slideBuilder.setSlideTitle("Something");
        assertEquals("Something", this.slideBuilder.getSlideTitle());
    }

    @Test
    void setSlideTitle_EmptyTitle_ShouldThrowIllegalArgument()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.slideBuilder.setSlideTitle("");
        });
    }

    @Test
    void getPresentation_BaseCase_ShouldReturnCurrentPresentation()
    {
        assertEquals(this.presentation, this.slideBuilder.getPresentation());
    }

    @Test
    void setPresentation_AddNewPresentation_ShouldReturnNewPresentation()
    {
        Presentation presentation1 = new Presentation();
        slideBuilder.setPresentation(presentation1);
        assertEquals(presentation1, this.slideBuilder.getPresentation());
    }

    @Test
    void getItems_BaseCase_ZeroItems()
    {
        assertEquals(0, this.slideBuilder.getItems().size());
    }

    @Test
    void setItems_SetFiveItems_ShouldReturnFive()
    {
        ArrayList<SlideItem> list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            TextItem textItem = new TextItem("test", new RedTitleStyle());
            list.add(textItem);
        }
        this.slideBuilder.setItems(list);

        assertEquals(5, this.slideBuilder.getItems().size());
    }

    @Test
    void addBitMapItem_addBitmapItem_ShouldReturnCorrectInstanceOf()
    {
        this.slideBuilder.addBitMapItem(new RedTitleStyle(), "image2.png");
        assertInstanceOf(BitMapItem.class, this.slideBuilder.getItems().get(0));
    }

    @Test
    void addTextItem_AddNewTextItem_ShouldReturnCorrectInstanceOf()
    {

        this.slideBuilder.addTextItem("test", new RedTitleStyle());
        assertInstanceOf(TextItem.class, this.slideBuilder.getItems().get(0));
    }

    @Test
    void build_CallMethod_ShouldReturnCorrectSlideInstanceOf()
    {
        assertInstanceOf(Slide.class, this.slideBuilder.setSlideTitle("test").addTextItem("test",new RedTitleStyle()).build());
    }
}