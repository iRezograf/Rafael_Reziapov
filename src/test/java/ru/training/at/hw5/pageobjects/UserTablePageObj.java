package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePageObj extends BasePage {

    @FindBy(css = "#user-table>tbody>tr")
    List<WebElement> userTableList;


    public UserTablePageObj(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getUserTableList() {
        return userTableList;
    }

}
