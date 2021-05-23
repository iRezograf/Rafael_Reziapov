package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HomePage;

public class OpenUrl {

    @Given("I open JDI GitHub site")
    public void loginToEpamTestUrl() {
        HomePage homePage = new HomePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        homePage.open("index");
        //softAssert.assertEquals(driver.getTitle(), expectedTitle);
        //GetAttachment.getBytes("HomePage.png");
    }
}
