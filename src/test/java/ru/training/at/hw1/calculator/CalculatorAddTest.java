package ru.training.at.hw1.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw1.dataproviders.SumDoubleDataPositiveTestProvider;
import ru.training.at.hw1.dataproviders.SumLongDataPositiveTestProvider;

public class CalculatorAddTest {
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

    @Test(groups = {"add_subtract"}, priority = 10,
                dataProvider = "SumDoubleDataPositiveTestProvider",
                dataProviderClass = SumDoubleDataPositiveTestProvider.class)
    public void testSumDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumDoubleDataPositiveTest is wrong");
    }

    @Test(groups = {"add_subtract"}, priority = 20,
            dataProvider = "SumLongDataPositiveTestProvider",
            dataProviderClass = SumLongDataPositiveTestProvider.class)
    public void testSumLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, "SumLongDataPositiveTest is wrong");
    }

}
