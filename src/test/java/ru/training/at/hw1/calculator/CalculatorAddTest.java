package ru.training.at.hw1.calculator;

import org.testng.annotations.*;
import ru.training.at.hw1.dataproviders.AllTestProvider;

public class CalculatorAddTest extends AbstractTest {

    @Test(groups = {"add_subtract"}, priority = 30,
            dataProvider = "AllTestProvider",
            dataProviderClass = AllTestProvider.class)
    public void testSumDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumDoubleDataPositiveTest is wrong");
    }

    @Test(groups = {"add_subtract"}, priority = 30,
            dataProvider = "AllTestProvider",
            dataProviderClass = AllTestProvider.class)
    public void testSumLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumLongDataPositiveTest is wrong");
    }
}