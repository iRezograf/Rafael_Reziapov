package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.dp.DataStore;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.UserTablePageObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.training.at.hw5.hook.WebDriverHook.removeSpaces;

public class UserTableStep {



    @Then("\"User Table\" page should be opened")
    public void userTablePageShouldBeOpened() {
        UserTablePageObj userTablePageObj;
        WebDriver driver;
        driver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);
        Assert.assertEquals(driver.getTitle(), DataStore.getProperty("UserTableWebPageTitle"));
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void isSixNumberTypeDropdown() {
        WebDriver webDriver;
        webDriver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);
        List<WebElement> webElements;

        webElements = webDriver.findElements(By
                .cssSelector("#user-table tbody>tr"));
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void isUserNamesTypeDropdown() {
        WebDriver webDriver;
        webDriver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);
        List<WebElement> webElements;

        webElements = webDriver.findElements(By
                .cssSelector("#user-table tr>td>a"));
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void sixDescriptionAreDisplayed() {
        WebDriver webDriver;
        webDriver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);
        List<WebElement> webElements;

        webElements = webDriver.findElements(By
                .cssSelector("#user-table tr>td>div>span"));
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void sixCheckBoxesAreDisplayed() {
        WebDriver webDriver;
        webDriver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);
        List<WebElement> webElements;

        webElements = webDriver.findElements(By
                .cssSelector("#user-table tr>td>div>input"));
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }


    @And("User table should contain following values:")
    public void userTableContainsRequiredValues(List<List<String>> arg) {
        // Get access to Expected
        // First index - row
        // Second index - col
        //remove row with titles
        arg.remove(0);

        // get Access to actual
        UserTablePageObj userTablePageObj;

        userTablePageObj = new UserTablePageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));

        List<List<String>> s = getActualUserTableList(userTablePageObj);
        // to set identical structure with expected structure
        // remove col with type (index[1])
        for (int i = 0; i < 6; i++) {
            s.get(i).remove(1);
        }

        // In Scenario was error:
        // Hulksome description - without space
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(s.get(i).get(j)).contains(arg.get(i).get(j));
            }
        }
    }

    public List<List<String>> getActualUserTableList(UserTablePageObj userTablePageObj) {
        List<List<String>> elementStrings = new ArrayList<>();
        List<String> elementString;
        List<WebElement> webElements = userTablePageObj.getUserTableList();

        // getting array 6x4
        for (int row = 0; row < webElements.size(); row++) {
            List<WebElement> we = webElements.get(row).findElements(By.cssSelector("td"));
            String s;
            elementString = new ArrayList<>();

            for (int col = 0; col < we.size(); col++) {
                s = we.get(col).getText()
                        .replaceAll(removeSpaces, " ");
                //System.out.println(s);
                elementString.add(s);
            }
            elementStrings.add(elementString);
        }
        // return array 6x4
        return elementStrings;
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesTypeForUserRoman(List<String> expected) {
        // Get expexted values
        //droplist should contain values in column Type for user Roman
        //without title of dropdown = index[0] of List
        expected = expected.subList(1, expected.size());


        // Get Actual values
        WebDriver webDriver;
        webDriver = TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER);

        // Get actual list of User (Roman in 0 row
        List<WebElement> webElements;
        webElements = webDriver.findElements(By
                .cssSelector("#user-table tbody>tr>td>select"));

        List<String> actualList = Arrays.asList(webElements
                .get(0)
                .getText()
                .split(removeSpaces));

        // Every row of webElements.get(0) consist
        // of 2 list: Selected and Type
        // We should remove selected before comparison
        for (int i = 0; i < actualList.size(); i++) {
            if (i % 2 != 1) {
                //actualList.remove(i) - impossible !!! Why too slow?
                //System.out.println(i + actualList.get(i));
            }
        }


        //System.out.println("actual:" + actualList.size() + " :" + actualList);
        //System.out.println("expect:" + expected);
        for (int i = 0; i < 3; i++) {
            //System.out.println("actual:" + actualList.get(i * 2 + 1));
            //System.out.println("expect:" + expected.get(i));
            Assert.assertEquals(actualList.get(i * 2 + 1), expected.get(i));
        }
    }

    @When("I select {string} checkbox for \"Sergey Ivan\"")
    public void selectVipCheckboxForSergeyIvan(String vip) {
        // get Access to actual
        UserTablePageObj userTablePageObj;

        userTablePageObj = new UserTablePageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));

        //userTablePageObj.getCheckBoxIvan().click();
        String numberCheckBoxForIvan = DataStore.getProperty(vip);
        userTablePageObj
                .getCheckBoxList()
                .get(Integer.parseInt(numberCheckBoxForIvan))
                .click();


    }

    @Then("I log row has \"Vip: condition changed to true\" text in log section")
    public void logRowHasRequiredTextInLogSection() {
        UserTablePageObj userTablePageObj;

        userTablePageObj = new UserTablePageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));

        List<String> actual = userTablePageObj.getLogListAsString();
        String expected = DataStore.getProperty("textFromLogListVipIvan");

        Assert.assertTrue(actual.get(0).contains(expected));
    }
}
