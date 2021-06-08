package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

public class HomePage extends WebPage {

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    public static Menu headMenu;

    public static void openMenu(String menuName) {
        //"Metals & Colors");
        headMenu.select(menuName);
    }
}
