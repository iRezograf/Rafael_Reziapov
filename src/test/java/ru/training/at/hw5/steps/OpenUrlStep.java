package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HomePage;

public class OpenUrlStep {

    @Given("I open JDI GitHub site")
    public void loginToEpamTestUrl() {
        new HomePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).open();
    }
}
