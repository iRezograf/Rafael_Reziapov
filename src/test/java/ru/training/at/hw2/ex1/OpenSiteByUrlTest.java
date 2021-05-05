package ru.training.at.hw2.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteByUrlTest {
    WebDriver webDriver;
    String driverPath;
    String testedSite;

    @BeforeMethod (groups = {"exercise_1"})
    public void setUp() {
        // Версия 90.0.4430.93
        driverPath = "C:\\Users\\rezog\\driver\\chromedriver.exe";
        testedSite = "https://jdi-testing.github.io/jdi-light/index.html";

    }

    @AfterMethod(groups = {"exercise_1"})
    public void tearDown() {

    }

    @Test(groups = {"exercise_1"}, priority = 10)
    public void openSiteByUrlTest() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver = new ChromeDriver();
        webDriver.navigate().to(testedSite);
        System.out.println(webDriver.getTitle());
        Assert.assertEquals(webDriver.getTitle(),
                "Home Page ! STOP !");
        webDriver.close();
    }
}

