package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw4.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.LoginPage;

public class LoginTo {
    LoginPage loginPage;


    @When("I click on image User button")
    public void clickImgUser() {
        loginPage = new LoginPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPage.clickImgUser();
    }

    @And("I input the {string} into field Login")
    public void inputLoginName(String name) {
        loginPage = new LoginPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPage.inputFieldLogin(name);
        //loginPage.inputFieldLogin(
        //        DataStore.getProperty("userName"));
    }

    @And("I input the {string} into field Password")
    public void inputLoginPassword(String password) {
        loginPage = new LoginPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPage.inputFieldPassword(password);
        //loginPage.inputFieldPassword(
        //        DataStore.getProperty("password"));
    }

    @And("I click 'Enter' button on the top right corner of the Home Page")
    public void clickLoginButton() {
        loginPage = new LoginPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        loginPage.clickBtnEnter();
    }

    @Then("Full {string} should be displayed on the top right corner of the Home Page")
    public void checkUserNameAfterLogged(String userNameAfterLogged) {
        loginPage = new LoginPage(
        TestContext.getInstance()
        .getTestObject(TestContext.WEB_DRIVER));
        Assert.assertEquals(loginPage.getUserName(), userNameAfterLogged);
        //Assert.assertEquals(
        //        loginPage.getUserName(),
        //        DataStore.getProperty("userNameAfterLogged"));
    }
}


