package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
    public WebDriver driver;

    @FindBy (xpath = "//li[contains(string(), 'Home')]/a[contains(@href,'')]")
    private WebElement headerMenuItemHome;

    @FindBy (xpath = "//li[contains(string(), 'Contact form')]/a[contains(@href,'')]")
    private WebElement headerMenuItemContactForm;

    @FindBy (xpath = "//li[contains(string(), 'Service')]/a[contains(@href,'')]")
    private WebElement headerMenuItemService;

    @FindBy (xpath = "//li[contains(string(), 'Metals & Colors')]/a[contains(@href,'')]")
    private WebElement headerMenuItemMetalColors;

    @FindBy (xpath = "//*[@class='dropdown-menu']/li[contains(string(),'Different elements')]")
    private WebElement headerMenuItemDifferentElements;


    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHeaderMenuItemHome() {
        return headerMenuItemHome.getText();
    }

    public String getHeaderMenuItemContactForm() {
        return headerMenuItemContactForm.getText();
    }


    //Service
    public String getHeaderMenuItemService() {
        return headerMenuItemService.getText();
    }

    public WebElement headerMenuItemService() {
        return headerMenuItemService;
    }

    public void clickHeaderMenuItemService() {
        headerMenuItemService.click();
    }

    //MetalColors
    public String getHeaderMenuItemMetalColors() {
        return headerMenuItemMetalColors.getText();
    }

    public WebElement headerMenuItemMetalColors() {
        return headerMenuItemMetalColors;
    }

    public void clickHeaderMenuItemMetalColors() {
        headerMenuItemMetalColors.click();
    }

    //DifferentElementsStep
    public String getHeaderMenuItemDifferentElements() {
        return headerMenuItemDifferentElements.getText();
    }

    public void clickHeaderMenuItemDifferentElements() {
        headerMenuItemDifferentElements.click();
    }







}
