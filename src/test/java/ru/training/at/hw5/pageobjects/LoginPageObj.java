package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageObj extends BasePage {

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

    public LoginPageObj(WebDriver driver) {
        super(driver);
    }

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

    public String getLoggedUserName() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //waiting.until(ExpectedConditions.visibilityOf(loggedUserName));
        String userName = loggedUserName.getText();
        return userName;
    }

}
