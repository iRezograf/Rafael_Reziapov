package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw6.entities.User;

public class LoginForm {

    @UI("#user-icon")
    public static Link userIcon;

    @UI("#name")
    public static TextField name;

    @UI("#password")
    public static TextField password;

    @UI("#login-button")
    public static Button loginButton;

    @UI("#user-name")
    public static Text userName;

    public static void loginAs(User user) {
        userIcon.click();
        if (user.getName() != null) {
            name.clear();
            name.sendKeys(user.getName());
        }
        if (user.getPassword() != null) {
            password.clear();
            password.sendKeys(user.getPassword());
        }
        loginButton.click();
    }

    public static boolean isHidden() {
        return !name.isDisplayed();
    }

    public static boolean isLogged(User user) {
        return userName.toString().equals(user.getUserName());
    }
}