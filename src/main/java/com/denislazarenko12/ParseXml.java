package com.denislazarenko12;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import javax.xml.XMLConstants;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParseXml {

    private static final String FILE_NAME = "EuropeanCentralBank.xml";
    private static final String CUBE_NAMESPACE_URL = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref";

    private String currency;
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Document buildDocument() throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        saxBuilder.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        Document document = saxBuilder.build(new File(FILE_NAME));
        return document;
    }
    public List<Element> elementList(Document document){
        Element rootElement = document.getRootElement();
        Element rootTags = rootElement.getChild("Cube",
                Namespace.getNamespace(CUBE_NAMESPACE_URL));
        Element cubeTag = rootTags.getChild("Cube",
                Namespace.getNamespace(CUBE_NAMESPACE_URL));
        List<Element> cubeTags = cubeTag.getChildren();
        return cubeTags;
    }
}
