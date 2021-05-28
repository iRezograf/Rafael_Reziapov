package jdisite;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;


import com.epam.jdi.light.ui.html.elements.common.Text;
import jdisite.pages.ContactPage;
import jdisite.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDISite {
    @Url("/") public static WebPage homePage;
    public static ContactPage contactPage;

    public static LoginForm loginForm;

    @UI("img#user-icon") public static Link userIcon;
    @UI("#user-name") public static Text userName;
    @UI(".sidebar-menu span") public static Menu sideMenu;

    @Url("/index.html")
    public static JDIHomePage jdiHomePage;

    public static void open() {
        jdiHomePage.open();
    }
}
