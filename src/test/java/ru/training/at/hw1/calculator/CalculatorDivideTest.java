package ru.training.at.hw1.calculator;

import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DivideByZeroDataTestProvider;
import ru.training.at.hw1.dataproviders.DivideDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.DivideLongDataPositiveTestProvider;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class CalculatorDivideTest extends AbstractTest {

    @Test(groups = {"multiply_divide"}, priority = 70,
            expectedExceptionsMessageRegExp = "Attempt to divide by zero",
            dataProvider = "DivideByZeroDataTestProvider",
            dataProviderClass = DivideByZeroDataTestProvider.class)
    public void testDivLongByZeroExceptionMessage(long a, long b) {
        try {
            calculator.div(a, b);
            fail("Test for DivLongByZero should have thrown a IllegalArgumentException");
        } catch (NumberFormatException e) {
            assertEquals("Attempt to divide by zero", e.getMessage());
        }
    }

    @Test(groups = {"multiply_divide"}, priority = 80,
            dataProvider = "DivideLongDataPositiveTestProvider",
            dataProviderClass = DivideLongDataPositiveTestProvider.class)
    public void testDivLong(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        softAssert.assertEquals(actual, expected, "DivideLongDataPositiveTestProvider is wrong");
    }

    @Test(groups = {"multiply_divide"}, priority = 90,
            dataProvider = "DivideDoubleDataPositiveTestProvider",
            dataProviderClass = DivideDoubleDataPositiveTestProvider.class)
    public void testDivDouble(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        softAssert.assertEquals(actual, expected, "DivideDoubleDataPositiveTestProvider is wrong");
    }

}
