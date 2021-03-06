package ru.training.at.hw3.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverManager {
    WebDriver driver;

    public WebDriver setup() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        return driver;
    }
}
