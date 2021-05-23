package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.training.at.hw4.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.BaseComponent;
import ru.training.at.hw5.pageobjects.DifferentElementsPageObj;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentElementsStep {

    DifferentElementsPageObj differentElementsPageObj;

    public DifferentElementsStep() {
        this.differentElementsPageObj = new DifferentElementsPageObj(
                        TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
    }

    @And("I click checkbox \"Water\"")
    public void clickCheckboxWater() {
        differentElementsPageObj = new DifferentElementsPageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));

        //RRA
        // waiting.until(ExpectedConditions.
        //        elementToBeClickable(
        //                differentElementsPageObj.getCheckboxWater()));
        differentElementsPageObj.getCheckboxWater().click();
    }

    @And("I click checkbox \"Wind\"")
    public void clickCheckboxWind() {
        differentElementsPageObj.getCheckboxWind().click();
    }

    @And("I click radio \"Selen\"")
    public void clickRadioSelen() {
        differentElementsPageObj.getRadioSelen().click();
    }

    @And("I click dropdown button")
    public void clickDropDownButton() {
        differentElementsPageObj.getDropdownColors().click();
    }

    @And("I select \"Yellow\"")
    public void selectYellow() {
        differentElementsPageObj.getDropdownYellow().click();
        differentElementsPageObj.getDropdownColors().click();
    }

    @Then("checkbox \"Water\" should be selected")
    public void checkboxWaterShouldBeSelected() {
        Assert.assertTrue(differentElementsPageObj
                .getCheckboxWater().isSelected());
    }

    @Then("checkbox \"Wind\" should be selected")
    public void checkboxWindShouldBeSelected() {
        Assert.assertTrue(differentElementsPageObj
                .getCheckboxWind().isSelected());
    }

    @And("radio \"Selen\" should be selected")
    public void radioSelenShouldBeSelected() {
        Assert.assertTrue(differentElementsPageObj
                .getRadioSelen().isSelected());
    }

    @And("dropdown \"Yellow\" should be selected")
    public void dropDownYellowShouldBeSelected() {
        Assert.assertTrue(differentElementsPageObj
                .getDropdownYellow().isSelected());
    }

    @And("log rows should displayed their names, status and values are corresponding to selected")
    public void logRowsDisplayedAndCorresponding() {
        assertThat(differentElementsPageObj.getLogListAsString()).isEqualTo(getExceptedLogList());
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
