package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BenefitText {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(string(),'practices')]")
    WebElement benefitPractise;

    @FindBy(xpath = "//span[contains(string(),'flexible and')]")
    WebElement benefitFlexible;

    @FindBy(xpath = "//span[contains(string(),'To be multiplatform')]")
    WebElement benefitMultiplatform;

    @FindBy(xpath = "//span[contains(string(),'Already have good base')]")
    WebElement benefitBase;

    public BenefitText(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTextOfBenefitPractise() {
        return this.benefitPractise.getText();
    }

    public String getTextOfBenefitFlexible() {
        return this.benefitFlexible.getText();
    }

    public String getTextOfBenefitMultiplatform() {
        return this.benefitMultiplatform.getText();
    }

    public String getTextOfBenefitBase() {
        return this.benefitBase.getText();
    }

}
