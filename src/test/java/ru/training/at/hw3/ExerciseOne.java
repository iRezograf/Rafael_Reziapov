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
import ru.training.at.hw3.pageobjects.*;
import ru.training.at.hw3.util.DriverManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ExerciseOne {
    private LoginPage loginPage;
    private HeaderMenu headerMenu;
    private Benefits benefits;
    private FramePage framePage;
    private LeftMenu leftMenu;
    private SoftAssert softAssert;
    private WebDriver driver;
    private DriverManager driverManager;


    @BeforeClass(groups = {"exercise_hw3.1"})
    public void setUp() {
        softAssert = new SoftAssert();

        driverManager = new DriverManager();
        driver = driverManager.setup();

        loginPage = new LoginPage(driver);
        headerMenu = new HeaderMenu(driver);
        benefits = new Benefits(driver);
        framePage = new FramePage(driver);
        leftMenu = new LeftMenu(driver);


        driver.manage().window().maximize();
        //driver.manage().timeouts()
        //        .implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass(groups = {"exercise_hw3.1"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        benefits = null;
        framePage = null;
        leftMenu = null;
        softAssert = null;

        driver.quit();
    }

        
    @Test(groups = {"exercise_hw3.1"})
    public void allExerciseOneTest() {
        openSiteByUrlTest(DataStore.getProperty("siteUrl"), DataStore.getProperty("browserTitle"));
        performLoginTest();
        headerHaveProperTextsTest();
        fourIconsInHomePageExistsTest();
        fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(); //
        iframeWithFrameButtonExistTest();
        thereIsFrameButtonInTheIframeTest();
        switchToOriginalWindowBackTest();
        thereAreFiveItemsInTheLeftSectionTest();
    }

    private void openSiteByUrlTest(final String siteUrl, final String expectedTitle) {
        driver.navigate().to(siteUrl);
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
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

    private void headerHaveProperTextsTest() {
        softAssert.assertEquals(
                getActualHeaderMenuItemHome(),
                getExpectHeaderMenuItemHome());
        headerMenu.headerMenuItemService().click();
    }


    private void fourIconsInHomePageExistsTest() {
        String message = "Element isn't displayed or found";
        for (WebElement element : benefits.getBenefitIcons()) {
            softAssert.assertTrue(element.isDisplayed(), message);
        }
    }

    private void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest() {
        softAssert.assertEquals(
                benefits.getBenefitTxtAsString(),
                getExpectedTextsOnTheIndexPageUnderIconsAndTheyHaveProperText());
    }

    private void iframeWithFrameButtonExistTest() {
        softAssert.assertNotNull(framePage.open());
    }

    private void thereIsFrameButtonInTheIframeTest() {
        softAssert.assertTrue(framePage.exist());
    }

    private void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        softAssert.assertEquals(
                driver.getTitle(),
                DataStore.getProperty("browserTitle"));
    }

    private void thereAreFiveItemsInTheLeftSectionTest() {
        softAssert.assertEquals(
                leftMenu.getLeftMenuAsString(),
                getExceptedFiveItemsInTheLeftSection());

    }

    private List<String> getExceptedFiveItemsInTheLeftSection() {
        String s1 = DataStore.getProperty("textInLeftSectionMenuButtonList1");
        String s2 = DataStore.getProperty("textInLeftSectionMenuButtonList2");
        String s3 = DataStore.getProperty("textInLeftSectionMenuButtonList3");
        String s4 = DataStore.getProperty("textInLeftSectionMenuButtonList4");
        String s5 = DataStore.getProperty("textInLeftSectionMenuButtonList5");
        return Arrays.asList(s1, s2, s3, s4, s5);
    }

    private List<String> getExpectedTextsOnTheIndexPageUnderIconsAndTheyHaveProperText() {
        String s1 = DataStore.getProperty("textUnderIconsList1");
        String s2 = DataStore.getProperty("textUnderIconsList2");
        String s3 = DataStore.getProperty("textUnderIconsList3");
        String s4 = DataStore.getProperty("textUnderIconsList4");
        return Arrays.asList(s1, s2, s3, s4);
    }

    private List<String> getActualHeaderMenuItemHome() {
        String s1 = headerMenu.getHeaderMenuItemHome();
        String s2 = headerMenu.getHeaderMenuItemContactForm();
        String s3 = headerMenu.getHeaderMenuItemService();
        String s4 = headerMenu.getHeaderMenuItemMetalColors();
        return Arrays.asList(s1, s2, s3, s4);
    }

    private List<String> getExpectHeaderMenuItemHome() {
        String s1 = DataStore.getProperty("textOfHeaderMenuButtonsList1");
        String s2 = DataStore.getProperty("textOfHeaderMenuButtonsList2");
        String s3 = DataStore.getProperty("textOfHeaderMenuButtonsList3");
        String s4 = DataStore.getProperty("textOfHeaderMenuButtonsList4");
        return Arrays.asList(s1, s2, s3, s4);
    }


}



