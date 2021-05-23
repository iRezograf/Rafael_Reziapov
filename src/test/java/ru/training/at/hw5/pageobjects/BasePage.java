package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.dp.DataStore;

public abstract class BasePage extends BaseComponent {

    private static final String BASE_URL = DataStore.getProperty("siteUrl");
            //"https://jdi-testing.github.io/jdi-light/index.html";

    //protected HeaderComponent header;

    protected BasePage(WebDriver driver) {
        super(driver);
        //header = new HeaderComponent(driver);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
