package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.dataproviders.DataStoreForHomeworkTwo;
import ru.training.at.hw2.dataproviders.DpForLeftSectionTexts;
import ru.training.at.hw2.dataproviders.DpForUnderFourIconsTexts;

import java.util.ArrayList;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ExerciseOne {
    WebDriver driver;
    WebElement element;
    DataStoreForHomeworkTwo dp;

    //String driverPath;
    String testedSite;

    @BeforeClass(groups = {"exercise_1"})
    public void setUp() {
        //Not recommended:  is machine-dependent
        //Версия 90.0.4430.93
        //driverPath = "C:\\Users\\rezog\\driver\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", driverPath);
        //WebDriver driver = new ChromeDriver()
        dp = new DataStoreForHomeworkTwo();
        //testedSite = "https://jdi-testing.github.io/jdi-light/index.html";
        testedSite = dp.getSiteUrl();

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    @AfterClass(groups = {"exercise_1"})
    public void tearDown() {
        driver.quit();
    }

        @Test(groups = {"exercise_1"})
        public void allExerciseOneTest() {
            openSiteByUrlTest();
            browserTitleTest();
            performLoginTest();
            usernameIsLogginedTest();
            headerHaveProperTextsTest();
            fourImagesOnTheIndexPageAndTheyAreDisplayed();
            fourIconsInHomePageExistsTest();
            fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest();
            iframeWithFrameButtonExistTest();
            thereIsFrameButtonInTheIframeTest();
            switchToOriginalWindowBackTest();
        }

    //@Test(groups = {"exercise_1"}, priority = 10)
    public void openSiteByUrlTest() {
        driver.navigate().to(testedSite);
        driver.getTitle();
    }

    //@Test(groups = {"exercise_1"}, priority = 20)
    public void browserTitleTest() {
        driver.navigate().to(testedSite);
        Assert.assertEquals(driver.getTitle(), dp.getBrowserTitle());
    }

    //@Test(groups = {"exercise_1"}, priority = 30)
    public void performLoginTest() {
        driver.manage().window().maximize();

        element = driver.findElement(By.id("user-icon"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.sendKeys(dp.getUserName());

        element = driver.findElement(By.id("password"));
        element.sendKeys("Jdi1234");

        element = driver.findElement(By.id("login-button"));
        element.click();
    }

    //@Test(groups = {"exercise_1"}, priority = 40)
    public void usernameIsLogginedTest() {
        element = driver.findElement(By.id("user-name"));
        Assert.assertEquals(element.getText(), "ROMAN IOVLEV");
    }

    //@Test(groups = {"exercise_1"}, priority = 50)
    public void headerHaveProperTextsTest() {

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(1)"));
        Assert.assertEquals(element.getText(), "HOME");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(2)"));
        Assert.assertEquals(element.getText(), "CONTACT FORM");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(3)"));
        Assert.assertEquals(element.getText(), "SERVICE");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8>li:nth-child(4)"));
        Assert.assertEquals(element.getText(), "METALS & COLORS");
        Assert.assertTrue(element.isDisplayed());
    }

    //@Test(groups = {"exercise_1"}, priority = 60)
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

    //@Test(groups = {"exercise_1"}, priority = 65)
    public void fourIconsInHomePageExistsTest() {
        element = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

        element = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        Assert.assertTrue(element.isDisplayed(), "Element isn't displayed or found");

    }

    //@Test(groups = {"exercise_1"}, priority = 75)
    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest() {
        ArrayList<String> actual = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            element = driver.findElement(By.cssSelector(
                    ".row.clerafix.benefits>.col-sm-3:nth-child(" + i + ")"));
            actual.add(element.getText());
        }
        Assert.assertTrue(actual.equals(dp.getTextUnderIconsList()));
    }

    //@Test(groups = {"exercise_1"}, priority = 80)
    public void iframeWithFrameButtonExistTest() {
        String iframeWithFrameButton = "//iframe[@id='frame']";
        WebElement iframe = driver.findElement(By.xpath(iframeWithFrameButton));
        // check that element exist
        Assert.assertNotNull(element);
    }

    //@Test(groups = {"exercise_1"}, priority = 85)
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
        Assert.assertNotNull(element);
    }

    //@Test(groups = {"exercise_1"}, priority = 90)
    public void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        //Driver has focus on the original window,
        //for example we available to find expected "Home Page"
        String expacted = "HOME";
        element = driver.findElement(By.tagName("li"));
        Assert.assertEquals(element.getText(), expacted);
    }


    //@Test(groups = {"exercise_1"}, priority = 95,
    //        dataProvider = "DpForLeftSectionTexts",
    //        dataProviderClass = DpForLeftSectionTexts.class)
    //public void thereAreFiveItemsInTheLeftSectionTest(int index, String expected) {
    //    element = driver.findElement(
    //            By.cssSelector(".sidebar-menu.left>li:nth-child(" + index + ")"));
    //    Assert.assertEquals(element.getText(), expected,
    //            "Element's text isn't proper or not found");

    // Browser close in: tearDown() {driver.quit();};
    //}

}


