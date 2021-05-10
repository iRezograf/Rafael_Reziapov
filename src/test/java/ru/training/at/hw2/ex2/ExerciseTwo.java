package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ExerciseTwo {
    WebDriver driver;
    WebElement element;
    SoftAssert softAssert;


    String driverPath;
    String testedSite;

    @BeforeClass(groups = {"exercise_2"})
    public void setUp() {
        // Версия 90.0.4430.93
        driverPath = "C:\\Users\\rezog\\driver\\chromedriver.exe";
        testedSite = "https://jdi-testing.github.io/jdi-light/index.html";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        softAssert = new SoftAssert();

    }

    @AfterClass(groups = {"exercise_2"})
    public void tearDown() {
        //driver.quit();
    }

    @Test(groups = {"exercise_2"}, priority = 110)
    public void openSiteByUrlTest() {
        driver.navigate().to(testedSite);
        driver.getTitle();
    }

    @Test(groups = {"exercise_2"}, priority = 120)
    public void browserTitleTest() {
        driver.navigate().to(testedSite);
        softAssert.assertEquals(driver.getTitle(),
                "Home Page");
    }

    @Test(groups = {"exercise_2"}, priority = 130)
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

    @Test(groups = {"exercise_2"}, priority = 140)
    public void usernameIsLogginedTest() {
        element = driver.findElement(By.id("user-name"));
        ExpectedConditions.textToBePresentInElement(element, "ROMAN IOVLEV!");

        softAssert.assertEquals(element.getText(), "ROMAN IOVLEV");
    }

    @Test(groups = {"exercise_2"}, priority = 150)
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

    @Test(groups = {"exercise_2"}, priority = 155)
    public void checkElementsTest() {
        //Select checkboxes Water
        element = driver.findElement(By.cssSelector(
        "div.main-content > div > div:nth-child(2) >label:nth-child(1)"));
        element.click();

        //Select checkboxes Wind
        element = driver.findElement(By.cssSelector(
                "div.main-content > div > div:nth-child(2) >label:nth-child(3)"));
        element.click();

        // Select radio Selen
        element = driver.findElement(By.cssSelector(
                "div.main-content > div > div:nth-child(3) >label:nth-child(4)"));
        element.click();

        //Select dropdown colors
        element = driver.findElement(By.cssSelector(
                "div.main-content > div > div:nth-child(4)"));
        element.click();

        //Select dropdown Yellow color
        element = driver.findElement(By.cssSelector(
                "body > div > div.uui-main-container.page-inside >"
                      + " main > div.main-content > div >"
                      + " div.colors > select > option:nth-child(4)"));
        element.click();

        //return to Select dropdown colors, but colors was chosen, already
        element = driver.findElement(By.cssSelector(
                "div.main-content > div > div:nth-child(4)"));
        element.click();
    }

    @Test(groups = {"exercise_2"}, priority = 160)
    public void isLogCorrectTest() {

        element = driver.findElement(By.cssSelector(
                "#mCSB_2_container > section:nth-child(1) > div.info-panel-body."
                        + "info-panel-body-log > div > ul li:nth-child(1)"));
        Assert.assertEquals(element.getText().substring(9),
                           "Colors: value changed to Yellow");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "#mCSB_2_container > section:nth-child(1) > div.info-panel-body."
                        + "info-panel-body-log > div > ul li:nth-child(2)"));
        Assert.assertEquals(element.getText().substring(9),
                "metal: value changed to Selen");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "#mCSB_2_container > section:nth-child(1) > div.info-panel-body."
                        + "info-panel-body-log > div > ul li:nth-child(3)"));
        Assert.assertEquals(element.getText().substring(9),
                "Wind: condition changed to true");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.cssSelector(
                "#mCSB_2_container > section:nth-child(1) > div.info-panel-body."
                        + "info-panel-body-log > div > ul li:nth-child(4)"));
        Assert.assertEquals(element.getText().substring(9),
                "Water: condition changed to true");
        Assert.assertTrue(element.isDisplayed());

    }

}




