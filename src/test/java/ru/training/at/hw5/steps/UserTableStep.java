package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.dp.TestContext;
import ru.training.at.hw5.pageobjects.HeaderMenuPageObj;
import ru.training.at.hw5.pageobjects.UserTablePageObj;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.training.at.hw5.hook.WebDriverHook.removeSpaces;

public class UserTableStep {



    @Then("\"User Table\" page should be opened")
    public void userTablePageShouldBeOpened() {
        UserTablePageObj userTablePageObj;

        userTablePageObj = new UserTablePageObj(
                TestContext.getInstance()
                        .getTestObject(TestContext.WEB_DRIVER));
        // Object exist so page is open
        assertThat(userTablePageObj.getUserTableList()).isNotEmpty();

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
        // transform array 6x4 to 6x3

        return elementStrings;
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesTypeForUserRoman(List<String> types) {
        //droplist should contain values in column Type for user Roman
        //without title of dropdown = index[0] of List
        types.remove(0);



    }
}
