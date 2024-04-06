package com.ZsomborSebastian.JabberPoint.Accessor;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

public class XMLAccessorAdapter extends Accessor {

    private XMLAccessor xmlAccessor;

    public XMLAccessorAdapter() {
        this.xmlAccessor = new XMLAccessor();
    }

    @Override
    public void loadFile(Presentation p, String fn) throws IOException {
        try {
            xmlAccessor.loadFile(p, fn);
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public void saveFile(Presentation p, String fn) throws IOException{
        xmlAccessor.save(p,fn);
    }
}