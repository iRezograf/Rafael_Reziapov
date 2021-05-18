package ru.training.at.hw4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.dp.DataStore;
import ru.training.at.hw4.pageobjects.DifferentElementsPage;
import ru.training.at.hw4.pageobjects.HeaderMenu;
import ru.training.at.hw4.pageobjects.LoginPage;
import ru.training.at.hw4.util.DriverManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ExerciseTwo {
    private SoftAssert softAssert;
    private LoginPage loginPage;
    private HeaderMenu headerMenu;
    private DifferentElementsPage differentElementsPage;
    private WebDriver driver;
    private DriverManager driverManager;


    @BeforeClass(groups = {"exerciseHw42"})
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

    @AfterClass(groups = {"exerciseHw42"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        differentElementsPage = null;
        softAssert = null;
        driver.quit();
    }

    @Test(groups = {"exerciseHw41"})
    public void allExerciseTwoTest() {
        openSiteByUrlTest(
                DataStore.getProperty("siteUrl"),
                DataStore.getProperty("browserTitle"));

        performLoginTest(
                DataStore.getProperty("userName"),
                DataStore.getProperty("password"),
                DataStore.getProperty("userNameAfterLogged"));

        usernameIsLogginedTest(DataStore.getProperty("userNameAfterLogged"));

        openMenuServiceDifferentElementsTest();

        checkElementsTest();

        isLogCorrectTest(differentElementsPage.getLogListAsString(), getExceptedLogList());
    }

    private void openSiteByUrlTest(final String siteUrl, final String expectedTitle) {
        driver.navigate().to(siteUrl);
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
    }

    private void performLoginTest(final String name,
                                  final String password,
                                  final String expectedLoggedName) {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(name);

        loginPage.inputFieldPassword(password);
        loginPage.clickBtnEnter();

        softAssert.assertEquals(loginPage.getUserName(), expectedLoggedName);
    }

    private void usernameIsLogginedTest(final String expectedLoggedName) {
        String actualUserNameAfterLogged = loginPage.getUserName();
        softAssert.assertEquals(actualUserNameAfterLogged, expectedLoggedName);
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

    private void isLogCorrectTest(final List<String> actualLogList,
                                  final List<String> expectedLogList) {
        // used "contains" for separate string
        // instead "equal" for whole list
        // because actual string contains time.
        // We can't synchronise the time.

        int i = 0;
        for (String actual : actualLogList) {
            softAssert.assertTrue(actual.contains(expectedLogList.get(i)));
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


