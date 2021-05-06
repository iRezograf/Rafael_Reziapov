package ru.training.at.hw2.ex1;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpenSiteByUrlTest {
    WebDriver driver;
    String driverPath;
    String testedSite;

    @BeforeClass(groups = {"exercise_1"})
    public void setUp() {
        // Версия 90.0.4430.93
        driverPath = "C:\\Users\\rezog\\driver\\chromedriver.exe";
        testedSite = "https://jdi-testing.github.io/jdi-light/index.html";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @AfterClass(groups = {"exercise_1"})
    public void tearDown() {
        //webDriver.close();
    }

    @Test(groups = {"exercise_1"}, priority = 10)
    public void openSiteByUrlTest_() {

        driver.navigate().to(testedSite);
        driver.getTitle();
    }
    @Test(groups = {"exercise_1"}, priority = 20)
    public void browserTitleTest() {
        driver.navigate().to(testedSite);
        Assert.assertEquals(driver.getTitle(),
                "Home Page");

    }

    @Test(groups = {"exercise_1"}, priority = 20)
    public void performLoginTest() {
        driver.navigate().to(testedSite);

        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("name", "Roman"));
        driver.manage().addCookie(new Cookie("password", "Jdi1234"));


    }
    //<div class="col-sm-9">
    // <input id="name" type="text" class="uui-form-element">
    // </div>
//<input id="name" type="text" class="uui-form-element">
}

