package ru.training.at.hw2.ex1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.ex1.dataproviders.DpForLeftSectionTexts;
import ru.training.at.hw2.ex1.dataproviders.DpForUnderFourIconsTexts;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


public class ExerciseOne {
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
        driver.quit();
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
        ExpectedConditions.textToBePresentInElement(element, "ROMAN IOVLEV!");

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

        element = driver.findElement(By.cssSelector("span.icon-search"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector("span.caret"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        /* also, it is possible: */
        element = driver.findElement(By.cssSelector("i.fa-sign-out"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");
    }

    @Test(groups = {"exercise_1"}, priority = 65)
    public void fourIconsInHomePageExistsTest() {
        element = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        softAssert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

    }

    @Test(groups = {"exercise_1"}, priority = 75,
            dataProvider = "DpForUnderFourIconsTexts",
            dataProviderClass = DpForUnderFourIconsTexts.class)
    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(int index,
                                                                           String expected) {
        element = driver.findElement(By.cssSelector(
                ".row.clerafix.benefits>.col-sm-3:nth-child(" + index + ")"));
        softAssert.assertEquals(element.getText(),
                expected, "Element's text isn't proper or not found");
    }

    @Test(groups = {"exercise_1"}, priority = 80)
    public void iframeWithFrameButtonExistTest() {
        String iframeWithFrameButton = "//iframe[@id='frame']";
        WebElement iframe = driver.findElement(By.xpath(iframeWithFrameButton));
        // check that element exist
        softAssert.assertNotNull(element);
    }

    @Test(groups = {"exercise_1"}, priority = 85)
    public void thereIsFrameButtonInTheIframeTest() {
        // 1.Looking for iframe
        String iframeWithFrameButton = "//iframe[@id='frame']";
        WebElement iframe = driver.findElement(By.xpath(iframeWithFrameButton));
        //2. Switch to iframe
        driver.switchTo().frame(iframe);
        //3. Looking for element in iframe
        String frameButton = "frame-button";
        element = driver.findElement(By.id(frameButton));
        // check that element exist
        softAssert.assertNotNull(element);
    }

    @Test(groups = {"exercise_1"}, priority = 90)
    public void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        //Driver has focus on the original window,
        //for example we available to find expected "Home Page"
        String expacted = "HOME";
        element = driver.findElement(By.tagName("li"));
        softAssert.assertEquals(element.getText(), expacted);
    }


    @Test(groups = {"exercise_1"}, priority = 95,
            dataProvider = "DpForLeftSectionTexts",
            dataProviderClass = DpForLeftSectionTexts.class)
    public void thereAreFiveItemsInTheLeftSectionTest(int index, String expected) {
        element = driver.findElement(
                By.cssSelector(".sidebar-menu.left>li:nth-child(" + index + ")"));
        softAssert.assertEquals(element.getText(), expected,
                "Element's text isn't proper or not found");

        // Browser close in: tearDown() {driver.quit();};
    }

}


