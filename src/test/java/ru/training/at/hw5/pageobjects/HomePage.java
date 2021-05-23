package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }
}
