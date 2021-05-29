package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePageObj extends DifferentElementsPageObj {

    @FindBy(css = "#user-table>tbody>tr")
    List<WebElement> userTableList;

    @FindBy(css = "#user-table>tbody>tr>td>div>input")
    List<WebElement>  checkBoxList;

    @FindBy(css = "#ivan")
    WebElement checkBoxIvan;


    public UserTablePageObj(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getUserTableList() {
        return userTableList;
    }

    public List<WebElement> getCheckBoxList() {
        return checkBoxList;
    }

    public WebElement getCheckBoxIvan() {
        return checkBoxIvan;
    }

}
