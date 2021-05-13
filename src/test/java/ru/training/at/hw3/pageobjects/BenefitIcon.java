package ru.training.at.hw3.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BenefitIcon {
    public WebDriver driver;

    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement benefitPractice;

    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement benefitCustom;

    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement benefitMulti;

    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement benefitBase;

    public BenefitIcon(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
