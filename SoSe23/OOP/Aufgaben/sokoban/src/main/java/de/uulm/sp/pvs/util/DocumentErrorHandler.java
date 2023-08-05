package de.uulm.sp.pvs.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DocumentErrorHandler implements ErrorHandler {
    @Override
    public void error(SAXParseException spe) throws SAXException {
        throw spe;
    }

    @Override
    public void fatalError(SAXParseException spe) throws SAXException {
        throw spe;
    }

    @Override
    public void warning(SAXParseException spe) throws SAXException {
        throw spe;
    }
}
