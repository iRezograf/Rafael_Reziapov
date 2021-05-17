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

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ExerciseOne {
    WebDriver driver;
    WebElement element;
    DataStoreForHomeworkTwo dp;

    @BeforeClass(groups = {"exercise_1"})
    public void setUp() {
        dp = new DataStoreForHomeworkTwo();

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    @AfterClass(groups = {"exercise_1"})
    public void tearDown() {
        //driver.quit();
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
        thereAreFiveItemsInTheLeftSectionTest();
    }

    public void openSiteByUrlTest() {
        driver.navigate().to(dp.getSiteUrl());
        driver.getTitle();

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



