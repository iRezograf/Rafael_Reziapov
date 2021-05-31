package ru.training.at.hw6;

import com.epam.jdi.light.elements.composite.WebPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.interfaces.TestsInit;
import ru.training.at.hw6.providers.DataStore;
import ru.training.at.hw6.providers.LoginUserData;
import ru.training.at.hw6.providers.MetalsAndColorsDataProvider;

import java.util.List;

import static ru.training.at.hw6.SiteJdi.homePage;
import static ru.training.at.hw6.SiteJdi.metalsAndColorsForm;


public class JdiTests implements TestsInit {
    LoginUserData loginUserData;

    @BeforeMethod()
    public void BeforeMethode() {
        loginUserData = new LoginUserData();
        loginUserData.setUserName(DataStore.getProperty("userName"));
        loginUserData.setPassword(DataStore.getProperty("password"));
        loginUserData.setUserNameAfterLogged(DataStore.getProperty("userNameAfterLogged"));
    }

    @Test
    public void jdiTestRun() {

        //loginTest(loginUserData);

        //openMenu(DataStore.getProperty("textOfHeaderMenuButtonsList4"));

        //fillMetalsAndColorsForm();

    }


    @Test(dataProvider = "MetalsAndColorsDataProvider",
            dataProviderClass = MetalsAndColorsDataProvider.class)
    public void checkDataProvider(List<String> elements
            , String color
            , String metals
            , List<String> vegetables
            , List<Integer> summary) {
        System.out.println(summary);
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

    public void fillMetalsAndColorsForm() {

        metalsAndColorsForm.customRadioOdd.select(3);
        metalsAndColorsForm.customRadioEven.select(2);

        metalsAndColorsForm.metals.select("Gold");
        metalsAndColorsForm.metals.select("Selen");

        metalsAndColorsForm.colors.select("Red");
        metalsAndColorsForm.colors.select("Green");

        // Only one value !
        metalsAndColorsForm.vegetables.select("Cucumber");
        metalsAndColorsForm.vegetables.select(2);
        metalsAndColorsForm.vegetables.select("Onion");

        metalsAndColorsForm.elements.select("Wind");
        metalsAndColorsForm.elements.select("Water");

        metalsAndColorsForm.submitButton.click();
    }
}
