package ru.training.at.hw3.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            WebDriverManager.getInstance(CHROME).setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeWebBrowser() {
        if (null != driver) {
            driver.quit();
        }
        driver = null;
    }

}
