package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalsAndColorsForm;
import ru.training.at.hw6.pages.HomePage;
import ru.training.at.hw6.providers.DataStore;
import ru.training.at.hw6.providers.MetalsAndColorsDataProvider;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;


public class JdiTests {

    public User user;

    @BeforeSuite(alwaysRun = true)
    static void beforeSuite() {
        initElements(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @BeforeMethod()
    public void beforeMethod() {

        user = new User();
        user.setName(DataStore.getProperty("userName"));
        user.setPassword(DataStore.getProperty("password"));
        user.setUserName(DataStore.getProperty("userNameAfterLogged"));
        System.out.println(user);
    }

    @Test(priority = 10)
    public void jdiTestRun() {
        SiteJdi.open();
        LoginForm.loginAs(user);
        //Assert.assertTrue(LoginForm.isLogged(user));
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

        for (int i = 0; i < summary.size(); i++) {
            if (summary.get(i).intValue() %  2 == 0) {
                MetalsAndColorsForm.customRadioEven.select(
                        (summary.get(i).intValue()) / 2);
            } else {
                MetalsAndColorsForm.customRadioOdd.select(
                        (summary.get(i).intValue() + 1) / 2);
            }
        }

        MetalsAndColorsForm.metals.select(metals);

        MetalsAndColorsForm.colors.select(color);

        for (String val : vegetables) {
            MetalsAndColorsForm.vegetables.select(val);
        }

        for (String val : elements) {
            MetalsAndColorsForm.elements.select(val);
        }

        MetalsAndColorsForm.submitButton.click();
    }


    @Test(priority = 50)
    public void lastResultAssertion() {
        List<String> actualResult = new ArrayList<>();
        for (WebElement element : MetalsAndColorsForm.panelBodyListResults) {
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
        //"Metals & Colors");
        HomePage.headMenu.select(menuName);
        Assert.assertEquals(WebPage.getTitle(),
                            DataStore.getProperty(menuName.replaceAll(" ", "")));

    }
}
