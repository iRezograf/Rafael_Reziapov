package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HeaderMenuPageObj;
import ru.training.at.hw5.pageobjects.LoginPageObj;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageStep {

    @When("I click on image User button")
    public void clickImgUser() {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickImgUser();
    }

    @And("I input the {string} into field Login")
    public void inputLoginName(String name) {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.inputFieldLogin(name);
    }

    @And("I input the {string} into field Password")
    public void inputLoginPassword(String password) {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.inputFieldPassword(password);
    }

    @And("I click 'Enter' button on the top right corner of the Home Page")
    public void clickLoginButton() {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickBtnEnter();
    }

    @Then("Full {string} should be displayed on the top right corner of the Home Page")
    public void checkUserNameAfterLogged(String userNameAfterLogged) {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        assertThat(loginPageObj.getUserName())
                .isEqualTo(userNameAfterLogged);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void iloginAsUser() {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickImgUser();
        loginPageObj.inputFieldLogin(DataStore.getProperty("userName"));
        loginPageObj.inputFieldPassword(DataStore.getProperty("password"));
        loginPageObj.clickBtnEnter();
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        HeaderMenuPageObj headerMenuPageObj = new HeaderMenuPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
        headerMenuPageObj.headerMenuItemService().click();
    }

    @And("I click on Different Elements\" button in Service dropdown")
    public void clickOnDifferentElementsButtonInServiceDropdown() {
        HeaderMenuPageObj headerMenuPageObj = new HeaderMenuPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
        headerMenuPageObj.headerMenuItemDifferentElements().click();
    }
}



