package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.training.at.hw4.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.BaseComponent;
import ru.training.at.hw5.pageobjects.BasePage;
import ru.training.at.hw5.pageobjects.DifferentElementsPageObj;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentElementsStep  {

    @And("I click checkbox \"Water\"")
    public void clickCheckboxWater() {
        DifferentElementsPageObj difElPg;
        difElPg = new DifferentElementsPageObj(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
        new WebDriverWait(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER), 10)
                .until(ExpectedConditions
                        .titleContains(difElPg.getHeadTitle().getText()));

        difElPg.open("different-elements.html");
        System.out.println(difElPg.getHeadTitle().getText());

                //new DifferentElementsPageObj(
                //        TestContext.getInstance()
                //                .getTestObject(TestContext.WEB_DRIVER))
                //        .getHeadTitle()
                //        .getText());

        new WebDriverWait(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER), 10)
                .until(ExpectedConditions
                .elementToBeClickable(difElPg
                .getCheckboxWater()))
                .click();
        System.out.println(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                        .getHeadTitle()
                        .getText());
    }

    @And("I click checkbox \"Wind\"")
    public void clickCheckboxWind() {
        new DifferentElementsPageObj(
                TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .getCheckboxWind().click();
    }

    @And("I click radio \"Selen\"")
    public void clickRadioSelen() {
        new DifferentElementsPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER))
                .getRadioSelen().click();
    }

    @And("I click dropdown button")
    public void clickDropDownButton() {
        new DifferentElementsPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER))
                .getDropdownColors().click();
    }

    @And("I select \"Yellow\"")
    public void selectYellow() {
        new DifferentElementsPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER))
                .getDropdownYellow().click();
        new DifferentElementsPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER))
                .getDropdownColors().click();
    }

    @Then("checkbox \"Water\" should be selected")
    public void checkboxWaterShouldBeSelected() {
        Assert.assertTrue(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                        .getCheckboxWater().isSelected());
    }

    @Then("checkbox \"Wind\" should be selected")
    public void checkboxWindShouldBeSelected() {
        Assert.assertTrue(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                        .getCheckboxWind().isSelected());
    }

    @And("radio \"Selen\" should be selected")
    public void radioSelenShouldBeSelected() {
        Assert.assertTrue(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                        .getRadioSelen().isSelected());
    }

    @And("dropdown \"Yellow\" should be selected")
    public void dropDownYellowShouldBeSelected() {
        Assert.assertTrue(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                        .getDropdownYellow().isSelected());
    }

    @And("log rows should displayed their names, status and values are corresponding to selected")
    public void logRowsDisplayedAndCorresponding() {
        assertThat(
                new DifferentElementsPageObj(
                        TestContext.getInstance()
                                .getTestObject(TestContext.WEB_DRIVER))
                .getLogListAsString()).isEqualTo(getExceptedLogList());
    }

    private List<String> getExceptedLogList() {
        // I made a fail condition in this method
        // I hope get screenshot in Allure
        String s1 = DataStore.getProperty("textFromLogList2");
        String s2 = DataStore.getProperty("textFromLogList2");
        String s3 = DataStore.getProperty("textFromLogList3");
        String s4 = DataStore.getProperty("textFromLogList4");
        return Arrays.asList(s1, s2, s3, s4);
    }
}
