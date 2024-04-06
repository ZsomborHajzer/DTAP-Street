package com.ZsomborSebastian.JabberPoint.Accessor;

import com.ZsomborSebastian.JabberPoint.Presentation.DemoPresentation;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import java.io.IOException;

public abstract class Accessor {

    public static final String DEMO_NAME = "Demonstration presentation";
    public static final String DEFAULT_EXTENSION = ".xml";

    public static Accessor getDemoAccessor() {
        return new DemoPresentation();
    }

    public Accessor() {
    }

    public void loadFile(Presentation p, String fn) throws IOException {

    }

    public void saveFile(Presentation p, String fn) throws IOException {

    }

}

