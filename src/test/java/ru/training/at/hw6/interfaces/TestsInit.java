package ru.training.at.hw6.interfaces;


import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.SiteJdi;
import ru.training.at.hw6.providers.JsonDataParser;
import ru.training.at.hw6.providers.LoginUserData;
import ru.training.at.hw6.providers.MetalsAndColorsDataList;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    static void beforeSuite() {
        PageFactory.initElements(SiteJdi.class);
        JsonDataParser parser = new JsonDataParser();
        MetalsAndColorsDataList metalsAndColorsDataList = parser.parseFromFile();

    }

    @AfterSuite(alwaysRun = true)
    static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
