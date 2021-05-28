package ru.training.at.hw6.comjdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import jdisite.JDISite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static java.lang.String.format;
import static jdisite.JDISite.homePage;

public class TestsInit {

    public static final int EXPECTED_BENEFITS_COUNT = 4;

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        PageFactory.initElements(JDISite.class);
        homePage.open();
    }
    @AfterSuite(alwaysRun = true)
    static void teardown() {

        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiHomepageBenefitsTest() {
        /*
         * 1. open home page
         * 2. check benefits count
         */
        JDISite.open();
        int actualCount = JDISite.jdiHomePage.getBenefitsCount();
        Assert.assertEquals(actualCount, EXPECTED_BENEFITS_COUNT,
                format("Expected benefits: %s, but actual: %s",
                        EXPECTED_BENEFITS_COUNT, actualCount));
    }
}

