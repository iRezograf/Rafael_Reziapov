package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.TextField;

public class HomePage extends WebPage {

    @UI("#user-icon")
    public static Icon userIcon;
    @UI("#name")
    public static TextField name;
    @UI("#password")
    public static TextField password;
    @UI("#login-button")
    public static Button loginButton;
    @UI("#user-name")
    public static Text userName;
}
