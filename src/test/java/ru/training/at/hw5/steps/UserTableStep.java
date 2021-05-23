package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HeaderMenuPageObj;

public class UserTableStep {
    HeaderMenuPageObj headerMenuPageObj;

    public UserTableStep() {
        this.headerMenuPageObj = new HeaderMenuPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
    }



    @And("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButtonInService() {
        headerMenuPageObj.headerMenuItemUserTable().click();
    }

    @Then("\"User Table\" page should be opened")
    public void userTablePageShouldBeOpened() {
        // Это Exercise 2 - его сделаем после Exercise 1
    }

}
