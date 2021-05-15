package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceSubMenu {
    public WebDriver driver;

    @FindBy (xpath = "//li[contains(string(), 'Service')]/a[contains(@href,'')]")
    private WebElement headerMenuItemService;

    @FindBy (xpath = "//li[contains(string(), 'Metals & Colors')]/a[contains(@href,'')]")
    private WebElement headerMenuItemMetalColors;


    public ServiceSubMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHeaderMenuItemService() {
        return headerMenuItemService.getText();
    }

    public String getHeaderMenuItemMetalColors() {
        return headerMenuItemMetalColors.getText();
    }

    public void clickHeaderMenuItemService() {
        headerMenuItemService.click();
    }

    public void clickHeaderMenuItemMetalColors() {
        headerMenuItemMetalColors.click();
    }






}
