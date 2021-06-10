package ru.training.at.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalsAndColorsForm;
import ru.training.at.hw6.pages.HomePage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("/index.html")
    @Title("Home Page")
    public static HomePage homePage;

    @Url("/index.html")
    @Title("Home Page")
    public static LoginForm loginForm;

    @UI(".form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    public static void open() {
        homePage.open();
    }
}