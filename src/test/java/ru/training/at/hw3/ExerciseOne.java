package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
    private HeaderImg headerImg;
    private BenefitIcon benefitIcon;
    private BenefitText benefitText;
    private FramePage framePage;
    private LeftMenu leftMenu;

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass(groups = {"exercise_hw3"})
    public void setUp() {

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        headerMenu = new HeaderMenu(driver);
        headerImg = new HeaderImg(driver);
        benefitIcon = new BenefitIcon(driver);
        benefitText = new BenefitText(driver);
        framePage = new FramePage(driver);
        leftMenu = new LeftMenu(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(groups = {"exercise_hw3"})
    public void tearDown() {
        loginPage = null;
        headerMenu = null;
        headerImg = null;
        benefitIcon = null;
        benefitText = null;
        framePage = null;
        leftMenu = null;

        driver.quit();
    }

        
    @Test(groups = {"exercise_hw3"})
    public void allExerciseOneTest() {
        openSiteByUrlTest();
        performLoginTest();
        headerHaveProperTextsTest();
        fourImagesOnTheIndexPageAndTheyAreDisplayed();
        //fourIconsInHomePageExistsTest();
        //fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest();
        //iframeWithFrameButtonExistTest();
        //thereIsFrameButtonInTheIframeTest();
        //switchToOriginalWindowBackTest();
        //thereAreFiveItemsInTheLeftSectionTest();
    }

    public void openSiteByUrlTest() {
        driver.navigate().to(DataStore.getProperty("siteUrl"));
        Assert.assertEquals(driver.getTitle(), DataStore.getProperty(
                "browserTitle"));
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

    public void headerHaveProperTextsTest() {

        //List<String> expectedList = getExpectHeaderMenuItemHome();
        //List<String> actualList = getActualHeaderMenuItemHome();
        //Assert.assertTrue(expectedList.equals(actualList));
        System.out.println(getActualHeaderMenuItemHome());
        System.out.println(getExpectHeaderMenuItemHome());
        System.out.println("--------");
        Assert.assertEquals(getActualHeaderMenuItemHome(), getExpectHeaderMenuItemHome());
        System.out.println("++++++++");
        System.out.println(getActualHeaderMenuItemHome());
        System.out.println(getExpectHeaderMenuItemHome());
        /*

        System.out.println("expectedList.equals(actualList):" + expectedList.equals(actualList));
        Assert.assertEquals(headerMenu.getHeaderMenuItemHome(),
                DataStore.getProperty("textOfHeaderMenuButtonsList1"));
        Assert.assertEquals(headerMenu.getHeaderMenuItemContactForm(),
                DataStore.getProperty("textOfHeaderMenuButtonsList2"));
        Assert.assertEquals(headerMenu.getHeaderMenuItemService(),
                DataStore.getProperty("textOfHeaderMenuButtonsList3"));
        Assert.assertEquals(headerMenu.getHeaderMenuItemMetalColors(),
                DataStore.getProperty("textOfHeaderMenuButtonsList4"));
        */

        //headerMenu.HeaderMenuItemService().click();

    }

    private List<String> getActualHeaderMenuItemHome() {
        String s1 = headerMenu.getHeaderMenuItemHome();
        String s2 = headerMenu.getHeaderMenuItemContactForm();
        String s3 = headerMenu.getHeaderMenuItemService();
        String s4 = headerMenu.getHeaderMenuItemMetalColors();
        List<String> actualList = Arrays.asList(s1, s2, s3, s4);
        return actualList;
    }

    private List<String> getExpectHeaderMenuItemHome() {
        String s1 = DataStore.getProperty("textOfHeaderMenuButtonsList1");
        String s2 = DataStore.getProperty("textOfHeaderMenuButtonsList2");
        String s3 = DataStore.getProperty("textOfHeaderMenuButtonsList3");
        String s4 = DataStore.getProperty("textOfHeaderMenuButtonsList4");
        List<String> expectedList = Arrays.asList(s1, s2, s3, s4);
        return expectedList;
    }

    public void fourImagesOnTheIndexPageAndTheyAreDisplayed() {
        softAssert.assertTrue(headerImg.getEpamLogo().isDisplayed(),
                "Element isn't displayed or found");
        softAssert.assertTrue(headerImg.getUserIcon().isDisplayed(),
                "Element isn't displayed or found");
        softAssert.assertTrue(headerImg.getIconSearch().isDisplayed(),
                "Element isn't displayed or found");
        softAssert.assertTrue(headerImg.getSpanCaret().isDisplayed(),
                "Element isn't displayed or found");
    }
    /*
    public void fourIconsInHomePageExistsTest() {
        Assert.assertTrue(benefitIcon.getBenefitPractice().isDisplayed(),
                "Element isn't displayed or found");

        Assert.assertTrue(benefitIcon.getBenefitCustom().isDisplayed(),
                "Element isn't displayed or found");

        Assert.assertTrue(benefitIcon.getBenefitMulti().isDisplayed(),
                "Element isn't displayed or found");

        Assert.assertTrue(benefitIcon.getBenefitBase().isDisplayed(),
                "Element isn't displayed or found");
    }

    public void fourTextsOnTheIndexPageUnderIconsAndTheyHaveProperTextTest() {
        // ArrayList<String> textUnderIconsList 0-3
        Assert.assertEquals(benefitText.getTextOfBenefitPractise(),
                dp.getTextUnderIconsList().get(0));

        Assert.assertEquals(benefitText.getTextOfBenefitFlexible(),
                dp.getTextUnderIconsList().get(1));

        Assert.assertEquals(benefitText.getTextOfBenefitMultiplatform(),
                dp.getTextUnderIconsList().get(2));

        Assert.assertEquals(benefitText.getTextOfBenefitBase(),
                dp.getTextUnderIconsList().get(3));
    }

    public void iframeWithFrameButtonExistTest() {
        Assert.assertNotNull(framePage.open());
    }

    public void thereIsFrameButtonInTheIframeTest() {
        Assert.assertTrue(framePage.exist());
        //framePage.getFrameButton().click();
    }

    public void switchToOriginalWindowBackTest() {
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.getTitle(), dp.getBrowserTitle());
    }

    public void thereAreFiveItemsInTheLeftSectionTest() {

        Assert.assertEquals(leftMenu.getTextLeftMenuItemHome(),
                dp.getTextInLeftSectionMenuButtonList().get(0));
        Assert.assertEquals(leftMenu.getTextLeftMenuItemContactForm(),
                dp.getTextInLeftSectionMenuButtonList().get(1));
        Assert.assertEquals(leftMenu.getLeftMenuItemService(),
                dp.getTextInLeftSectionMenuButtonList().get(2));
        Assert.assertEquals(leftMenu.getTextLeftMenuItemMetalsAndColors(),
                dp.getTextInLeftSectionMenuButtonList().get(3));
        Assert.assertEquals(leftMenu.getTextLeftMenuItemElementsPacks(),
                dp.getTextInLeftSectionMenuButtonList().get(4));

        // Browser close in: tearDown() {driver.quit();};
    }

     */
}



