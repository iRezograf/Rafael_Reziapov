package ru.training.at.hw31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.dataproviders.DataStoreForHomeworkTwo;
import ru.training.at.hw31.util.DriverManager;

import java.util.concurrent.TimeUnit;


public class ExerciseOne {
    private WebDriver driver;
    private WebElement element;
    private DataStoreForHomeworkTwo dp;

    private WebDriverWait webDriverWait;

    @BeforeClass(groups = {"exercise_hw3"})
    public void setUp() {
        dp = new DataStoreForHomeworkTwo();
        driver = DriverManager.getWebDriverInstance();
    }

    @AfterClass(groups = {"exercise_hw3"})
    public void tearDown() {
        dp = null;
        DriverManager.closeWebBrowser();
    }

        
    @Test(groups = {"exercise_hw3"})
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
        thereAreFiveItemsInTheLeftSectionTest();
    }

    public void openSiteByUrlTest() {
        //Example
        //element = driver.findElement(By.xpath("//span[text() = 'Home']"));
        //element.click();
        //webDriverWait = new WebDriverWait(driver, 10);
        //webDriverWait.until(ExpectedConditions.visibilityOf(element));
        //Example

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(dp.getSiteUrl());
        driver.getTitle();

        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void browserTitleTest() {
        driver.navigate().to(dp.getSiteUrl());
        Assert.assertEquals(driver.getTitle(), dp.getBrowserTitle());
    }

    public void performLoginTest() {
        driver.manage().window().maximize();

        element = driver.findElement(By.id("user-icon"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.sendKeys(dp.getUserName());

        element = driver.findElement(By.id("password"));
        element.sendKeys(dp.getPassword());

        element = driver.findElement(By.id("login-button"));
        element.click();
    }

    public void usernameIsLogginedTest() {
        element = driver.findElement(By.id("user-name"));
        Assert.assertEquals(element.getText(), dp.getUserNameAfterLogged());
    }

    public void headerHaveProperTextsTest() {
        for (int i = 1; i <= 4; i++) {
            element = driver.findElement(By.cssSelector(
                    "ul.uui-navigation.nav.navbar-nav.m-l8 >li:nth-child(" + i + ")"));
            Assert.assertEquals(element.getText(),
                    dp.getTextOfHeaderMenuButtonsList().get(i - 1));
        }
    }

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
    }

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

    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest() {
        for (int i = 1; i <= 4; i++) {
            element = driver.findElement(By.cssSelector(
                    ".row.clerafix.benefits>.col-sm-3:nth-child(" + i + ")"));
            Assert.assertEquals(element.getText(), dp.getTextUnderIconsList().get(i - 1));
        }
    }

    public void iframeWithFrameButtonExistTest() {
        String iframeWithFrameButton = "//iframe[@id='frame']";
        WebElement iframe = driver.findElement(By.xpath(iframeWithFrameButton));
        // check that element exist
        Assert.assertNotNull(iframe);
    }

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

    public void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.getTitle(), dp.getBrowserTitle());
    }

    public void thereAreFiveItemsInTheLeftSectionTest() {
        for (int i = 1; i <= 5; i++) {
            element = driver.findElement(
                    By.cssSelector(".sidebar-menu.left>li:nth-child(" + i + ")"));
            Assert.assertEquals(element.getText(),
                    dp.getTextInLeftSectionMenuButtonList().get(i - 1));
        }
        // Browser close in: tearDown() {driver.quit();};
    }

}



