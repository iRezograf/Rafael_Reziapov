package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.training.at.hw6.pages.HomePage;

import static ru.training.at.hw6.SiteJdi.homePage;


public class PageObjectExample  {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        SiteJdi.open();

        homePage.userIcon.click();
        /*
        homePage.name.sendKeys("Roman");
        homePage.password.sendKeys("Jdi1234");
        homePage.loginButton.click();
        homePage.userName.assertThat().displayed();

         */
    }
}
