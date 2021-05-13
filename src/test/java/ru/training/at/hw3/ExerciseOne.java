package ru.training.at.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.dataproviders.DataStoreForHomeworkTwo;
import ru.training.at.hw3.pageobjects.*;
import ru.training.at.hw3.util.DriverManager;

import java.util.concurrent.TimeUnit;


public class ExerciseOne {
    private static LoginPage loginPage;
    private static HeaderMenu headerMenu;
    private static HeaderImg headerImg;
    private static BenefitIcon benefitIcon;
    private static BenefitText benefitText;
    private static FramePage framePage;
    private static LeftMenu leftMenu;


    private WebDriver driver;
    private WebElement element;
    private DataStoreForHomeworkTwo dp;


    @BeforeClass(groups = {"exercise_hw3"})
    public void setUp() {
        dp = new DataStoreForHomeworkTwo();

        driver = DriverManager.getWebDriverInstance();
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
        dp = null;
        //DriverManager.closeWebBrowser();
    }

        
    @Test(groups = {"exercise_hw3"})
    public void allExerciseOneTest() {
        openSiteByUrlTest();
        performLoginTest();
        //usernameIsLogginedTest();
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
        //Example
        //element = driver.findElement(By.xpath("//span[text() = 'Home']"));
        //element.click();
        //webDriverWait = new WebDriverWait(driver, 10);
        //webDriverWait.until(ExpectedConditions.visibilityOf(element));
        //Example

        driver.navigate().to(dp.getSiteUrl());
        Assert.assertEquals(driver.getTitle(), dp.getBrowserTitle());
    }

    public void performLoginTest() {
        loginPage.clickImgUser();
        loginPage.inputFieldLogin(dp.getUserName());

        loginPage.inputFieldPassword(dp.getPassword());
        loginPage.clickBtnEnter();
        String actual = loginPage.getUserName();
        Assert.assertEquals(actual, dp.getUserNameAfterLogged());
    }


    public void headerHaveProperTextsTest() {

        // ArrayList<String> textOfHeaderMenuButtonsList
        Assert.assertEquals(headerMenu.getHeaderMenuItemHome(),
                dp.getTextOfHeaderMenuButtonsList().get(0));

        Assert.assertEquals(headerMenu.getHeaderMenuItemContactForm(),
                dp.getTextOfHeaderMenuButtonsList().get(1));

        Assert.assertEquals(headerMenu.getHeaderMenuItemService(),
                dp.getTextOfHeaderMenuButtonsList().get(2));

        Assert.assertEquals(headerMenu.getHeaderMenuItemMetalColors(),
                dp.getTextOfHeaderMenuButtonsList().get(3));

        headerMenu.clickHeaderMenuItemService();

    }

    public void fourImagesOnTheIndexPageAndTheyAreDisplayed() {
        Assert.assertTrue(headerImg.getEpamLogo().isDisplayed(),
                "Element isn't displayed or found");
        Assert.assertTrue(headerImg.getUserIcon().isDisplayed(),
                "Element isn't displayed or found");
        Assert.assertTrue(headerImg.getIconSearch().isDisplayed(),
                "Element isn't displayed or found");
        Assert.assertTrue(headerImg.getSpanCaret().isDisplayed(),
                "Element isn't displayed or found");
    }

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

}



