package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[contains(string(),'Home')]")
    WebElement leftMenuItemHome;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[contains(string(),'Contact form')]")
    WebElement leftMenuItemContactForm;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[contains(string(),'Service')]")
    WebElement leftMenuItemService;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[contains(string(),'Metals & Colors')]")
    WebElement leftMenuItemMetalsAndColors;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[contains(string(),'Elements packs')]")
    WebElement leftMenuItemElementsPacks;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getLeftMenuItemService() {
        return leftMenuItemService.getText();
    }

    public String getTextLeftMenuItemHome() {
        return leftMenuItemHome.getText();
    }

    public String getTextLeftMenuItemContactForm() {
        return leftMenuItemContactForm.getText();
    }

    public String getTextLeftMenuItemService() {
        return leftMenuItemService.getText();
    }

    public String getTextLeftMenuItemMetalsAndColors() {
        return leftMenuItemMetalsAndColors.getText();
    }

    public String getTextLeftMenuItemElementsPacks() {
        return leftMenuItemElementsPacks.getText();
    }


}
