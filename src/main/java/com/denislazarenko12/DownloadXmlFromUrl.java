package com.denislazarenko12;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadXmlFromUrl {

    private static final String URL_EUROPEAN_CENTRAL_BANK = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    public static void downloadXml(){
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new URL(URL_EUROPEAN_CENTRAL_BANK).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("EuropeanCentralBank.xml")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
