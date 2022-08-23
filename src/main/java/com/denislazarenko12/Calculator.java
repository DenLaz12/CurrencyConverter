package com.denislazarenko12;

public class Calculator {

    public static double euroConvertToCurrency(double inputEuro, double outputCurrency){
        if (inputEuro == 0) return 0;
        return inputEuro * outputCurrency;
    }
}
