package com.ZsomborSebastian.JabberPoint.Presentation;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessorAdapter;

import java.io.IOException;

public class DemoPresentation {
    Accessor accessor;

    public DemoPresentation() {
        accessor = new XMLAccessorAdapter();
    }

    public void loadFile(String filename) throws IOException {
        accessor.loadFile(this, filename);
    }

    public void saveFile(String filename) throws IOException {
        accessor.saveFile(this, filename);
    }

    // Rest of the DemoPresentation code...
}