package ru.training.at.hw6;

import com.epam.jdi.light.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.providers.DataStore;
import ru.training.at.hw6.providers.LoginUserData;
import ru.training.at.hw6.providers.MetalsAndColorsDataProvider;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.SiteJdi.*;


public class JdiTests extends TestsInit{
    LoginUserData loginUserData;

    @BeforeMethod()
    public void BeforeMethode() {
        loginUserData = new LoginUserData();
        loginUserData.setUserName(DataStore.getProperty("userName"));
        loginUserData.setPassword(DataStore.getProperty("password"));
        loginUserData.setUserNameAfterLogged(DataStore.getProperty("userNameAfterLogged"));
    }

    @Test(priority = 10)
    public void jdiTestRun() {

        loginTest(loginUserData);
        openMenu(DataStore.getProperty("textOfHeaderMenuButtonsList4"));

    }

    @Test(priority = 20,
            dataProvider = "MetalsAndColorsDataProvider",
            dataProviderClass = MetalsAndColorsDataProvider.class)
    public void fillMetalsAndColorsForm(List<Number> summary,
                                        List<String> elements,
                                        String color,
                                        String metals,
                                        List<String> vegetables) {

        for (int i = 0; i < summary.size(); i++){
            if ( summary.get( i).intValue() %  2 == 0) {
                metalsAndColorsForm.customRadioEven.select(
                        (summary.get(i).intValue()) / 2);
            } else {
                metalsAndColorsForm.customRadioOdd.select(
                        (summary.get(i).intValue() + 1) / 2);
            }
        }

        metalsAndColorsForm.metals.select(metals);

        metalsAndColorsForm.colors.select(color);

        for (String val : vegetables) {
            metalsAndColorsForm.vegetables.select(val);
        }

        for (String val : elements) {
            metalsAndColorsForm.elements.select(val);
        }

        metalsAndColorsForm.submitButton.click();
    }


    @Test(priority = 50)
    public void lastResultAssertion() {
        List<String> actualResult = new ArrayList<>();
        for (WebElement element : metalsAndColorsPage.panelBodyListResults) {
            actualResult.add(element.getText());
        }

        Assert.assertEquals(actualResult.get(0),
                DataStore.getProperty("lastResultSummary"));
        Assert.assertEquals(actualResult.get(1),
                DataStore.getProperty("lastResultElements"));
        Assert.assertEquals(actualResult.get(2),
                DataStore.getProperty("lastResultColor"));
        Assert.assertEquals(actualResult.get(3),
                DataStore.getProperty("lastResultMetals"));
        Assert.assertEquals(actualResult.get(4),
                DataStore.getProperty("lastResultVegetables"));
    }

    public void openMenu(String menuName) {
        homePage.headMenu.select(menuName); //"Metals & Colors");
        Assert.assertEquals(WebPage.getTitle(), "Metal and Colors");

    }

    public void loginTest(LoginUserData loginUserData) {
        SiteJdi.open();
        homePage.userIcon.click();
        homePage.name.sendKeys(loginUserData.getUserName());
        homePage.password.sendKeys(loginUserData.getPassword());
        homePage.loginButton.click();
        homePage.userName.assertThat().is().text(loginUserData.getUserNameAfterLogged());
    }


}
