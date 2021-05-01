package ru.training.at.hw1;

public class TaxCalculationUnit {
    public TaxCalculationUnit() {
    }

    public static double getIncomTaxRate() {
        return 0.13d;
    }

    public static double calculateIncomeTaxValue(double income){
        return income*getIncomTaxRate();
    }
}
