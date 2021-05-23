package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.LoginPageObj;

public class LoginTo {
    LoginPageObj loginPageObj;

    public LoginTo() {
        this.loginPageObj = new LoginPageObj(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));;
    }


    @When("I click on image User button")
    public void clickImgUser() {
        //loginPage = new LoginPage(TestContext.getInstance()
        //        .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickImgUser();
    }

    @And("I input the {string} into field Login")
    public void inputLoginName(String name) {
        //loginPage = new LoginPage(TestContext.getInstance()
        //        .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.inputFieldLogin(name);
        //loginPage.inputFieldLogin(
        //        DataStore.getProperty("userName"));
    }

    @And("I input the {string} into field Password")
    public void inputLoginPassword(String password) {
        //loginPage = new LoginPage(TestContext.getInstance()
        //        .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.inputFieldPassword(password);
        //loginPage.inputFieldPassword(
        //        DataStore.getProperty("password"));
    }

    @And("I click 'Enter' button on the top right corner of the Home Page")
    public void clickLoginButton() {
        //loginPage = new LoginPage(TestContext.getInstance()
        //        .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickBtnEnter();
    }

    @Then("Full {string} should be displayed on the top right corner of the Home Page")
    public void checkUserNameAfterLogged(String userNameAfterLogged) {
        //loginPage = new LoginPage(
        //        TestContext.getInstance()
        //        .getTestObject(TestContext.WEB_DRIVER));
        Assert.assertEquals(loginPageObj.getUserName(), userNameAfterLogged);
        //Assert.assertEquals(
        //        loginPage.getUserName(),
        //        DataStore.getProperty("userNameAfterLogged"));
    }

    //
    @Given("I login as user \"Roman Iovlev\"")
    public void iLoginAsUser(){
        //loginPage = new LoginPage(
        //        TestContext.getInstance()
        //                .getTestObject(TestContext.WEB_DRIVER));
        loginPageObj.clickImgUser();
        loginPageObj.inputFieldLogin(DataStore.getProperty("userName"));
        loginPageObj.inputFieldPassword(DataStore.getProperty("password"));
        loginPageObj.clickBtnEnter();
    }

}


