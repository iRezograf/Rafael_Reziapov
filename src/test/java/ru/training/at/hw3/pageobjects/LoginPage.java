package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (id = "user-icon")
    private WebElement imgUser;

    @FindBy (id = "name")
    private  WebElement fieldLogin;

    @FindBy (id = "password")
    private  WebElement fieldPassword;

    @FindBy (id = "login-button")
    private  WebElement btnEnter;

    @FindBy (id = "user-name")
    private  WebElement loggedUserName;


    public void clickImgUser() {
        this.imgUser.click();
    }

    public void inputFieldLogin(String name) {
        this.fieldLogin.sendKeys(name);
    }

    public void inputFieldPassword(String password) {
        this.fieldPassword.sendKeys(password);
    }

    public void clickBtnEnter() {
        this.btnEnter.click();
    }

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loggedUserName));
        String userName = loggedUserName.getText();
        return userName;
    }
}
