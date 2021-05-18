package ru.training.at.hw3;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.dp.DataStore;
import ru.training.at.hw3.pageobjects.*;
import ru.training.at.hw3.util.DriverManager;

import java.util.Arrays;
import java.util.List;


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
        openSiteByUrlTest(
                DataStore.getProperty("siteUrl"),
                DataStore.getProperty("browserTitle"));

        performLoginTest(
                DataStore.getProperty("userName"),
                DataStore.getProperty("password"),
                DataStore.getProperty("userNameAfterLogged"));

        headerHaveProperTextsTest(
                getActualHeaderMenuItemHome(),
                getExpectedHeaderMenuItemHome());

        fourIconsInHomePageExistsTest(benefits.getBenefitIcons());

        fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(
                benefits.getBenefitTxtAsString(),
                getExpectedTextsOnTheIndexPageUnderIconsAndTheyHaveProperText());
        iframeWithFrameButtonExistTest(framePage);
        thereIsFrameButtonInTheIframeTest(framePage);
        switchToOriginalWindowBackTest(DataStore.getProperty("browserTitle"));
        thereAreFiveItemsInTheLeftSectionTest(
                leftMenu.getLeftMenuAsString(),
                getExceptedFiveItemsInTheLeftSection());
    }

    @Step("Open site {siteUrl} c Title: {expectedTitle}")
    private void openSiteByUrlTest(final String siteUrl, final String expectedTitle) {
        driver.navigate().to(siteUrl);
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Step("Проверка login пользователя {expectedLoggedName} "
          +  "c Login {name} и паролем {password}")
    private void performLoginTest(final String name,
                                  final String password,
                                  final String expectedLoggedName) {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(name);

        loginPage.inputFieldPassword(password);
        loginPage.clickBtnEnter();

        softAssert.assertEquals(loginPage.getUserName(), expectedLoggedName);
    }

    private void headerHaveProperTextsTest(final List<String> actualHeaderMenuTxt,
                                           final List<String> expectedHeaderMenuTxt) {

        softAssert.assertEquals(actualHeaderMenuTxt, expectedHeaderMenuTxt);

        headerMenu.headerMenuItemService().click();
    }



    private void fourIconsInHomePageExistsTest(final List<WebElement> benefitIcons) {
        String message = "Element isn't displayed or found";
        for (WebElement element : benefitIcons) {
            softAssert.assertTrue(element.isDisplayed(), message);
        }
    }

    private void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(
            final List<String> actualBenefitStrings,
            final List<String> expectedBenefitStrings) {

        softAssert.assertEquals(actualBenefitStrings, expectedBenefitStrings);
    }

    private void iframeWithFrameButtonExistTest(final FramePage frameWithFrameButton) {
        softAssert.assertNotNull(frameWithFrameButton.open());
    }

    private void thereIsFrameButtonInTheIframeTest(final FramePage frameButton) {

        softAssert.assertTrue(frameButton.exist());
    }

    private void switchToOriginalWindowBackTest(final String expectedTitle) {
        driver.switchTo().defaultContent();
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
    }

    private void thereAreFiveItemsInTheLeftSectionTest(final List<String> actualLeftMenu,
                                                       final List<String> expectedLeftMenu) {
        softAssert.assertEquals(actualLeftMenu, expectedLeftMenu);
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

    private List<String> getExpectedHeaderMenuItemHome() {
        String s1 = DataStore.getProperty("textOfHeaderMenuButtonsList1");
        String s2 = DataStore.getProperty("textOfHeaderMenuButtonsList2");
        String s3 = DataStore.getProperty("textOfHeaderMenuButtonsList3");
        String s4 = DataStore.getProperty("textOfHeaderMenuButtonsList4");
        return Arrays.asList(s1, s2, s3, s4);
    }

}



