package ru.training.at.hw1.calculator;

import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.MultiplyDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.MultiplyLongDataPositiveTestProvider;

public class CalculatorMultiplyTest extends AbstractTest {

    @Test(groups = {"multiply_divide"}, priority = 50,
            dataProvider = "MultiplyLongDataPositiveTestProvider",
            dataProviderClass = MultiplyLongDataPositiveTestProvider.class)
    public void testMultLong(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        softAssert.assertEquals(actual, expected, "MultiplyLongDataPositiveTestProvider is wrong");
    }

    @Test(groups = {"multiply_divide"}, priority = 60,
            dataProvider = "MultiplyDoubleDataPositiveTestProvider",
            dataProviderClass = MultiplyDoubleDataPositiveTestProvider.class)
    public void testMultDouble(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        softAssert.assertEquals(actual, expected,
                "MultiplyDoubleDataPositiveTestProvider is wrong");
    }

}

