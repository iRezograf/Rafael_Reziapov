package ru.training.at.hw1.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw1.dataproviders.MultiplyDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.MultiplyLongDataPositiveTestProvider;

public class CalculatorMultiplyTest {
    Calculator calculator;
    SoftAssert softAssert;

    @BeforeMethod(groups = {"multiply_divide"})
    public void setUp() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
    }

    @AfterMethod(groups = {"multiply_divide"})
    public void tearDown() {
        calculator = null;
        softAssert = null;
    }

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

