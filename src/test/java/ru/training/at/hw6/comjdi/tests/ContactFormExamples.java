package ru.training.at.hw6.comjdi.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.comjdi.TestsInit;

import java.util.List;

import static jdisite.JDISite.contactPage;
import static jdisite.JDISite.sideMenu;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.contactForm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static ru.training.at.hw6.comjdi.data.ContactsDataProvider.FULL_CONTACT;
import static ru.training.at.hw6.comjdi.data.ContactsDataProvider.SIMPLE_CONTACT;
import static ru.training.at.hw6.comjdi.states.State.loggedIn;

public class ContactFormExamples extends TestsInit {

    @BeforeMethod
    public void before() {
        loggedIn();
    }

    @Test
    public void fullContactFormTest() {
        sideMenu.select("Contact form");
        contactPage.checkOpened();
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
    @Test
    public void simpleContactFormTest() {
        sideMenu.select(ContactForm);
        contactPage.checkOpened();
        contactForm.submit(SIMPLE_CONTACT);
        contactForm.check(SIMPLE_CONTACT);
    }
    @Test
    public void failCheckExample() {
        sideMenu.select(ContactForm);
        contactPage.checkOpened();
        contactForm.fill(FULL_CONTACT);
        contactForm.acceptConditions.uncheck();
        contactForm.submit();
        List<String> result = contactForm.verify(FULL_CONTACT);
        assertThat(result, Matchers.hasSize(1));
        assertThat(result, hasItem("Field 'acceptConditions' (Actual: 'false' <> Expected: 'true')"));
    }
}
