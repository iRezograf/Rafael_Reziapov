package ru.training.at.hw1.calculator;

import org.testng.annotations.*;
import ru.training.at.hw1.dataproviders.AllTestProvider;

public class CalculatorSubTest extends AbstractTest {

    @Test(groups = {"add_subtract"}, priority = 30,
            dataProvider = "AllTestProvider",
            dataProviderClass = AllTestProvider.class)
    public void testSubLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumLongDataPositiveTest is wrong");
    }

    @Test(groups = {"add_subtract"}, priority = 30,
            dataProvider = "AllTestProvider",
            dataProviderClass = AllTestProvider.class)
    public void testSubDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SubDoubleDataPositiveTest is wrong");
    }

}

