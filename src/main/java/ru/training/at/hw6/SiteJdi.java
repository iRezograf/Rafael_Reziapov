package ru.training.at.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw6.pages.HomePage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("/index.html")
    @Title("Home Page")
    public static HomePage homePage;

    public static void open() {
        homePage.open();
    }


    //@Url("/contacts") @Title("Contact Form")
    //public static ContactsPage contactPage;
}
