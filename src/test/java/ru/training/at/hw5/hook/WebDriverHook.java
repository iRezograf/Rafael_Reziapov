package ru.training.at.hw5.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.training.at.hw5.dp.TestContext;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class WebDriverHook {

    public static String removeSpaces = "^ +| +$|( )+|(\\r\\n|\\n|\\r)";

    private WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();

        TestContext.getInstance().setTestObject(TestContext.WEB_DRIVER, driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}

