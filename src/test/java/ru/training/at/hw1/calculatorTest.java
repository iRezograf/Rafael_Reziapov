package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class calculatorTest {

        @Test(groups = {"add_sub"})
        public void testSumLong() {
            //public long sum(long a, long b) {
            //        return a + b;
            //    }
            System.out.println("add_sub");
            Calculator calculator = new Calculator();
            double lA = 100;
            double lB = 200;
            double actual = calculator.sum(lA,lB);
            double expected = 300;
            assertEquals(actual,expected,"calculateIncomeTaxValue is wrong");
        }
    @Test(groups = {"mult_div"})
    public void testMultLong() {
        //public long mult(long a, long b) {
        //    return a * b;
        //}
        System.out.println("mult_div");
        double lA = 100;
        double lB = 200;
        Calculator calculator = new Calculator();
        double actual = calculator.mult(lA,lB);
        double expected = 20001;
        assertEquals(actual,expected,"calculateIncomeTaxValue is wrong");
    }


        public void testCalculateIncomeTaxValueDouble() {
            System.out.println("Second Test");
            double actual = TaxCalculationUnit.calculateIncomeTaxValue(111);
            double expected = 14.45;
            assertEquals(actual,expected,0.01,"calculateIncomeTaxValue is wrong");
        }

}
