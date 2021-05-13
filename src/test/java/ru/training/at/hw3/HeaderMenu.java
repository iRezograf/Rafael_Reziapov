package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
    public WebDriver driver;

    //@FindBy (xpath = "//ul [contains(@class,'')]/li")
    //private List<WebElement> headerMenu;

    @FindBy (xpath = "//li[contains(string(), 'Home')]/a[contains(@href,'')]")
    private WebElement headerMenuItemHome;

    @FindBy (xpath = "//li[contains(string(), 'Contact form')]/a[contains(@href,'')]")
    private WebElement headerMenuItemContactForm;

    @FindBy (xpath = "//li[contains(string(), 'Service')]/a[contains(@href,'')]")
    private WebElement headerMenuItemService;

    @FindBy (xpath = "//li[contains(string(), 'Metals & Colors')]/a[contains(@href,'')]")
    private WebElement headerMenuItemMetalColors;


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

    public String getHeaderMenuItemService() {
        return headerMenuItemService.getText();
    }

    public void clickHeaderMenuItemService() {
        headerMenuItemService.click();
    }

    public String getHeaderMenuItemMetalColors() {
        return headerMenuItemMetalColors.getText();
    }

    //public List<WebElement> getHeaderMenu() {
    //    return headerMenu;
    //}

    //public WebElement getHeaderMenuItem(int item) {
    //    return headerMenu.get(item);
    //}



    // //li[contains(string(), 'Contact form')]/a[contains(@href,'')]

    // //li[contains(string(), 'Service')]/a[contains(@href,'')] - click()

    // //li[contains(string(), 'Metals & Colors')]/a[contains(@href,'')]
}
