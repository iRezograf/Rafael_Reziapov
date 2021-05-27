package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HeaderMenuPageObj;

public class HeaderPageStep {

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        new HeaderMenuPageObj(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .headerMenuItemService()
                .click();
    }

    @And("I click on Different Elements\" button in Service dropdown")
    public void clickOnDifferentElementsButtonInServiceDropdown() {
        new HeaderMenuPageObj(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .headerMenuItemDifferentElements()
                .click();
        // Continues in DifferentElementsStep ...
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButtonInService() {
        HeaderMenuPageObj headerMenuPageObj = new HeaderMenuPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
        headerMenuPageObj.headerMenuItemUserTable().click();
    }
}



