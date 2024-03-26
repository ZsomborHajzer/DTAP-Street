package com.ZsomborSebastian.JabberPoint.Styles;

public class StylesFactory
{
    public Style createStyle(StyleTypes styleType)
    {
        return switch (styleType)
        {
            case BLACK_SUBHEADING -> new BlackSubheadingStyle();
            case BLACK_SUBTEXT -> new BlackSubtextStyle();
            case BLACK_TEXT -> new BlackTextStyle();
            case BLUE_HEADING -> new BlueHeadingStyle();
            case RED_TITLE -> new RedTitleStyle();
            default -> throw new IllegalArgumentException("Unsupported style type: " + styleType);
        };
    }

}
