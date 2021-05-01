package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaxCalculationUnitTest {

    @Test(groups = {"first"})
    public void testCalculateIncomeTaxValue() {
        System.out.println("FirstTest");
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(100);
        double expected = 13;
        assertEquals(actual,expected,"calculateIncomeTaxValue is wrong");
    }

    @Test(groups = {"second"})
    public void testCalculateIncomeTaxValueDouble() {
        System.out.println("Second Test");
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(111);
        double expected = 14.45;
        assertEquals(actual,expected,0.01,"calculateIncomeTaxValue is wrong");
    }
}