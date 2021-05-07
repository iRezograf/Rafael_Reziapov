package ru.training.at.hw2.ex1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class OpenSiteByUrlTest {
    WebDriver driver;
    WebElement element;
    SoftAssert softAssert;

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
        //driver.close();
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


    @Test(groups = {"exercise_1"}, priority = 30)
    public void performLoginTest() {
        driver.manage().window().maximize();

        element = driver.findElement(By.id("user-icon"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.sendKeys("Roman");

        element = driver.findElement(By.id("password"));
        element.sendKeys("Jdi1234");

        element = driver.findElement(By.id("login-button"));
        element.click();
    }

    @Test(groups = {"exercise_1"}, priority = 40)
    public void usernameIsLogginedTest() {
        element = driver.findElement(By.id("user-name"));
        assertEquals(element.getText(), "ROMAN IOVLEV");
    }

    @Test(groups = {"exercise_1"}, priority = 50)
    public void headerwHaveProperTextsTest() {
        List<WebElement> elements = driver.findElements(By.tagName("li")).subList(0, 3);
        //List<WebElement> firstFourElements = elements.subList(0,3);

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(1)"));
        System.out.println(element.getText());
        // body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1) > a
        //body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2) > a
        //body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown
        //html/body/header/div/nav/ul[1]/li[3]/a/text()
        //body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a
    }
}


