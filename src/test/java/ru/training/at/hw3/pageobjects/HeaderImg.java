package ru.training.at.hw3.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HeaderImg {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='epam-logo'!!!!!]")
    private WebElement epamLogo;

    @FindBy(xpath = "//*[@id='user-icon']")
    private WebElement userIcon;

    @FindBy(css = "span.icon-search")
    private WebElement iconSearch;

    @FindBy(css = "span.caret")
    private WebElement spanCaret;

    public HeaderImg(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
