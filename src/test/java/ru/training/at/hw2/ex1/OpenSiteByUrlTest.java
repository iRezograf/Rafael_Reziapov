package ru.training.at.hw2.ex1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class OpenSiteByUrlTest {
    WebDriver driver;
    String driverPath;
    String testedSite;

    @BeforeClass(groups = {"exercise_1"})
    public void setUp() {
        // Версия 90.0.4430.93
        driverPath = "C:\\Users\\rezog\\driver\\chromedriver.exe";
        testedSite = "https://jdi-testing.github.io/jdi-light/index.html";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @AfterClass(groups = {"exercise_1"})
    public void tearDown() {
        //driver.close();
    }

    @Test(groups = {"exercise_1"}, priority = 10)
    public void openSiteByUrlTest_() {

        driver.navigate().to(testedSite);
        driver.getTitle();
    }

    @Test(groups = {"exercise_1"}, priority = 20)
    public void browserTitleTest() {
        driver.navigate().to(testedSite);
        Assert.assertEquals(driver.getTitle(),
                "Home Page");

    }


    @Test(groups = {"exercise_1"}, priority = 30)
    public void performLoginTest() {
        //driver.navigate().to(testedSite);

        driver.manage().window().maximize();

        /** driver.manage().deleteAllCookies();*/
        /** driver.manage().addCookie(new Cookie("name", "Roman"));*/
        /** driver.manage().addCookie(new Cookie("password", "Jdi1234"));*/

        WebElement element;
        element = driver.findElement(By.id("user-icon"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.sendKeys("Roman");

        element = driver.findElement(By.id("password"));
        element.sendKeys("Jdi1234");

        element = driver.findElement(By.id("login-button"));
        element.click();

        /*
         * List<WebElement> elements = driver.findElements (By.tagName("li"));
        driver.findElement (By.className("options-class"));
        driver.findElement (By.name("button-name"));
        driver.findElement (By.cssSelector(".options"));
        driver.findElement (By.xpath("//li[@name='button-name']"));
        driver.findElement (By.linkText("Contact Us"));
        driver.findElement (By.partialLinkText("Contact"));
         */

        /*
        @Test
        public void elementTest() {
        element.click();
        element.sendKeys("Admin007");
        element.clear();
        assertEquals(element.getText(), "Ages");
        assertEquals(element.getAttribute("el-value"), "Save Product");
        assertEquals(element.getCssValue("font-size"), "12");
        }
         * */
    }
}

