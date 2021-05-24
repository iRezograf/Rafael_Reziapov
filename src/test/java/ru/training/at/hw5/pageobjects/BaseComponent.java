package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseComponent {

    protected final WebDriver driver;
    protected WebDriverWait waiting;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.waiting = new WebDriverWait(this.driver, 1000);
        PageFactory.initElements(this.driver, this);
    }
}
