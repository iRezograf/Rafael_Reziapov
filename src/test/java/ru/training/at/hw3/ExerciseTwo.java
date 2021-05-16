package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.dp.DataStore;
import ru.training.at.hw3.pageobjects.DifferentElementsPage;
import ru.training.at.hw3.pageobjects.HeaderMenu;
import ru.training.at.hw3.pageobjects.LoginPage;
import ru.training.at.hw3.util.DriverManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ExerciseTwo {
    private SoftAssert softAssert;
    private LoginPage loginPage;
    private HeaderMenu headerMenu;
    private DifferentElementsPage differentElementsPage;
    private WebDriver driver;
    private DriverManager driverManager;


    @BeforeClass(groups = {"exercise_hw3.2"})
    public void setUp() {
        softAssert = new SoftAssert();

        driverManager = new DriverManager();
        driver = driverManager.setup();

        loginPage = new LoginPage(driver);
        headerMenu = new HeaderMenu(driver);
        differentElementsPage = new DifferentElementsPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(groups = {"exercise_hw3.2"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        differentElementsPage = null;
        softAssert = null;
        driver.quit();
    }

    @Test(groups = {"exercise_hw3.2"})
    public void allExerciseTwoTest() {
        openSiteByUrlTest();
        performLoginTest();
        usernameIsLogginedTest();
        openMenuServiceDifferentElementsTest();
        checkElementsTest();
        isLogCorrectTest();
    }

    private void openSiteByUrlTest() {
        driver.navigate().to(DataStore.getProperty("siteUrl"));
        softAssert.assertEquals(
                driver.getTitle(),
                DataStore.getProperty("browserTitle"));
    }

    private void performLoginTest() {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(DataStore.getProperty("userName"));

        loginPage.inputFieldPassword(DataStore.getProperty("password"));
        loginPage.clickBtnEnter();
        String actualUserNameAfterLogged = loginPage.getUserName();
        softAssert.assertEquals(actualUserNameAfterLogged,
                DataStore.getProperty("userNameAfterLogged"));
    }

    private void usernameIsLogginedTest() {
        String actualUserNameAfterLogged = loginPage.getUserName();
        softAssert.assertEquals(actualUserNameAfterLogged,
                DataStore.getProperty("userNameAfterLogged"));
    }

    private void openMenuServiceDifferentElementsTest() {
        headerMenu.clickHeaderMenuItemService();
        headerMenu.clickHeaderMenuItemDifferentElements();
    }

    private void checkElementsTest() {
        differentElementsPage.clickCheckboxWater();
        differentElementsPage.clickCheckboxWind();
        differentElementsPage.clickRadioSelen();
        differentElementsPage.clickDropdownColors();
        differentElementsPage.clickDropdownYellow();
    }

    private void isLogCorrectTest() {
        // used "contains" for separate string
        // instead "equal" for whole list
        // because actual string contains time.
        // We can't synchronise the time.

        //for (int i = 0; i < 4; i++) {
        int i = 0;
        for (String actual : differentElementsPage.getLogListAsString()) {
            softAssert.assertTrue(actual.contains(getExceptedLogList().get(i)));
            i++;
        }
    }

    private List<String> getExceptedLogList() {
        String s1 = DataStore.getProperty("textFromLogList1");
        String s2 = DataStore.getProperty("textFromLogList2");
        String s3 = DataStore.getProperty("textFromLogList3");
        String s4 = DataStore.getProperty("textFromLogList4");
        return Arrays.asList(s1, s2, s3, s4);
    }

}


