package ru.training.at.hw6.interfaces;


import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.SiteJdi;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    static void beforeSuite() {
        PageFactory.initElements(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
