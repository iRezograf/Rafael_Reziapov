package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    WebDriver driver;

    @FindBy(xpath = "//iframe[@id='frame']")
    WebElement iframeWithFrameButton;

    @FindBy(xpath = "//*[@id = 'frame-button']")
    WebElement frameButton = null;

    public FramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver open() {
        driver.switchTo().frame(iframeWithFrameButton);
        return driver;
    }

    public boolean exist() {
        return (null != frameButton);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }
}
