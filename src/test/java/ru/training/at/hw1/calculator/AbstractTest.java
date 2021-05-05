package ru.training.at.hw1.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AbstractTest {
    Calculator calculator;
    SoftAssert softAssert;

    @BeforeClass(groups = {"add_subtract", "multiply_divide"})
    public void setUp() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
    }

    @AfterClass(groups = {"add_subtract", "multiply_divide"})
    public void tearDown() {
        calculator = null;
        softAssert = null;
    }

}
