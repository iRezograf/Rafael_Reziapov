package ru.training.at.hw2.ex2;

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


public class ExerciseTwo {
    WebDriver driver;
    WebElement element;
    DataStoreForHomeworkTwo dp;

    @BeforeClass(groups = {"exercise_2"})
    public void setUp() {
        dp = new DataStoreForHomeworkTwo();

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    @AfterClass(groups = {"exercise_2"})
    public void tearDown() {

        //driver.quit();
    }

    @Test(groups = {"exercise_2"})
    public void allExerciseTwoTest() {
        openSiteByUrlTest();
        browserTitleTest();
        performLoginTest();
        usernameIsLogginedTest();
        openMenuServiceDifferentElementsTest();
        checkElementsTest();
        isLogCorrectTest();
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

    public void openMenuServiceDifferentElementsTest() {
        // Open drop down menu SERVICE
        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8>li.dropdown"));
        element.click();

        //8th p. of menu DIFFERENT ELEMENTS choose
        element = driver.findElement(By.cssSelector(
                "ul.uui-navigation.nav.navbar-nav.m-l8>li.dropdown>ul li:nth-child(8)"));
        element.click();
    }

    public void checkElementsTest() {

        //Select checkboxes Water
        // Full path
        // "//div[@class='checkbox-row']
        // /label[contains(string(), 'Water')]/input[@type='checkbox']"));

        // It may be shortly
        element = driver.findElement(By.xpath(
                "//label[contains(string(), 'Water')]/input[@type='checkbox']"));
        element.click();

        //label.label-checkbox
        //Select checkboxes Wind
        element = driver.findElement(By.xpath(
                "//label[contains(string(), 'Wind')]/input[@type='checkbox']"));
        element.click();

        // Select radio Selen
        element = driver.findElement(By.xpath(
                "//label[contains(string(), 'Selen')]/input[@type='radio']"));
        element.click();

        //Select dropdown colors
        element = driver.findElement(By.xpath(
                "//div[@class='colors']//select[@class='uui-form-element']"));
        element.click();

        //Select dropdown Yellow color
        //"//div[@class='main-content-hg']/div
        // [@class='colors']//select[@class='uui-form-element']/option[text()='Yellow']"));
        // attention! element.findElement (sic!)
        element = element.findElement(By.xpath("//option[text()='Yellow']"));
        element.click();

        //return to Select dropdown colors, but colors was chosen, already
        element = driver.findElement(By.xpath(
                "//div[@class='main-content-hg']/div[@class='colors']"));
        element.click();
    }

    public void isLogCorrectTest() {
        for (int i = 1; i <= 4; i++) {
            element = driver.findElement(By.cssSelector(
                    "#mCSB_2_container > section:nth-child(1) > div.info-panel-body."
                            + "info-panel-body-log > div > ul li:nth-child(" + i + ")"));
            Assert.assertTrue(element.getText().contains(dp.getTextFromLogList().get(i - 1)));
        }
    }
}


