package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HomePage extends WebPage {

    @UI("#name")
    public static TextField name;
    @UI("#password")
    public static TextField password;
    @UI("#user-name")
    public static Text userName;

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    public static Menu headMenu;

}
