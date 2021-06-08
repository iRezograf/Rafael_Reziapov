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

    public User roman;

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
        roman = new User().set(c -> {
            c.setName("Roman");
            c.setPassword("Jdi1234");
            c.setUserName(DataStore.getProperty("userNameAfterLogged"));
        });
    }

    @Test(priority = 10)
    public void jdiTestRun() {

        SiteJdi.open();

    }

    @Test(priority = 15)
    public void loginTest() {

        LoginForm.loginAs(roman);
        LoginForm.userName.assertThat().is().displayed();

    }

    @Test(priority = 15)
    public void openMenuTest() {

        HomePage.openMenu(DataStore.getProperty("textOfHeaderMenuButtonsList4"));
        Assert.assertEquals(WebPage.getTitle(),
                DataStore.getProperty(
                        DataStore
                                .getProperty("textOfHeaderMenuButtonsList4")
                                .replaceAll(" ", "")));

    }

    @Test(priority = 20,
            dataProvider = "MetalsAndColorsDtProvider",
            dataProviderClass = MetalsAndColorsDtProvider.class)
    public void fillMetalsAndColors(MetalsAndColors metalsAndColors) {

        MetalsAndColorsForm.fillForm(metalsAndColors);
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


}
