package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.dp.DataStore;
import ru.training.at.hw3.pageobjects.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ExerciseOne {
    private LoginPage loginPage;
    private HeaderMenu headerMenu;
    private BenefitIcon benefitIcon;
    private BenefitText benefitText;
    private FramePage framePage;
    private LeftMenu leftMenu;

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass(groups = {"exercise_hw3.1"})
    public void setUp() {

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        headerMenu = new HeaderMenu(driver);
        benefitIcon = new BenefitIcon(driver);
        benefitText = new BenefitText(driver);
        framePage = new FramePage(driver);
        leftMenu = new LeftMenu(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(groups = {"exercise_hw3.1.1"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        benefitIcon = null;
        benefitText = null;
        framePage = null;
        leftMenu = null;

        driver.quit();
    }

        
    @Test(groups = {"exercise_hw3.1.1"})
    public void allExerciseOneTest() {
        openSiteByUrlTest();
        performLoginTest();
        headerHaveProperTextsTest();
        fourIconsInHomePageExistsTest();
        fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(); //
        iframeWithFrameButtonExistTest();
        thereIsFrameButtonInTheIframeTest();
        switchToOriginalWindowBackTest();
        thereAreFiveItemsInTheLeftSectionTest();
    }

    public void openSiteByUrlTest() {
        driver.navigate().to(DataStore.getProperty("siteUrl"));
        Assert.assertEquals(
                driver.getTitle(),
                DataStore.getProperty("browserTitle"));
    }

    public void performLoginTest() {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(DataStore.getProperty("userName"));

        loginPage.inputFieldPassword(DataStore.getProperty("password"));
        loginPage.clickBtnEnter();
        String actualUserNameAfterLogged = loginPage.getUserName();
        Assert.assertEquals(actualUserNameAfterLogged,
                DataStore.getProperty("userNameAfterLogged"));
    }

    private void headerHaveProperTextsTest() {
        Assert.assertEquals(
                getActualHeaderMenuItemHome(),
                getExpectHeaderMenuItemHome());
        headerMenu.headerMenuItemService().click();
    }


    private void fourIconsInHomePageExistsTest() {
        String message = "Element isn't displayed or found";
        Assert.assertTrue(benefitIcon.getBenefitPractice().isDisplayed(), message);
        Assert.assertTrue(benefitIcon.getBenefitCustom().isDisplayed(), message);
        Assert.assertTrue(benefitIcon.getBenefitMulti().isDisplayed(), message);
        Assert.assertTrue(benefitIcon.getBenefitBase().isDisplayed(), message);
    }

    private void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest() {

        Assert.assertEquals(
                getActualTextsOnTheIndexPageUnderIconsAndTheyHaveProperText(),
                getExpectedTextsOnTheIndexPageUnderIconsAndTheyHaveProperText());

    }

    private void iframeWithFrameButtonExistTest() {
        Assert.assertNotNull(framePage.open());
    }

    private void thereIsFrameButtonInTheIframeTest() {
        Assert.assertTrue(framePage.exist());
    }

    private void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        Assert.assertEquals(
                driver.getTitle(),
                DataStore.getProperty("browserTitle"));
    }

    private void thereAreFiveItemsInTheLeftSectionTest() {
        Assert.assertEquals(
                getActualFiveItemsInTheLeftSection(),
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

    private List<String> getActualFiveItemsInTheLeftSection() {
        String s1 = leftMenu.getTextLeftMenuItemHome();
        String s2 = leftMenu.getTextLeftMenuItemContactForm();
        String s3 = leftMenu.getLeftMenuItemService();
        String s4 = leftMenu.getTextLeftMenuItemMetalsAndColors();
        String s5 = leftMenu.getTextLeftMenuItemElementsPacks();
        return Arrays.asList(s1, s2, s3, s4, s5);
    }

    private List<String> getExpectedTextsOnTheIndexPageUnderIconsAndTheyHaveProperText() {
        String s1 = DataStore.getProperty("textUnderIconsList1");
        String s2 = DataStore.getProperty("textUnderIconsList2");
        String s3 = DataStore.getProperty("textUnderIconsList3");
        String s4 = DataStore.getProperty("textUnderIconsList4");
        //List<String> expectedList = Arrays.asList(s1, s2, s3, s4);
        return Arrays.asList(s1, s2, s3, s4);
    }

    private List<String> getActualTextsOnTheIndexPageUnderIconsAndTheyHaveProperText() {
        String s1 = benefitText.getTextOfBenefitPractise();
        String s2 = benefitText.getTextOfBenefitFlexible();
        String s3 = benefitText.getTextOfBenefitMultiplatform();
        String s4 = benefitText.getTextOfBenefitBase();
        return Arrays.asList(s1, s2, s3, s4);
    }

    private List<String> getActualHeaderMenuItemHome() {
        String s1 = headerMenu.getHeaderMenuItemHome();
        String s2 = headerMenu.getHeaderMenuItemContactForm();
        String s3 = headerMenu.getHeaderMenuItemService();
        String s4 = headerMenu.getHeaderMenuItemMetalColors();
        //List<String> actualList = Arrays.asList(s1, s2, s3, s4);
        return Arrays.asList(s1, s2, s3, s4);
    }

    private List<String> getExpectHeaderMenuItemHome() {
        String s1 = DataStore.getProperty("textOfHeaderMenuButtonsList1");
        String s2 = DataStore.getProperty("textOfHeaderMenuButtonsList2");
        String s3 = DataStore.getProperty("textOfHeaderMenuButtonsList3");
        String s4 = DataStore.getProperty("textOfHeaderMenuButtonsList4");
        //List<String> expectedList = Arrays.asList(s1, s2, s3, s4);
        return Arrays.asList(s1, s2, s3, s4);
    }


}



