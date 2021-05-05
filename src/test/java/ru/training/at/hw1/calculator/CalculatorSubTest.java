package ru.training.at.hw1.calculator;

import org.testng.annotations.*;
import ru.training.at.hw1.dataproviders.SubDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.SubLongDataPositiveTestProvider;

public class CalculatorSubTest extends AbstractTest {

    @Test(groups = {"add_subtract"}, priority = 30,
            dataProvider = "SubLongDataPositiveTestProvider",
            dataProviderClass = SubLongDataPositiveTestProvider.class)
    public void testSubLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumLongDataPositiveTest is wrong");
    }

    @Test(groups = {"add_subtract"}, priority = 40,
            dataProvider = "SubDoubleDataPositiveTestProvider",
            dataProviderClass = SubDoubleDataPositiveTestProvider.class)
    public void testSubDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SubDoubleDataPositiveTest is wrong");
    }

}

