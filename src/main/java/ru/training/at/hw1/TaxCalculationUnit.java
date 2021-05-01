package ru.training.at.hw1;

public class TaxCalculationUnit {
    final static double TAX = 0.13d;

    public TaxCalculationUnit() {
    }

    public static double getIncomTaxRate() {
        return TAX;
    }

    public static double calculateIncomeTaxValue(final double income) {
        return income * getIncomTaxRate();
    }
}
