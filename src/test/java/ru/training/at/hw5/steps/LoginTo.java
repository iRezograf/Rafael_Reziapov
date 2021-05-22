package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.ExerciseOne;
import ru.training.at.hw5.dp.DataStore;

public class LoginTo {
    ExerciseOne exerciseOne;


    public LoginTo(ExerciseOne exerciseOne) {
        this.exerciseOne = new ExerciseOne();
    }


    @When("I click on image User button")
    public void clickImgUser() {
        exerciseOne.getLoginPage().clickImgUser();
    }

    @And("I input the {string} into field Login")
    public void inputLoginName(String name) {
        exerciseOne.inputName(name);
    }

    @And("I input the {string} into field Password")
    public void inputLoginPassword(String password) {
        exerciseOne.inputPassword(password);
    }

    @And("I click 'Enter' button on the top right corner of the Home Page")
    public void clickLoginButton () {
        exerciseOne.getLoginPage().clickBtnEnter();
    }

    @Then("Full 'username' should be displayed on the top right corner of the Home Page")
    public void checkUserNameAfterLogged() {
        System.out.println(DataStore.getProperty("userNameAfterLogged"));
    }
}


