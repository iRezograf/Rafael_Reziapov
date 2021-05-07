package ru.training.at.hw2.ex1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.ex1.dataproviders.DpForUnderFourIconsTexts;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;
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
        softAssert = new SoftAssert();
    }

    @AfterClass(groups = {"exercise_1"})
    public void tearDown() {
        //driver.close();
    }

    @Test(groups = {"exercise_1"}, priority = 10)
    public void openSiteByUrlTest() {
        driver.navigate().to(testedSite);
        driver.getTitle();
    }

    @Test(groups = {"exercise_1"}, priority = 20)
    public void browserTitleTest() {
        driver.navigate().to(testedSite);
        softAssert.assertEquals(driver.getTitle(),
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
        softAssert.assertEquals(element.getText(), "ROMAN IOVLEV");
    }

    @Test(groups = {"exercise_1"}, priority = 50)
    public void headerHaveProperTextsTest() {

        List<WebElement> elements = driver.findElements(By.tagName("li")).subList(0, 3);

        softAssert.assertEquals(elements.get(0).getText(), "HOME");
        softAssert.assertEquals(elements.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(elements.get(2).getText(), "SERVICE");

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(4)"));
        softAssert.assertEquals(element.getText(), "METALS & COLORS");

        // Alternative method
        element = driver.findElement(By.xpath(
                "/html/body/header/div/nav/ul[1]/li[4]/a"));
        softAssert.assertEquals(element.getText(), "METALS & COLORS");
    }

    @Test(groups = {"exercise_1"}, priority = 60)
    public void fourImagesOnTheIndexPageAndTheyAreDisplayed() {
        element = driver.findElement(By.id("epam-logo"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.id("user-icon"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.xpath("/html/body/header/div/nav/div[3]/span"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        // drop-down profile menu open
        element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]/li/a"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        // Logout
        element = driver.findElement(
                By.xpath("/html/body/header/div/nav/ul[2]/li/div/div/button/i"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");
    }

    @Test(groups = {"exercise_1"}, priority = 70,
            dataProvider = "DpForUnderFourIconsTexts",
            dataProviderClass = DpForUnderFourIconsTexts.class)
    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(String expected) {
        String xpathLocator;

        // Check 1st text under the 1st Icons
        xpathLocator = "/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span";
        element = driver.findElement(By.xpath(xpathLocator));
        softAssert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");

        // Check 2d text under the 2d Icons
        xpathLocator = "/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span";
        element = driver.findElement(By.xpath(xpathLocator));
        softAssert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");

        // Check 3d text under the 3d Icons
        xpathLocator = "/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span";
        element = driver.findElement(By.xpath(xpathLocator));
        softAssert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");

        // Check 4th text under the 4th Icons
        xpathLocator = "/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span";
        element = driver.findElement(By.xpath(xpathLocator));
        softAssert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");
        //element.click();
    }

    @Test(groups = {"exercise_1"}, priority = 80)
    public void iframeWithFrameButtonExistTest() {

        element = driver.findElement(By.id("frame"));
        softAssert.assertEquals(element.getText(),
                "<p>Your browser does not support iframes.</p>",
                "Element's text isn't proper or not found");
    }
}


