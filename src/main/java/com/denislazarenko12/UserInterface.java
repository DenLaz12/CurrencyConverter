package com.denislazarenko12;

import org.jdom2.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";
    Scanner scanner = new Scanner(System.in);
    Map<String, Double> resultMap = new HashMap<>();
    ParseXml parseXml = new ParseXml();
    public void outputResult(List<Element> cubeTags) {
        System.out.print("Please write the amount in EUR: ");
        Double userCountInEuro = scanner.nextDouble();
        System.out.print("Please choose which currency to transfer Euro: ");
        String userCurrency = scanner.next().toUpperCase();

        for (int i = 0; i < cubeTags.size(); i++) {
            parseXml.setCurrency(String.valueOf(cubeTags.get(i).getAttribute("currency")));
            parseXml.setRate(Double.valueOf(cubeTags.get(i).getAttributeValue("rate")));
            resultMap.put(parseXml.getCurrency(), parseXml.getRate());
            if (userCurrency.equals(cubeTags.get(i).getAttributeValue("currency"))){
                System.out.println(RED_COLOR + "Result: " + Calculator.euroConvertToCurrency(userCountInEuro,
                        resultMap.get(parseXml.getCurrency())) + " " + userCurrency + RESET_COLOR);
            }
        }
    }
}
