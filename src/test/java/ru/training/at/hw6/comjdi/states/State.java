package ru.training.at.hw6.comjdi.states;

import static jdisite.JDISite.*;
import static ru.training.at.hw6.comjdi.data.UsersDataProvider.ROMAN;

public class State {
    public static void loggedIn() {
        if (userName.isHidden()) {
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(ROMAN);
        }
    }
}
