package ru.training.at.hw6.comjdi.tests;

import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static ru.training.at.hw6.comjdi.data.ContactsDataProvider.SIMPLE_CONTACT;
import static ru.training.at.hw6.comjdi.data.UsersDataProvider.ROMAN;

public class NoPoExample {
    @Test
    public void contactFormTest() {
        //DOMAIN = "https://jdi-testing.github.io/jdi-light/";
        openUrl("/");
        $("img#user-icon").click();
        loginAs(ROMAN);
        openUrl("/contacts.html");
        submitForm("form#contact-form", SIMPLE_CONTACT);
    }

}
