package ru.training.at.hw4;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.dp.DataStore;
import ru.training.at.hw4.pageobjects.*;
import ru.training.at.hw4.util.DriverManager;
import ru.training.at.hw4.util.GetAttachment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Listeners(ExerciseListener.class)
public class ExerciseOne {
    private LoginPage loginPage;
    private HeaderMenu headerMenu;
    private Benefits benefits;
    private FramePage framePage;
    private LeftMenu leftMenu;
    private SoftAssert softAssert;
    protected WebDriver driver;

    DriverManager driverManager;

    @BeforeMethod(groups = {"exerciseHw41"})
    public void setUp(ITestContext context) {
        context.setAttribute("driver", driver);
        softAssert = new SoftAssert();

        driverManager = new DriverManager();
        driver = driverManager.setup();

        loginPage = new LoginPage(driver);
        headerMenu = new HeaderMenu(driver);
        benefits = new Benefits(driver);
        framePage = new FramePage(driver);
        leftMenu = new LeftMenu(driver);

        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(groups = {"exerciseHw41"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        benefits = null;
        framePage = null;
        leftMenu = null;
        softAssert = null;

        driver.quit();
    }

        
    @Test(groups = {"exerciseHw41"})
    @Description("Description from class ExerciseOne: HW4  allExerciseOneTest")
    public void allExerciseOneTest() throws IOException {
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

        softAssert.assertAll();
    }

    @Step("Open site {siteUrl} with Title: {expectedTitle}")
    private void openSiteByUrlTest(final String siteUrl,
                                   final String expectedTitle) throws IOException {
        driver.navigate().to(siteUrl);
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
        GetAttachment.getBytes("HomePage.png");
    }

    @Step("User logon as: {name} with password: {password} and if OK we can seeLoggedName:"
           + " {expectedLoggedName}")
    private void performLoginTest(final String name,
                                  final String password,
                                  final String expectedLoggedName) {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(name);

        loginPage.inputFieldPassword(password);
        loginPage.clickBtnEnter();

        softAssert.assertEquals(loginPage.getUserName(), expectedLoggedName);
    }

    @Step("Open site has follow menu items{actualHeaderMenuTxt} "
           + "and expected: {expectedHeaderMenuTxt}")
    private void headerHaveProperTextsTest(final List<String> actualHeaderMenuTxt,
                                           final List<String> expectedHeaderMenuTxt) {

        softAssert.assertEquals(actualHeaderMenuTxt, expectedHeaderMenuTxt);

        headerMenu.headerMenuItemService().click();
    }


    @Step("Are here for icons and they are displayed?")
    private void fourIconsInHomePageExistsTest(final List<WebElement> benefitIcons) {
        String message = "Element isn't displayed or found";
        for (WebElement element : benefitIcons) {
            softAssert.assertTrue(element.isDisplayed(), message);
        }
    }

    @Step("HomePage has 4 texts: {actualBenefitStrings} and expected: {expectedBenefitStrings}")
    private void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest(
            final List<String> actualBenefitStrings,
            final List<String> expectedBenefitStrings) {

        softAssert.assertEquals(actualBenefitStrings, expectedBenefitStrings);
    }

    @Step("Is here the frame with the Frame Button?")
    private void iframeWithFrameButtonExistTest(final FramePage frameWithFrameButton) {
        softAssert.assertNotNull(frameWithFrameButton.open());
    }

    @Step("Is in the frame the Frame Button?")
    private void thereIsFrameButtonInTheIframeTest(final FramePage frameButton) {
        softAssert.assertTrue(frameButton.exist());
    }

    @Step("Try to return from Frame to HomePage")
    private void switchToOriginalWindowBackTest(final String expectedTitle) {
        driver.switchTo().defaultContent();
        // driver.getTitle() NOT EQUALS expectedTitle + "Shot"
        // Here it should be onTestFailure
        softAssert.assertEquals(driver.getTitle(), expectedTitle + "Shot");
        //GetAttachment.saveScreenshotPng(driver);

    }

    @Step("Open site has left menu items{actualLeftMenu} anf expected: {expectedLeftMenu}")
    private void thereAreFiveItemsInTheLeftSectionTest(final List<String> actualLeftMenu,
                                                       final List<String> expectedLeftMenu) {
        softAssert.assertEquals(actualLeftMenu, expectedLeftMenu);
        GetAttachment.makeStringAttachment(actualLeftMenu);
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



