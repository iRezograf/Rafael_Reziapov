package ru.training.at.hw1.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw1.dataproviders.SubDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.SubLongDataPositiveTestProvider;

public class CalculatorSubTest {
    Calculator calculator;
    SoftAssert softAssert;

    @BeforeMethod(groups = {"add_subtract"})
    public void setUp() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
    }

    @AfterMethod(groups = {"add_subtract"})
    public void tearDown() {
        calculator = null;
        softAssert = null;
    }

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

