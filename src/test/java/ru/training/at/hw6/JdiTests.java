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
import ru.training.at.hw6.providers.MetalsAndColors;
import ru.training.at.hw6.providers.MetalsAndColorsDtProvider;

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
    }

    @Test(priority = 10)
    public void jdiTestRun() {
        SiteJdi.open();
        LoginForm.loginAs(user);
        openMenu(DataStore.getProperty("textOfHeaderMenuButtonsList4"));

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

    @Test(priority = 20,
            dataProvider = "MetalsAndColorsDtProvider",
            dataProviderClass = MetalsAndColorsDtProvider.class)
    public void fillMetalsAndColors(MetalsAndColors metalsAndColors) {

        for (int i = 0; i < metalsAndColors.getSummary().size(); i++) {
            int radio = metalsAndColors.getSummary().get(i);
            if (radio %  2 == 0) {
                MetalsAndColorsForm.customRadioEven.select(
                        radio / 2);
            } else {
                MetalsAndColorsForm.customRadioOdd.select(
                        (radio + 1) / 2);
            }
        }

        MetalsAndColorsForm.metals.select(metalsAndColors.getMetals());

        MetalsAndColorsForm.colors.select(metalsAndColors.getColor());

        for (String val : metalsAndColors.getVegetables()) {
            MetalsAndColorsForm.vegetables.select(val);
        }

        for (String val : metalsAndColors.getElements()) {
            MetalsAndColorsForm.elements.select(val);
        }

        MetalsAndColorsForm.submitButton.click();
    }
}
