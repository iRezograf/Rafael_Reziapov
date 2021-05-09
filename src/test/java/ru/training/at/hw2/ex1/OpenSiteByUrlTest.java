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
        Assert.assertEquals(element.getText(), "ROMAN IOVLEV");
    }

    @Test(groups = {"exercise_1"}, priority = 50)
    public void headerHaveProperTextsTest() {

        List<WebElement> elements = driver.findElements(By.tagName("li")).subList(0, 3);

        Assert.assertEquals(elements.get(0).getText(), "HOME");
        Assert.assertEquals(elements.get(1).getText(), "CONTACT FORM");
        Assert.assertEquals(elements.get(2).getText(), "SERVICE");

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(4)"));
        Assert.assertEquals(element.getText(), "METALS & COLORS");

        // Alternative method
        element = driver.findElement(By.xpath(
                "/html/body/header/div/nav/ul[1]/li[4]/a"));
        Assert.assertEquals(element.getText(), "METALS & COLORS");
    }

    @Test(groups = {"exercise_1"}, priority = 60)
    public void fourImagesOnTheIndexPageAndTheyAreDisplayed() {
        element = driver.findElement(By.id("epam-logo"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.id("user-icon"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector("span.icon-search"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector("span.caret"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        /* also, it is possible: */
        element = driver.findElement(By.cssSelector("i.fa-sign-out"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");
    }

    @Test(groups = {"exercise_1"}, priority = 70,
            dataProvider = "DpForUnderFourIconsTexts",
            dataProviderClass = DpForUnderFourIconsTexts.class)
    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(int index,
                                                                           String expected) {
        element = driver.findElement(By.cssSelector(
                ".row.clerafix.benefits>.col-sm-3:nth-child(" + index + ")"));
        Assert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");
    }

    @Test(groups = {"exercise_1"}, priority = 80)
    public void iframeWithFrameButtonExistTest() {
        element = driver.findElement(By.xpath("//iframe[@id='frame']"));
        Assert.assertNotNull(element);
    }

    @Test(groups = {"exercise_1"}, priority = 80)
    public void thereIsFrameButtonInTheIframeTest() {
        //element = driver.findElement(By.xpath("//div[@class='card-body']/input"));
        //List<WebElement> elements = driver.findElements(By.xpath(
        // "//div[@class='card-body']/*[3]"));
        List<WebElement> elements = driver.findElements(By.xpath(
                "//div[@class='card-body'][1]//input[@id='frame-button"));
        //element = driver.findElement(By.xpath(
        // "//div[@class='card-body'][1]//input[@id='frame-button']"));
        System.out.println(elements.get(1).getText());


        //element = driver.findElement(By.xpath("//div[@class='card-body']/*[3]"));
        //Assert.assertNotNull(element);

    }
}


