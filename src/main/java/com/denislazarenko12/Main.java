package com.denislazarenko12;

import org.jdom2.Document;
import org.jdom2.JDOMException;

import java.io.IOException;

public class Main {
    ParseXml parseXml = new ParseXml();
    UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        try {
            new Main().runMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
    }

    private void runMain() throws IOException, JDOMException {
        DownloadXmlFromUrl.downloadXml();
        Document document = parseXml.buildDocument();
        userInterface.outputResult(parseXml.elementList(document));
    }
}
