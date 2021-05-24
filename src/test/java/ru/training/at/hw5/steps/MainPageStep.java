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

    @Given("I open JDI GitHub site")
    public void loginToEpamTestUrl() {
        new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .open("index.html");
    }

    @When("I click on image User button")
    public void clickImgUser() {
        new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .clickImgUser();
    }

    @And("I input the {string} into field Login")
    public void inputLoginName(String name) {
        new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .inputFieldLogin(name);
    }

    @And("I input the {string} into field Password")
    public void inputLoginPassword(String password) {
        new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .inputFieldPassword(password);
    }

    @And("I click 'Enter' button on the top right corner of the Home Page")
    public void clickLoginButton() {
        new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .clickBtnEnter();
    }

    @Then("Full {string} should be displayed on the top right corner of the Home Page")
    public void checkUserNameAfterLogged(String userNameAfterLogged) {
        LoginPageObj loginPageObj = new LoginPageObj(TestContext
                .getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        assertThat(loginPageObj.getLoggedUserName())
                .isEqualTo(userNameAfterLogged);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void iloginAsUser() {
        LoginPageObj loginPageObj = new LoginPageObj(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickImgUser();
        loginPageObj.inputFieldLogin(DataStore.getProperty("userName"));
        loginPageObj.inputFieldPassword(DataStore.getProperty("password"));
        loginPageObj.clickBtnEnter();
    }

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
}



