package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HeaderMenuPageObj;

public class UserTable {
    HeaderMenuPageObj headerMenuPageObj;

    public UserTable() {
        this.headerMenuPageObj = new HeaderMenuPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));;
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        headerMenuPageObj.headerMenuItemService().click();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButtonInService() {
        headerMenuPageObj.headerMenuItemUserTable().click();
    }

    @Then("\"User Table\" page should be opened")
    public void userTablePageShouldBeOpened() {

    }

}
