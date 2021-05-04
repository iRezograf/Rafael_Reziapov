package ru.training.at.hw2.ex1;

import org.testng.AsexitsertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenSiteByURLTest {
    SoftAssert softAssert;
    @BeforeMethod(groups = {"exercize_1"})
    public void setUp() {
        softAssert = new SoftAssert();
        System.out.println("@BeforeMethod(groups = {\"exercize_1\"})");
    }

    @AfterMethod(groups = {"exercize_1"})
    public void tearDown() {
        System.out.println(" @AfterMethod(groups = {\"exercize_1\"})");
    }

    @Test(groups = {"exersize_1"}, priority = 10)
    public void OpenSiteByURLTest(double a, double actual, double expected) {

        softAssert.assertEquals(actual, expected, "SumDoubleDataPositiveTest is wrong");
    }}
