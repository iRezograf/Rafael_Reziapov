package ru.training.at.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw2.dataproviders.DataStoreForHomeworkTwo;

public class LoginPage {
    public WebDriver driver;
    public DataStoreForHomeworkTwo dp;



    public LoginPage(WebDriver driver) {
        dp = new DataStoreForHomeworkTwo();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='user-icon']")
    private WebElement imgUser;

    @FindBy (xpath = "//*[@id='name']")
    private  WebElement fieldLogin;

    @FindBy (xpath = "//*[@id='password']")
    private  WebElement fieldPassword;

    @FindBy (xpath = "//*[@id='login-button']")
    private  WebElement btnEnter;

    @FindBy (xpath = "//*[@id='user-name']")
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']")));
        String userName = loggedUserName.getText();
        return userName;
    }
}
