package ru.training.at.hw3.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    WebDriver driver;

    //Select checkboxes Water
    @FindBy(xpath = "//label[contains(string(), 'Water')]/input[@type='checkbox']")
    WebElement checkboxWater;


    //label.label-checkbox
    //Select checkboxes Wind
    @FindBy(xpath = "//label[contains(string(), 'Wind')]/input[@type='checkbox']")
    WebElement checkboxWind;

    // Select radio Selen
    @FindBy(xpath = "//label[contains(string(), 'Selen')]/input[@type='radio']")
    WebElement radioSelen;

    //Select dropdown colors
    //@FindBy(xpath = "//div[@class='colors']//select[@class='uui-form-element']"));
    @FindBy(xpath = "//div[@class='main-content-hg']/div[@class='colors']")
    WebElement dropdownColors;

    //Select dropdown Yellow color
    @FindBy(xpath = "//option[text()='Yellow']")
    WebElement dropdownYellow;

    //return to Select dropdown colors, but colors was chosen, already

    //Select panel body list logs
    //There are our logs
    @FindBy(xpath = "//*[@class='panel-body-list logs']")
    WebElement logList;

    // 4 string from logs
    @Getter
    @FindBy(xpath = "//*[@class='panel-body-list logs']/li[contains(string(),'Yellow')]")
    WebElement stringYellow;

    @Getter
    @FindBy(xpath = "//*[@class='panel-body-list logs']/li[contains(string(),'Selen')]")
    WebElement stringSelen;

    @Getter
    @FindBy(xpath = "//*[@class='panel-body-list logs']/li[contains(string(),'Wind')]")
    WebElement stringWind;

    @Getter
    @FindBy(xpath = "//*[@class='panel-body-list logs']/li[contains(string(),'Water')]")
    WebElement stringWater;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickCheckboxWater() {
        checkboxWater.click();
    }

    public void clickCheckboxWind() {
        checkboxWind.click();
    }

    public void clickRadioSelen() {
        radioSelen.click();
    }

    public void clickDropdownColors() {
        dropdownColors.click();
    }

    public void clickDropdownYellow() {
        dropdownYellow.click();
    }

    public WebElement getLogList() {
        return logList;
    }
}
